/*1. Coins of Geekland 
Medium Accuracy: 100.0% Submissions: 863 Points: 4
In Geekland there is a grid of coins of size N x N. You have to find the maximum sum of coins in any sub-grid of size K x K.
Note: Coins of the negative denomination are also possible at Geekland.

Example 1:

Input: N = 5, K = 3 
mat[[]] = {1, 1, 1, 1, 1} 
          {2, 2, 2, 2, 2} 
          {3, 8, 6, 7, 3} 
          {4, 4, 4, 4, 4} 
          {5, 5, 5, 5, 5}
Output: 48
Explanation: {8, 6, 7}
             {4, 4, 4}
             {5, 5, 5}
has the maximum sum

Example 2:

Input: N = 1, K = 1
mat[[]] = {{4}} 
Output: 4
Your Task:  
You don't need to read input or print anything. Complete the function Maximum_Sum() which takes the matrix mat[], size of Matrix N, and value K as input parameters and returns the maximum sum.

Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(N2)

Constraints:
1 ≤ K ≤ N ≤ 103
-5*105 ≤ mat[i][j] ≤ 5*105*/



/*class Solution
{
    public int Maximum_Sum(int mat[][],int N,int K){
        int col = N-K+1;
        int[][] ar = new int[N][col];
        for(int j = 0; j < N; j++) {
            int sum = 0;
            for(int i = 0; i < K; i++) {
                sum += mat[j][i];
            }
            ar[j][0] = sum;
            for(int i = 1; i <= N-K; i++) {
                sum = sum - mat[j][i-1];
                sum = sum + mat[j][i+K-1];
                ar[j][i] = sum;
            }
        }
        int[][] br = new int[col][col];
        for(int j = 0; j <= N-K; j++) {
            int sum = 0;
            for(int i = 0; i < K; i++)
                sum += ar[i][j];
            br[0][j] = sum;
            for(int i = 1; i <= N-K; i++) {
                sum = sum-ar[i-1][j];
                sum = sum+ar[i+K-1][j];
                br[i][j] = sum;
            }
        }
            
        int max_val = Integer.MIN_VALUE;
        for(int i = 0; i <= N-K; i++) {
            for(int j = 0; j <= N-K; j++) {
                max_val = Math.max(max_val, br[i][j]);
            }
        }
        return max_val;
    }
}
*/

class Solution
{
    public int Maximum_Sum(int mat[][],int N,int K){
        
        int stripSum[][] = new int[N][N],sum = 0; 
            
            
        for(int j=0;j<N;j++) 
        { 
            sum = 0;
            
            for (int i=0; i<K; i++) 
                sum += mat[i][j]; 
            
            stripSum[0][j] = sum; 
    
            for (int i=1; i<N-K+1; i++) 
            { 
                sum += (mat[i+K-1][j] - mat[i-1][j]); 
                stripSum[i][j] = sum; 
            } 
        } 
        
        int max_sum = Integer.MIN_VALUE; 
        for (int i=0; i<N-K+1; i++) 
        { 
            sum = 0; 
            for (int j = 0; j<K; j++) 
                sum += stripSum[i][j];
                
            if (sum > max_sum) 
                max_sum = sum;
    
            for (int j=1; j<N-K+1; j++) 
            { 
                sum += (stripSum[i][j+K-1] - stripSum[i][j-1]);
                if (sum > max_sum) 
                    max_sum = sum;
            } 
        }
        
        return max_sum;
    }
}
