/*Check Tree Traversal 
Hard Accuracy: 49.71% Submissions: 1412 Points: 8
Given Preorder, Inorder and Postorder traversals of some tree of size N. The task is to check if they are all of the same tree or not.

Example 1:

Input:
N = 5
preorder[] = {1, 2, 4, 5, 3}
inorder[] = {4, 2, 5, 1, 3}
postorder[] = {4, 5, 2, 3, 1}
Output: Yes
Explanation: 
All of the above three traversals 
are of the same tree.
           1
         /   \
        2     3
      /   \
     4     5
Example 2:

Input:
N = 5
preorder[] = {1, 5, 4, 2, 3}
inorder[] = {4, 2, 5, 1, 3}
postorder[] = {4, 1, 2, 3, 5}
Output: No
Explanation: The three traversals can 
not be of the same tree.

Your Task:
You don't need to read input or print anything. Complete the function checktree() which takes the array preorder[ ], inorder[ ], postorder[ ] and integer N as input parameters and returns true if the three traversals are of the same tree or not. 

Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 103*/

/*class Solution
{
    static int index=0;
    
    static boolean checktree(int preorder[], int inorder[], int postorder[], int len)
    {
        if(preorder.length !=len ||inorder.length!=len||postorder.length!=len)
         return false;
        TreeNode root=buildTree(preorder,inorder,0,preorder.length-1);
        index=0;
        List<Integer> l=new ArrayList<>();
        postOrder(root,l);
        //System.out.println(l);
        int myPost[]=new int[len];
        for(int i=0;i<len;i++)
          myPost[i]=l.get(i);
        for(int i=0;i<len;i++)
          if(myPost[i]!=postorder[i])
           return false;
          
        return true;
        
       
        
    }
    static void postOrder(TreeNode root,List<Integer> l){
        if(root==null)return;
        
        postOrder(root.left,l);
        postOrder(root.right,l);
        l.add(root.data);
        
    }
    static TreeNode buildTree(int[] pre,int in[],int l,int r){
        if(l>r||index>=pre.length)
        return null;
        
        int idx=0;
        TreeNode root=new TreeNode(pre[index++]);
        for(int i=0;i<in.length;i++)
          {
              if(in[i]==root.data)
              {
                  idx=i;
                  break;
              }
          }
        root.left=buildTree(pre,in,l,idx-1);
        root.right=buildTree(pre,in,idx+1,r);
        return root;
    }
}
class TreeNode
{
    int data;
    TreeNode left,right;
    TreeNode(int data){
        this.data=data;
        left=right=null;
    }
}*/


class Solution
{
    static boolean check(int preorder[], int i1, int inorder[], int i2, int postorder[], int i3, int len)
    {
        if(len==0) return true;
        
        // if array lengths are 1, then check if all of them are equal 
        if(len==1) return ( (preorder[i1]==inorder[i2]) && (inorder[i2] == postorder[i3]) );
        
        // search for first element of preorder in inorder array 
        int idx=-1;
        for(int i=0 ; i<len ; i+=1)
            if( inorder[i2+i] == preorder[i1] )
            {
                idx = i2+i;
                break;
            }
        if(idx==-1) return false;
        
        // matching element in postorder array
        if( preorder[i1] != postorder[i3+len-1] ) return false;
        
        // nodes in left subtree =
        int left = idx-i2;
        
        // check for the left subtree 
        boolean ret1 = check(preorder, i1+1, inorder, i2, postorder, i3, left);
        
        // check for the right subtree 
        boolean ret2 = check(preorder , i1+1+left , inorder , i2+1+left , postorder , i3+left , len-left-1);
        
        // return 1 only if both of them are correct else 0 
        return (ret1 && ret2);
    }
    static boolean checktree(int preorder[], int inorder[], int postorder[], int N)
    {
        return check(preorder, 0, inorder, 0, postorder, 0, N);
    }
}
