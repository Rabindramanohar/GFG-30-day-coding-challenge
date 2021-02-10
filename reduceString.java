/*Restrictive Candy Crush 
Medium Accuracy: 68.63% Submissions: 270 Points: 4
Given a string S and an integer K, the task is to reduce the string by applying the following operation:
Choose a group of K consecutive identical characters and remove them. The operation can be performed any number of times until it is no longer possible.

Example 1:

Input:
K = 2
S = "geeksforgeeks"
Output:
gksforgks
Explanation:
Modified String after each step: 
"geegsforgeeks" -> "gksforgks"
Example 2:

Input:
K = 2
S = "geegsforgeeeks" 
Output:
sforgeks
Explanation:
Modified String after each step:
"geegsforgeeeks" -> "ggsforgeks" -> "sforgeks"
Your Task:  
You don't need to read input or print anything. Complete the function Reduced_String() which takes integer K and string S as input parameters and returns the reduced string.

Expected Time Complexity: O(|S|)
Expected Auxiliary Space: O(|S|)

Constraints:
1 ≤ |S| ≤ 105
1 ≤ K ≤ |S|*/

/*class Solution
{
    public static String reduced_String(int k, String str) {
        Stack<Entity> st = new Stack<>();
        int i = 0;
        for(i = 0; i < str.length(); i++) {
            char x = str.charAt(i);
        if(st.size() > 0 && st.peek().frequency == k) {
            char curr = st.peek().character;
            while(st.size() > 0 && st.peek().character == curr) {
                st.pop();
            }
        }
        // st is not empty and top ele of stack == x
        if(st.size() > 0 && st.peek().character == x) {
            Entity new_top = new Entity(x, st.peek().frequency+1);
            st.push(new_top);
        } else {
            Entity new_top = new Entity(x, 1);
            st.push(new_top);
        }
    }
    
    // if last push character has k freq then pop the top k character
    if(st.size() > 0 && st.peek().frequency == k) {
        char curr = st.peek().character;
        while(st.size() > 0 && st.peek().character == curr)
            st.pop();
    }
            
        String stack_str = "";
        while(st.size() > 0)
            stack_str += st.pop().character;
            
        
        String ans_str = "";    
        for(i = stack_str.length()-1; i >= 0; i--) {
            ans_str += stack_str.charAt(i);
        }
    return ans_str;
}
    
    static class Entity {
        char character;
        int frequency;
        Entity(char p, int q) {
            this.character = p;
            this.frequency = q;
        }
    }
}*/

/*class Solution
{
    public static String reduced_String(int k, String s) {
        String reg = "([a-z])"+"\\1"+"{"+(k-1)+"}";
        for(int i = 1; i < s.length()/2; i++) {
            if(s.length() == (s=s.replaceAll(reg, "")).length())
                break;
        }
        return s;
    }
}*/

class Pair{
    char c;
    int ctr;
    Pair(char c,int ctr)
    {
        this.c = c;
        this.ctr = ctr;
    }
}
class Solution
{
    public static String reduced_String(int k, String s)
    {
        if(k == 1){
            String ans = "";
            return ans;
        }
        Stack<Pair> st = new Stack<Pair>();
        int l = s.length();
        int ctr = 0;
        for(int i=0;i<l;i++)
        {
            if(st.size() == 0)
            {
                st.push(new Pair(s.charAt(i),1));
                continue;
            }
            if(st.peek().c == s.charAt(i))
            {
                Pair p = st.peek();
                st.pop();
                p.ctr += 1;
                if(p.ctr == k)
                {
                    continue;
                }
                else
                {
                    st.push(p);
                }
            }
            else{
                 st.push(new Pair(s.charAt(i),1));
            }
        }
        String ans = "";
        while(st.size() > 0)
        {
            char c = st.peek().c;
            int cnt = st.peek().ctr;
            while(cnt-- > 0)
                ans = c + ans;
            st.pop();
        }
        return ans;
    }
}
