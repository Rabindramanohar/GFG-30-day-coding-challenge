/*Elixir of Life 
Hard Accuracy: 100.0% Submissions: 274 Points: 8
Flamel is making the Elixir of Life but he is missing a secret ingredient, a set of contiguous plants (substring) from the Garden of Eden. The garden consists of various plants represented by string S where each letter represents a different plant.  But the prophecy has predicted that the correct set of plants required to make the potion will appear in the same contiguous pattern (substring) at the beginning of the forest (prefix), the end of the forest (suffix), and will also be the most frequent sequence present in the entire forest.

Identify the substring of plants required to make the elixir and find out the number of times it appears in the forest. 

Example 1:

Input: S = "ababaaaab"
Output: 3
Explanation: substring "ab" is a prefix, 
a suffix and appears 3 times.

Example 2:

Input: S = "aaaa"
Output: 4
Explanation: substring "aaaa" occurs 1 time, 
substring "aaa" occurs 2 times, substring 
"aa" occurs 3 times, substring "a" occurs 
4 times. All of them are proper prefixes 
and suffixes. But, "a" has the maximum 
frequency.
Example 3:

Input: S = "abcdef"
Output: 1

Your Task: 
You don't need to read input or print anything. Complete the function maxFrequency() which takes string S as input parameter and returns the answer

Expected Time Complexity: O(NlogN)
Expected Auxiliary Space: O(N)


Constraints: 
1 ≤ |S| ≤ 105

Topic Tags*/

class Sol
{
    ArrayList<Integer> z_function(String s)
{
	int n = s.length();
	ArrayList<Integer> z = new ArrayList<Integer>(n);
	
	for(int i = 0 ;i<n;i++)
	    z.add(i,0);

	for(int i = 1, l = 0, r = 0; i < n; i++)
	{

		if(i <= r)
			z.set(i , Math.min(r - i + 1, z.get(i - l)) );
		
		while(i + z.get(i) < n && s.charAt(z.get(i)) == s.charAt(i + z.get(i)) )
			z.set(i , z.get(i) + 1);
		
		
		if(i + z.get(i) - 1 > r)
		{
			l = i;
			r = i + z.get(i) - 1;
		}
	}
	
    return z;
}
        
 
 
void update(int idx, int val, ArrayList<Integer> bit, int n)
{
	if(idx == 0)
		return;

	while(idx <= n)
	{
		bit.set(idx , bit.get(idx) + val);
		idx += (idx&-idx);
	}
}
 
 
int pref(int idx, ArrayList<Integer> bit)
{
	int ans = 0;
	while(idx > 0)
	{
		ans += bit.get(idx); 
		idx -= (idx&-idx);
	}	

	return ans;
}


int maxFrequency(String str)
{
	int n = str.length();
	ArrayList<Integer> z = z_function(str);
	

	ArrayList<Integer> bit = new ArrayList<Integer>(n + 5);
	for(int i = 0 ;i<n + 5;i++)
    	    bit.add(i,0);
	
	for(int i = 1; i < n; i++)
		update(z.get(i), 1, bit, n);


    TreeMap<Integer,Integer> m = new TreeMap<Integer,Integer>();

	for(int i = n-1; i >= 1; i--)
	{
		if(z.get(i) != (n-i))
			continue;
		
		if(m.containsKey(z.get(i)))
		    {
		        m.put(z.get(i), m.get(z.get(i)) +   (pref(n, bit) - pref(z.get(i) - 1, bit) + 1)  ); 
		    }
		else
		    m.put(z.get(i) , (pref(n, bit) - pref(z.get(i) - 1, bit) + 1) );
	
	}
	
	int ans = 1;
	
	for(Map.Entry<Integer,Integer> entry : m.entrySet())
		ans = Math.max(ans, entry.getValue());

	return ans;
}
}
