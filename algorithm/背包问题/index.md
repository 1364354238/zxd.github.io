# 如何解决背包问题

- [经典背包问题](#经典)
- [三维背包问题](#三维)
- [如何将问题转换为背包问题](#转换)
- [背包问题的降维](#降维) 

### <a name='经典'>经典背包问题</a>
  <有一个容量为target的背包，现有n个物体，weight[i]表示第i个物体的重量,value[i]表示第i个物体的价值，求背包能装的最大价值物体。
  
  动态规划，dp[i][j]表示在前i个当中**任意取**，放入容量为j的背包里的最大价值。
  
  状态方程dp[i][j]=max(dp[i-1][j],dp[i-1][j-weight[i-1]]+value[i-1])
  
  注意边界条件dp[0][0]的值,不同问题值可能不同
```java
class solution{
  public int MaxValue(int []weight,int []value,int target){
    int n=weight.length;
    int [][]dp=new int[n+1][target+1];
    //i取1，因为dp[i]表示前i个，对应的weight,value的下标为i-1
    for(int i=1;i<=n;i++){
      for(int j=0;j<=target;j++){
        dp[i][j]=dp[i-1][j];
        if(j>weight(i-1)){
          dp[i][j]=Math.max(dp[i][j],dp[i-1][j-weight[i-1]]+value[i-1]);
        }
      }
    }
    return dp[n][target];
  }
}
```

### <a name='三维'>三维背包问题</a>
  <在经典背包问题中，只要满足剩余的背包容量大于weight[i]就可以将它装入，而三维背包问题则是在二维的基础上再加了一个限制条件，例如
要求装入背包的物体value总价值>=3，这就相当于有了两个变量

  dp[i][j][k]即在前i个物体任取总价值value>=k物体,放入容量为j的背包当中所得到的最大价值
  
  状态方程：dp[i][j][k]=dp[i-1][j-weight[i-1]][max(0,k-value[i-1]]
### <a name='转换'>如何将问题转换为背包问题</a>

### <a name='降维'>背包问题的降维</a>
