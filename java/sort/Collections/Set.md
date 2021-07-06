# 对Set进行排序(Set不允许包含相同的元素)

- Set中TreeSet本身就是有序的元素，
- HashSet是根据hashcode来决定存储位置的，所以表现出来是无序的，
- LinkedSet也是根据hashcode来决定元素的存储位置，但它同时用链表来维护元素的次序，使得表现为按插入的顺序保存

对HashSet,LinkedSet排序

```java
public class TraditionalSetSortTest {
    public static void main(String[] args) {
        Set<BigDecimal> set = new HashSet<>();
        set.add(new BigDecimal(1.2).setScale(2, BigDecimal.ROUND_HALF_UP));
        set.add(new BigDecimal(2.3).setScale(2, BigDecimal.ROUND_HALF_UP));
        set.add(new BigDecimal(3.4).setScale(2, BigDecimal.ROUND_HALF_UP));
        set.add(new BigDecimal(2.4).setScale(2, BigDecimal.ROUND_HALF_UP));
        set.add(new BigDecimal(0.4).setScale(2, BigDecimal.ROUND_HALF_UP));
        set.add(new BigDecimal(9.4).setScale(2, BigDecimal.ROUND_HALF_UP));

        TreeSet<BigDecimal> sortSet = new TreeSet<>(new Comparator<BigDecimal>() {
            @Override
            public int compare(BigDecimal o1, BigDecimal o2) {
                return o1.compareTo(o2);
            }
        });
        sortSet.addAll(set);
        System.out.println(sortSet);
    }
}
--------------------------------------------------------------------------------------------
结果：[0.40, 1.20, 2.30, 2.40, 3.40, 9.40]
```
