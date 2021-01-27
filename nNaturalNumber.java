/*Given a positive integer N. You have to find Nth natural number after removing all the numbers containing digit 9 .*/
/*Input:
N = 8
Output:
8
Explanation:
After removing natural numbers which contains
digit 9, first 8 numbers are 1,2,3,4,5,6,7,8
and 8th number is 8.*/
/*Expected Time Complexity: O(logN)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 1012*/

class Solution {
    long findNth(long N) {
        long ans = 0;
        long mul = 1;
        
        while(N > 0) {
            long digit = N%9;
            N /= 9;
            ans += (mul*digit);
            mul = mul*10;
        }
        return ans;
    }
}
