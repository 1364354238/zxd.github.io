# 对Map进行排序（Key唯一）

- HashMap:它根据key的HashCode值来存储数据,根据key可以直接获取它的Value，同时它具有很快的访问速度。key,value可为null
- TreeMap:根据key来排序，默认升序，key不能为null;
- HashSet:key,value不能为null,支持线程同步（任意一时刻只有一个线程能写Hashtable），也导致了它写入的速度较慢；
- LinkedHashMap:保存了记录的插入顺序，在遍历的时候会比HashMap慢。key和value均允许为空

# 排序方法

- 直接用TreeMap,根据需求修改Comparator;
- 将Map转换为List，然后用Collections.sort()排序

```java
public class TreeMapTest {
    public static void main(String[] args) {
        Map<String, String> map = new TreeMap<String, String>();
        map.put("d", "ddddd");
        map.put("b", "bbbbb");
        map.put("a", "aaaaa");
        map.put("c", "ccccc");
        
        //这里将map.entrySet()转换成list
        List<Map.Entry<String,String>> list = new ArrayList<Map.Entry<String,String>>(map.entrySet());
      
        //然后通过比较器来实现排序
        Collections.sort(list,new Comparator<Map.Entry<String,String>>() {
            //升序排序
            public int compare(Entry<String, String> o1,
                    Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
            
        });
    }
}
```
