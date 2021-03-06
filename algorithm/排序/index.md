# 排序
---

<a name="index"> </a>
         
## - [Z形变换](#1.1)
## - [二分查找](#1.2)

 ### <a name="1.1">Z形变换</a>([官方解答](https://leetcode-cn.com/problems/zigzag-conversion/solution/6-z-zi-xing-bian-huan-c-c-by-bian-bian-xiong/))
 
将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。(返回[目录](#index))

比如输入字符串为 "PAYPALISHIRING" 行数为 3 时,你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。

```java
class Solution {
    public String convert(String s, int numRows) {
        int n=s.length();
        if(numRows<2){
            return s;
        }
        int flag=-1;
        int i=0;
        List<StringBuffer>res=new ArrayList<StringBuffer>();
        for(int j=0;j<numRows;j++){
            res.add(new StringBuffer());
        }
        for(char c:s.toCharArray()){
            res.get(i).append(c);
            if(i==0||i==numRows-1){
                flag=-flag;
            }
            i+=flag;
        }
        StringBuffer ans=new StringBuffer();
        for(StringBuffer sb:res){
            ans.append(sb);
        }
        return ans.toString();
       
       
    }
}
```                                 
 ### <a name="1.2">二分查找</a>
 
 -[排列硬币](https://leetcode-cn.com/problems/arranging-coins/)

>首先确定循环条件(left<right),然后是是mid的选取,结束循环是left=right,根据题目返回正确值。

 | mid|left|right|
 |:---|:---:|:---:|
 |mid=(left+right)/2+1|left=mid|right=mid-1|
 |mid=(left+right)/2|left=mid+1|right=mid|
 |mid=(left+right)/2(while(left<=right)|left=mid+1|right=mid-1|
 
 
 ```java
 class Solution {
    public int arrangeCoins(int n) {
        if(n<2){
            return 1;
        }
        long index=1;
        long right=n;
        while(index<right){
            long mid=index+(right-index)/2;
            long sum=mid*(mid+1)/2;
            if(sum<n){
                index=mid+1;
            }else if(sum>n){
                right=mid;
            }else{
                return (int)mid;
            }
        }
     
        return (int)index-1;
    }
}
```

 

