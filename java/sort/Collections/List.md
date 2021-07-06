# 对List排序

对于一个类来说，它是如果含有compareTo方法就代表这个类是可比较的。

```java
public class Student implements Comparable<Student> {
    private int id;
    private int age;
    private String name;

    public Student(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }
    @Override
    public int compareTo(Student o) {
        //降序
        //return o.age - this.age;
        //升序
        return this.age - o.age;        
    }
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
```
该类默认的是age升序排列
```java
public static void main(String args[]){
        List<Student> list = new ArrayList<>();
        list.add(new Student(1,25,"关羽"));
        list.add(new Student(2,21,"张飞"));
        list.add(new Student(3,18,"刘备"));
        list.add(new Student(4,32,"袁绍"));
        list.add(new Student(5,36,"赵云"));
        list.add(new Student(6,16,"曹操"));
        System.out.println("排序前:");
        for (Student student : list) {
            System.out.println(student.toString());
        }
        //使用默认排序
        Collections.sort(list);
        System.out.println("默认排序后:");
        for (Student student : list) {
            System.out.println(student.toString());
        }
}
```
如果想自定义排序方式就需要重比较器

** 重写的方式主要有两种:

- Collections.sort(list,Comparator<T>);
- list.sort(Comparator<T>);

```java
//第一种
  Collections.sort(list,new Comparator<Student>()){
  @Override
  //改为对id降序排列
  public int compare(Student s1,Student s2){
    return s2.getId()-s2.getId();
  }
//第二种
  //改为对id升序排列
list.sort(new Comparator<Student>() {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getId() - o2.getId();
    }
});
  ```

  
