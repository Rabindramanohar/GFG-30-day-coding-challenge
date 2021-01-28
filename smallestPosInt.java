/*Given an array of size N, find the smallest positive integer value that cannot be represented as sum of some elements from the array.


Example 1:

Input: 
N = 6
array[] = {1, 10, 3, 11, 6, 15}
Output: 
2
Explanation:
2 is the smallest integer value that cannot 
be represented as sum of elements from the array.*/

/*Expected Time Complexity: O(N * Log(N))
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 106
1 ≤ array[i] ≤ 109
Array may contain duplicates.*/

class Solution { 
    long smallestpositive(long[] ar, int n){ 
        Arrays.sort(ar);
        long res = 1;
        for(int i = 0; i < n && ar[i] <= res; i++) {
            res += ar[i];
        }
        return res;
    }
} 
