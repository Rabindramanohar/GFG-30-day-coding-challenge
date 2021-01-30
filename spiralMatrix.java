/*Given a matrix of size N x M. You have to find the Kth element which will obtain while traversing the matrix spirally starting from the top-left corner of the matrix.

Example 1:

Input: 
N = 3, M = 3, K = 4
A[] = {{1, 2, 3}, 
       {4, 5, 6}, 
       {7, 8, 9}}
Output: 
6
Explanation: Spiral traversal of matrix: 
{1, 2, 3, 6, 9, 8, 7, 4, 5}. Fourth element
is 6.
Example 2:

Input: 
N = 2, M = 2, K = 2 
A[] = {{1, 2},
       {3, 4}} 
Output: 
2
Explanation: Spiral traversal of matrix: 
{1, 2, 4, 3}. Second element is 2.
Your Task:  
You don't need to read input or print anything. Complete the function findK() which takes the matrix A[ ][ ], number of rows N, number of columns M, and integer K as input parameters and returns the Kth element in the spiral traversal of the matrix.

Expected Time Complexity: O(N*M)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ K ≤ N*M ≤ 106*/




class Solution
{
   
	public int findK(int a[][], int n, int m, int k)
	{
		int top = 0;
        int left = 0;
        int right = m-1;
        int bottom = n-1;
        int dir =0;
        int count=0;
     
        while(top<=bottom && left<=right)
        {
            if(dir==0)
            {
                for(int i=left ;i<=right;i++)
                {
                    k--;
                    if(k == 0)
                    return (a[top][i]);
                }
                top++;
                dir=1;
                
            }
            if(dir==1)
            {
                for(int i=top;i<=bottom;i++)
                {
                    k--;
                    if(k == 0)
                    return (a[i][right]);
                }
                right--;
                dir=2;
                
               
            }
            if(dir==2)
            {
                for(int i=right;i>=left;i--)
                {
                    k--;
                    if(k == 0)
                    return (a[bottom][i]);
                }
                bottom--;
                dir=3;
            }
            if(dir==3)
            {
                for(int i=bottom;i>=top;i--)
                {
                    k--;
                    if(k == 0)
                    return (a[i][left]);
                }
                left++;
                dir=0;
            }
            
        }
        
        return -1;
        
	}
	
}


/*Given a matrix of size N x M. You have to find the Kth element which will obtain while traversing the matrix spirally starting from the top-left corner of the matrix.

Example 1:

Input: 
N = 3, M = 3, K = 4
A[] = {{1, 2, 3}, 
       {4, 5, 6}, 
       {7, 8, 9}}
Output: 
6
Explanation: Spiral traversal of matrix: 
{1, 2, 3, 6, 9, 8, 7, 4, 5}. Fourth element
is 6.
Example 2:

Input: 
N = 2, M = 2, K = 2 
A[] = {{1, 2},
       {3, 4}} 
Output: 
2
Explanation: Spiral traversal of matrix: 
{1, 2, 4, 3}. Second element is 2.
Your Task:  
You don't need to read input or print anything. Complete the function findK() which takes the matrix A[ ][ ], number of rows N, number of columns M, and integer K as input parameters and returns the Kth element in the spiral traversal of the matrix.

Expected Time Complexity: O(N*M)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ K ≤ N*M ≤ 106*/
