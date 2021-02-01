/*Valid Pair Sum 
Medium Accuracy: 100.0% Submissions: 474 Points: 4
Given an array of size N, find the number of distinct pairs {a[i], a[j]} (i != j) in the array with their sum greater than 0.

Example 1:

Input: N = 3, a[] = {3, -2, 1}
Output: 2
Explanation: {3, -2}, {3, 1} are two 
possible pairs.
Example 2:

Input: N = 4, a[] = {-1, -1, -1, 0}
Output: 0
Explanation: There are no possible pairs.
Your Task:  
You don't need to read input or print anything. Complete the function ValidPair() which takes the array a[ ] and size of array N as input parameters and returns the count of such pairs.

Expected Time Complexity: O(N * Log(N))
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 105 
-104  ≤ a[i] ≤ 104*/

/*class Solution 
{ 
    static long ValidPair(int ar[], int n) { 
	    Arrays.sort(ar);
	    int low = 0, high = n-1;
	    long ans = 0;
	    while(low < high) {
	        if(ar[low]+ar[high] > 0) {
	            ans += high-low;
	            high--;
	        } else
	            low++;
	    }
	    return ans;
	}
} */

class Solution {
static long validPair(int[] ar, int N) {
  Arrays.sort(ar);
  long ans = 0;
  for(int i = 0; i < N; i++) {
    if(ar[i] <= 0)
      continue;
    // search for the first element >= (-ar[i]+1)
    int j = lowerBound(ar, ar[i]+1);
    ans += (i-j);
  }
}

static int lowerBound(int[] ar, int x) {
  int l = 0, hi = N;
  while(l < r) {
    int mid = (l+r) >>> 1;
    if(ar[mid] >= x)
      r = mid;
    else
      l = mid;
  }
  return r;
}
