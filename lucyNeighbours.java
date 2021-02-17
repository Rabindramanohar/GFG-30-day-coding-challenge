/*Lucy's Neighbours 
Medium Accuracy: 100.0% Submissions: 375 Points: 4
Lucy lives in house number X. She has a list of N house numbers in the society. Distance between houses can be determined by studying the difference between house numbers. Help her find out K closest neighbors.
Note: If two houses are equidistant and Lucy has to pick only one, the house with the smaller house number is given preference.

Example 1:

Input:
N = 5, X = 0, K = 4
a[] = {-21, 21, 4, -12, 20}, 
Output:
-21 -12 4 20
Explanation:
The closest neighbour is house
number 4. Followed by -12 and 20. -21 and 21 
are both equal distance from X=0. Therefore, 
Lucy can only pick 1. Based on the given 
condition she picks -21 as it is the smaller 
of the two. 
Example 2:

Input:
N = 6, X = 5, K = 3 
a[] = {10, 2, 14, 4, 7, 6},
Output:
4 6 7 
Your Task:  
You don't need to read input or print anything. Complete the function  Kclosest() which takes the array arr[], size of array N, X, and K as input parameters, and returns the list of numbers in sorted order.

Expected Time Complexity: O(NlogN)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ K ≤ N ≤ 105 
-104 ≤ X, arr[i] ≤ 104

Topic Tags
Related Courses
*/

/*class Solution 
{ 
	public ArrayList<Integer> Kclosest(int ar[], int n, int x, int k) {
	    
	        Arrays.sort(ar);
	       // System.out.print(Arrays.toString(ar));
	    
    	    ArrayList<Integer> al = new ArrayList<>();
            
            int left = findCrossOver(ar, 0, n-1, x);
            int right = left+1;
            int cnt = 0;
            
            // if(ar[left] == x) left--;
            
            while(left >= 0 && right < n && cnt < k) {
                if((x - ar[left]) <= (ar[right] - x))
                    al.add(ar[left--]);
                    // res[p++] = ar[left--];
                
                else
                    al.add(ar[right++]);
                    // res[p++] = ar[right++];
                cnt++;
            }
            
            // if no more element in right side
            while(cnt < k && left >= 0) {
                al.add(ar[left--]);
                // res[p++] = ar[left--];
                cnt++;
            }
            // if no more element in left side
            while(cnt < k && right < n) {
                al.add(ar[right++]);
                // res[p++] = ar[right++];
                cnt++;
            }
            Collections.sort(al);
            return al;
        }
        
        int findCrossOver(int[] ar, int low, int high, int x) {
            if(ar[high] <= x)
                return high;
            if(ar[low] > x) 
                return low;
                
            int mid = (low+high)/2;
            
            if(ar[mid] <= x && ar[mid+1] > x)
                return mid;
            
            if(ar[mid] < x)
                return findCrossOver(ar, mid+1, high, x);
            
            return findCrossOver(ar, low, mid-1, x);
        }
	}*/
  
  
  /*1) Make a max heap with first k elements.
2) For every element from (k+1)th to nth, do the following.
…..a) Find difference of current element with x.
…..b) If difference is more than root of heap, ignore current element.
…..c) Else insert the current element to the heap after removing the root.
3) Finally the heap has k closest elements.*/

//Back-end complete function Template for Java


class Info{
	int distance;
	int houseno;

	Info(int x,int y)
	{
		distance = x;
		houseno = y;
	}
}

class Compare implements Comparator<Info>{ 
	public int compare (Info p1,Info p2 )
	{
		if (p1.distance == p2.distance)	{
			if (p1.houseno < p2.houseno)
				return +1;
			if (p1.houseno > p2.houseno)
				return -1;
			return 0;
		}

		else {
		   	if (p1.distance < p2.distance)
				return +1;
			if (p1.distance > p2.distance)
				return -1;
			return 0;
		}
	}
}

class Solution 
{ 
	public  ArrayList<Integer> Kclosest(int arr[], int n, int x, int k) 
	{ 
		ArrayList<Integer> result= new ArrayList<Integer>();
		PriorityQueue<Info> pq = new PriorityQueue<Info>(k, new Compare()); 

		for (int i = 0; i < k; i++) 
		{
			Info obj = new Info(Math.abs(arr[i] - x) , arr[i] );
			pq.add(obj); 
		}

		for (int i = k; i < n; i++) 
		{ 
			int diff = Math.abs(arr[i] - x); 
			if (diff > pq.peek().distance) 
				continue; 

			if (diff == pq.peek().distance && arr[i] > pq.peek().houseno) 
				continue; 

			pq.remove();
			Info obj = new Info(Math.abs(arr[i] - x) , arr[i] );
			pq.add(obj);
		} 
		while (pq.size() >0) { 
			result.add(pq.peek().houseno);
			pq.remove();
		}
		Collections.sort(result);
		return result;
	}    
} 
