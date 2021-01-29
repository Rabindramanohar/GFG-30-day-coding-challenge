/*Number of minimum picks to get 'k' pairs of socks from a drawer*/
/*A drawer contains socks of n different colours. The number of socks available of ith colour is given by a[i] where a is an array of n elements. Tony wants to take k pairs of socks out of the drawer. However, he cannot see the colour of the sock that he is picking. You have to tell what is the minimum number of socks Tony has to pick in one attempt from the drawer such that he can be absolutely sure, without seeing their colours, that he will have at least k matching pairs.

Example 1:

Input:
N = 4, K = 6
a[] = {3, 4, 5, 3}
Output: 15
Explanation: 
All 15 socks have to be picked in order
to obtain 6 pairs.
Example 2:

Input: N = 2, K = 3
a[] = {4, 6}
Output: 7
Explanation: The Worst case scenario after 6
picks can be {3,3} or {1,5} or {5,1} of each
coloured socks. Hence 7th pick will ensure
3rd pair. 
Your Task:  
You don't need to read input or print anything. Complete the function find_min() which takes the array a[], size of array N, and value K as input parameters and returns the minimum number of socks Tony has to pick. If it is not possible to pick then return -1.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 105 
1 ≤ a[i] ≤ 106*/

class Solution {
    public int find_min(int[] a, int n, int k) {
        int sum = 0, complete_pairs = 0;
        for (int i = 0; i < n; i++) {
            // complete_pairs should hold the value of max
            // pairs that can be picked from the drawer
            complete_pairs += a[i] / 2;

            // sum holds the value of maximum pairs that
            // can be picked without exhausting any colour
            if (a[i] % 2 == 0)
                sum += (a[i] - 2) / 2;
            else
                sum += (a[i] - 1) / 2;
        }
        // returning -1 if required pairs is more than
        // available pairs
        if (k > complete_pairs) return -1;

        // if k is lesser than or equal to sum,
        // worst case after picking k-1 pairs is
        // 2*(k-1) socks representing k-1 pairs
        // along with n socks, each of different colour
        // one more pick after this will certainly complete kth pair
        if (k <= sum) return 2 * (k - 1) + n + 1;

        // if however, k>sum
        // the worst case is as described below-
        // 'sum' pairs are picked without exhausting any colour (2*sum picks)
        // n socks are picked, all of different colours (n picks)
        // now, no colour has more than one sock left in drawer
        // this implies, each new pick will complete a pair
        // therefore (k-sum) more picks required
        return 2 * sum + n + (k - sum);
    }
}
