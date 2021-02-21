/*Police and Thieves 
Medium Accuracy: 69.19% Submissions: 214 Points: 4
Given an array of size n such that each element contains either a 'P' for policeman or a 'T' for thief. Find the maximum number of thieves that can be caught by the police. 
Keep in mind the following conditions :

Each policeman can catch only one thief.
A policeman cannot catch a thief who is more than K units away from him.
Example 1:

Input:
N = 5, K = 1
arr[] = {P, T, T, P, T}
Output: 2
Explanation: Maximum 2 thieves can be 
caught. First policeman catches first thief 
and second police man can catch either second 
or third thief.
Example 2:

Input:
N = 6, K = 2
arr[] = {T, T, P, P, T, P}
Output: 3
Explanation: Maximum 3 thieves can be caught.
Your Task:  
You dont need to read input or print anything. Complete the function catchThieves() that takes n, k and arr[ ] as input parameters and returns the maximum number of thieves that can be caught by the police. 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ n ≤ 105
1 ≤ k ≤ 100
arr[i] = 'P' or 'T'*/

class Solution 
{ 
    static int catchThieves(char ar[], int n, int k) { 
        int res = 0;
        ArrayList<Integer> police = new ArrayList<>();
        ArrayList<Integer> thief = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            if(ar[i] == 'P')
                police.add(i);
            else if(ar[i] == 'T')
                thief.add(i);
        }
        
        int l = 0, r = 0;
        while(l < thief.size() && r < police.size()) {
            if(Math.abs(thief.get(l)-police.get(r)) <= k) {
                res++;
                l++;
                r++;
            } else if(thief.get(l) < police.get(r))
                l++;
            else
                r++;
        }
        return res;
	} 
} 
