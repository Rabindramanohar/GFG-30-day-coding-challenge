/*Ruling Pair 
Medium Accuracy: 100.0% Submissions: 84 Points: 4
Geek Land has a population of N people and each person's ability to rule the town is measured by a numeric value arr[i]. The two people that can together rule Geek Land must be compatible with each other i.e., the sum of digits of their ability arr[i] must be equal. Their combined ability should be maximum amongst all the possible pairs of people. Find the combined ability of the Ruling Pair.

Example 1:

Input:
N = 5
arr[] = {55, 23, 32, 46, 88}
Output:
101
Explanation:
All possible pairs that are 
compatible with each other are- (23, 32) 
with digit sum 5 and (55, 46) with digit 
sum 10. Out of these the maximum combined 
ability pair is (55, 46) i.e. 55 + 46 = 101
Example 2:

Input:
N = 4
arr[] = {18, 19, 23, 15}
Output:
-1
Explanation:
No two people are compatible with each other. 
Your Task:  
You don't need to read input or print anything. Complete the function RulingPairâ€‹() which takes the array arr[] and size of array N as input parameters and returns the answer. If No two people are compatible with
each other then return -1.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 105 
1 ≤ arr[i] ≤ 109*/

/*class Solution { 
	static int RulingPair(int arr[], int len) { 
        HashMap<Integer,Integer> h=new HashMap<>();
        int sum=-1;
        for(int n : arr) {
            int dig=0;
            int num=n;
            
            for(dig = 0; n > 0; dig += n%10, n /= 10);
            
            if(h.containsKey(dig)) {
                
                int curr=h.get(dig);
                sum=Math.max(sum,curr+num);
                if(num>curr)
                  h.put(dig,num);
                  
            }
            else
                h.put(dig,num);
        }
        return sum;
	}    
} */

//Back-end complete function Template for Java

class Solution 
{ 
	static int digitSum(int n) { 
		int sum = 0; 
		while (n != 0) 
		{ 
			sum += (n % 10); 
			n /= 10; 
		} 
		return sum; 
	} 
	
	static int RulingPair(int arr[], int n) { 
	
		HashMap<Integer, Integer> mp = new HashMap<Integer,Integer>(); 
		
		for (int i = 0; i < 1000 ; i++) 
		{ 
			mp.put(i, 0); 
		} 
		
		int ans = -1; 

		for (int i = 0; i < n; i++) 
		{ 
			// Finding the digit sum of arr[i] 
			int dSum = digitSum(arr[i]); 
			
			if ((int)mp.get(dSum) != 0) 
			{ 
				ans = Math.max(ans, (int)mp.get(dSum) + arr[i]); 
			} 
			mp.put(dSum,Math.max((int)mp.get(dSum), arr[i])) ; 
		} 
		return ans; 
	}   
