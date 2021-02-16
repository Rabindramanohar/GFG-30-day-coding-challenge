/*Shortest Range In BST 
Hard Accuracy: 100.0% Submissions: 68 Points: 8
Given a BST (Binary Search Tree), find the shortest range [x, y], such that, at least one node of every level of the BST lies in the range.
If there are multiple ranges with the same gap (i.e. (y-x)) return the range with the smallest x.

Example 1:

Input:
              8
          /   \
         3     10
       /  \      \
      2    6      14
          / \     /
         4   7   12
                /  \
               11   13
Output: 6 11
Explanation: Level order traversal of the tree 
is [8], [3, 10], [2, 6, 14], [4, 7, 12], [11, 13]. 
The shortest range which satisfies the above 
mentioned condition is [6, 11]. 

Example 2:

Input:
   12
    \
     13
       \
        14
         \
          15
           \
           16

Output: 12 16
Explanation: Each level contains one node, 
so the shortest range is [12, 16].

Your Task:
You don't need to read input or print anything. Complete the function shortestRange() which takes the root of the tree as an input parameter and returns the pair of numbers

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 105
1 ≤ Node Value ≤ 104*/


class Solution {
    public Range shortestRange(Node root) {
        ArrayList<Integer> inOrder = new ArrayList<>();
        ArrayList<Integer> level = new ArrayList<>();
        
        storeInOrder(root, 0, inOrder, level);
        int i = 0, j = 0, k = 0, cntZero = 0, maxDepth = Collections.max(level)+1;
        
        int[] depth = new int[maxDepth];
        
        for(k = 0; k < level.size(); k++) {
            depth[level.get(k)]++;
            if(level.get(k) == 0) {
                j = k;
                break;
            }
        }
        for(int u : depth) {
            if(u == 0) 
                cntZero++;
        }
        
        int x = inOrder.get(0), y = inOrder.get(inOrder.size()-1);
        
        if(cntZero == 0) {
            x = inOrder.get(i);
            y = inOrder.get(j);
        }
        
        while(i <= k && j < inOrder.size()) {
            while(j < inOrder.size()) {
                if(cntZero == 0) {
                    if((y-x) > (inOrder.get(j)-inOrder.get(i))) {
                        x = inOrder.get(i);
                        y = inOrder.get(j);
                    }
                    break;
                }
                j++;
                if(j >= inOrder.size()) break;
                
                if(depth[level.get(j)] == 0)
                    cntZero--;
                
                depth[level.get(j)]++;
            }
            
            while(cntZero == 0 && i <= k) {
                if((y-x) > (inOrder.get(j) - inOrder.get(i))) {
                    x = inOrder.get(i);
                    y = inOrder.get(j);
                }
                depth[level.get(i)]--;
                
                if(depth[level.get(i)] == 0)
                    cntZero++;
                i++;
            }
        }
        
        return new Range(x, y);
    }
    public void storeInOrder(Node root, int depth, List<Integer> inOrder, List<Integer> level) {
        
        if(root == null) return;
        
        storeInOrder(root.left, depth+1, inOrder, level);
        inOrder.add(root.data);
        level.add(depth);
        storeInOrder(root.right, depth+1, inOrder, level);
        
    }
}
