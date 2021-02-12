/*132 Geeky Buildings 
Hard Accuracy: 97.78% Submissions: 559 Points: 8
There are N buildings in Linear Land. They appear in a linear line one after the other and their heights are given in the array arr[]. Geek wants to select three buildings in Linear Land and remodel them as recreational spots. The third of the selected building must be taller than the first and shorter than the second.
Can geek build the three-building recreational zone? 


Example 1:

Input:
N = 6
arr[] = {4, 7, 11, 5, 13, 2}
Output:
True
Explanation:
[4, 7, 5] fits the condition. 
Example 2:

Input:
N = 4
arr[] = {11, 11, 12, 9}
Output:
False
Explanation:
No 3 buildings fit the given condition. 

Your Task:
You don't need to read input or print anything. Complete the function recreationalSpot() which takes the array arr[] and its size N as input parameters and returns a boolean value based on whether his building selection was successful or not.
Note: The generated output will be "True" or "False".


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 104
1 ≤ arr[i] ≤ 105*/

/*class Solution{
    static boolean recreationalSpot(int[] arr , int n) {
        int currMin, currMax;
        currMin = currMax = arr[0];
        
        for (int i = 1; i < n; i++) {
        if (arr[i] < currMin) {
        currMin = arr[i];
        } else if (arr[i] > currMax) {
        currMax = arr[i];
        }
        
        if (arr[i] < currMax && arr[i] > currMin) {
        return true;
        }
        }
        
        return false;
    }
}*/

class Solution
{
    static boolean recreationalSpot(int[] arr , int n)
    {
        if (n < 3)
            return false;
        Stack < Integer > stack = new Stack < > ();
        int[] temp = new int[n];
        temp[0] = arr[0];
        for(int i = 1; i <n; i++)
            temp[i] = Math.min(temp[i - 1], arr[i]);
        
        for (int j = n - 1; j >= 0; j--)
        {
            if (arr[j] > temp[j]) 
            {
                while (!stack.empty() && stack.peek() <= temp[j])
                    stack.pop();
                if (!stack.empty() && stack.peek() < arr[j])
                    return true;
                stack.push(arr[j]);
            }
        }
        return false;
    }
}
