class Solution {
    //Declared wrapper class because no need to initialise values, will be null defaultly  
    Integer dp[][]=new Integer[101][10001];
    public int superEggDrop(int K, int N) {
      
        if(K==1)//when there is only one egg
            return N;
        
        if(N==0 || N==1)//when no. of floors are 0 or 1
            return N;
        
        if(dp[K][N]!=null)//checking if it is filled
            return dp[K][N];
        
        int i,l=1,h=N;
        int ans=Integer.MAX_VALUE;

//         while(l<=h)
//         {
//             int mid=(l+h)/2;
            
//             int down_temp=superEggDrop(K-1,mid-1);//If egg breaks go down
//             int up_temp=superEggDrop(K,N-mid);//if egg doesn't break go u   p
            
//             int temp=1+Math.max(down_temp,up_temp); //adding one because we have used 1 attempt and max of up and down because we need worst case attempts from both
            
//             if(down_temp<up_temp)//if down attempts are less we only require upper ones and vise versa
//                 l=mid+1;
//             else 
//                 h=mid-1;
           
        for(int k =1; k<=N; k++) {
            int down_temp=superEggDrop(K-1,N-1);//If egg breaks go down
            int up_temp=superEggDrop(K,N-k);//if egg doesn't break go u   p
            
            int temp=1+Math.max(down_temp,up_temp); //adding one because we have used 1 attempt and max of up and             
            ans=Math.min(temp,ans);//this is beacuse we need minimum of all worst case attempts 
        }
        return dp[K][N]=ans;
    }
}
// class Solution {
//     public int superEggDrop(int K, int N) {
//         int dp[][] = new int[K+1][N+1];
        
//         for(int i = 1; i <=K; i++){
//             for(int j = 1; j <= N; j++){
//                 if(j == 1) dp[i][j] = 1;
//                 else if( i == 1 ) dp[i][j] = j;
//                 else {
//                     int min = Integer.MAX_VALUE;
//                     for(int a=j-1,b =0; a >= 0; a--,b++) {
//                         int tempMin = Math.max(dp[i-1][b], dp[i][a]);
//                         min = Math.min(min,tempMin);
//                     }
//                     dp[i][j] = min+1;
//                 }
//             }
//         }
//         return dp[K][N];
//     }
// }