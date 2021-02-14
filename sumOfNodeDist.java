/*Valentine Sum 
Medium Accuracy: 100.0% Submissions: 124 Points: 4
Cupid wants to strike maximum houses in Geek Land on Valentine's Day. The houses in Geek Land are arranged in the form of a binary tree. Cupid is standing at target node initially. 
Find the sum of all nodes within a maximum distance k from target node. The target node should be included in the sum.


Example 1:

Input:
                   1
                 /    \
                2      9
               /      /  \
              4      5     7
            /   \         /  \
           8     19     20    11
          /     /  \
         30   40   50
target = 9, K = 1
Output:
22
Explanation:
Nodes within distance 1 from 9 are 9, 5, 7, 1  
Example 2:

Input:
                   1
                 /    \
                2      9
               /      /  \
              4      5     7
            /   \         /  \
           8     19     20    11
          /     /  \
         30   40   50
target = 40, K = 2
Output:
113
Explanation:
Nodes within distance 2 from 40 are 40, 19, 50, 4

Your Task:
You don't need to read input or print anything. Complete the function sum_at_distK() which takes the root of the tree, target, and K  as input parameter and returns the sum of all nodes within a max distance of k from the target


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N, Node Value ≤ 105
1 ≤ K ≤ 20*/

/*
// node structure:

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

*/

class Solution{
    static int sum;
    static int sum_at_distK(Node root, int target, int k){
        sum = 0;
        traverse(root, target, k);
        return sum;
    }
    static int traverse(Node root, int target, int k) {
        if(root == null)
            return -1;
        
        if(root.data == target) {
            add_subtree(root, k);
            return k-1;
        }
        
        int d = traverse(root.left, target, k);
        if(d != -1) {
            sum += root.data;
            add_subtree(root.right, d-1);
            return d-1;
        }
        d = traverse(root.right, target, k);
        if(d != -1) {
            sum += root.data;
            add_subtree(root.left, d-1);
            return d-1;
        }
        return -1;
    }
    
    static void add_subtree(Node root, int dist) {
        if(root == null || dist < 0)
            return;
        sum += root.data;
        add_subtree(root.left, dist-1);
        add_subtree(root.right, dist-1);
    }
}
