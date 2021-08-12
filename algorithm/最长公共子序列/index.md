# 一般用动态规划解决(子序列是 按顺序但可不连续的子序列）

- 字符串A,B
- dp[i][j]： A[i]到B[j]的最长子序列

```java
  if(A[i]==B[j]){
    dp[i][j]=dp[i-1][j-1]+1;
  }else{
    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
  }
  ```
  
  ## 时间复杂度O(n*n)
