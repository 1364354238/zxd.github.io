```java
 package test;

  import java.util.Arrays;
  import java.util.Comparator;
  
  public class Main {
      public static void main(String[] args) {
          //注意，要想改变默认的排列顺序，不能使用基本类型（int,double, char）
          //而要使用它们对应的类
         Integer[] a = {9, 8, 7, 2, 3, 4, 1, 0, 6, 5};
         //定义一个自定义类MyComparator的对象
         Comparator cmp = new MyComparator();
         Arrays.sort(a, cmp);
         for(int i = 0; i < a.length; i ++) {
             System.out.print(a[i] + " ");
         }
     }
 }
 //Comparator是一个接口，所以这里我们自己定义的类MyComparator要implents该接口
 //而不是extends Comparator
 class MyComparator implements Comparator<Integer>{
     @Override
     public int compare(Integer o1, Integer o2) {
         //如果n1小于n2，我们就返回正值，如果n1大于n2我们就返回负值，
         //这样颠倒一下，就可以实现反向排序了
        if(o1 < o2) { 
             return 1;
         }else if(o1 > o2) {
             return -1;
         }else {
             return 0;
         }
     }
     
 }
 ```
 
 # 第二种
 ```java
 import java.util.*;
import java.lang.*;
 
class Rextester
{  
 
    public static void main(String args[])
    {
        Integer []nums={5,6,3,7,0};//注意要想自定义排序规则，就不能使用基本数据类型int,double ,char
        Arrays.sort(nums,new Comparator<Integer>(){       
            @Override
            public int compare(Integer a,Integer b){
                if(a<b){return 1;}
                else if(a>b){return -1;}
                else return 0;
            }        
        });
        for(int i:nums){
            System.out.print(i+" ");
        }
    }
}
```
 
