/*Repeated String Match 
Medium Accuracy: 100.0% Submissions: 180 Points: 4
Given two strings A and B, find the minimum number of times A has to be repeated such that B becomes a substring of the repeated A. If B cannot be a substring of A no matter how many times it is repeated, return -1.

Example 1:

Input: A = "abcd", B = "cdabcdab"
Output: 3
Explanation: After repeating A three times, 
we get "abcdabcdabcd".
Example 2:

Input: A = "aa", B = "a"
Output: 1
Explanation: B is already a substring of A.
Your Task:  
You don't need to read input or print anything. Complete the function repeatedStringMatch() which takes strings A and B as input parameters and returns the minimum number of operations to complete the task. If it is not possible then return -1.

Expected Time Complexity: O(|A| * |B|)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ |A|, |B| ≤ 103*/

/*static int repeatedStringMatch(String A, String B) { 
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        while(sb.length() < B.length()) {
            sb.append(A);
            cnt++;
        }
        
        if(sb.toString().contains(B)) return cnt;
        if(sb.append(A).toString().contains(B)) return cnt+1;
        
        return -1;
	}*/
  
  //Back-end complete function Template for Java

class Solution 
{ 
	static boolean issubstring(String str2, String rep1) 
	{ 
		int M = str2.length(); 
		int N = rep1.length(); 

		for (int i = 0; i <= N - M; i++) 
		{ 
			int j; 
			for (j = 0; j < M; j++) 
				if (rep1.charAt(i + j) != str2.charAt(j)) 
					break; 
			if (j == M) 
				return true; 
		}
		return false; 
	} 

	static int repeatedStringMatch(String A, String B) 
	{ 
		int ans = 1; 
		String S = A; 
		
		while(S.length() < B.length()) 
		{ 
			S += A; 
			ans++; 
		} 
		 
		if (issubstring(B, S)) return ans; 
		if (issubstring(B, S + A)) 
			return ans + 1; 
		return -1; 
	} 
} 
