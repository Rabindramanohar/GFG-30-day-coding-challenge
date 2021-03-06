/*Corona Vaccine 
Hard Accuracy: 100.0% Submissions: 143 Points: 8
Geek has developed an effective vaccine for Corona virus and he wants each of the N houses in Geek Land to have access to it. Given a binary tree where each node represents a house in Geek Land, find the minimum number of houses that should be supplied with the vaccine kit if one vaccine kit is sufficient for that house, its parent house and it's immediate child nodes.  

 

Example 1:

Input:
    1
   / \
  2   3 
        \
         4
          \
           5
            \
             6

Output:
2
Explanation:
The vaccine kits should be 
supplied to house numbers 1 and 5. 
Example 2:

Input:
    1
   / \
  2   3 
Output:
1
Explanation:
The vaccine kits should be 
supplied to house number 1.

Your Task:
You don't need to read input or print anything. Complete the function supplyVaccine() which takes the root of the housing tree as input parameter and returns the minimum number of houses that should be supplied with the vaccine kit.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 105*/

//Back-end complete function Template for Java

class Solution
{
    static int ans = 0;
    
    public static int post(Node node)
    {
        boolean zero = false , two = false;
        if(node.left==null && node.right==null)
            return 0;
        
        if(node.left!=null)
        {
            int get = post(node.left);
            if(get==0)
                zero = true;
            if(get==2)
                two = true;
            
        }
        
        if(node.right!=null)
        {
            int get = post(node.right);
            if(get==0)
                zero = true;
            if(get==2)
                two = true;
        }
        
        if(zero==true)
        {
            ans++;
            return 2;
        }
        
        if(two==true)
        {
            return 1;
        }
        return 0; 
    }

    public static int supplyVaccine(Node root)
    {
        ans = 0;    
        int result = post(root);
        if(result==0)
            return ans + 1;
        return ans;
    }
}
