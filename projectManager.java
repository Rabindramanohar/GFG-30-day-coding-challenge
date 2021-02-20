/*Project Manager 
Medium Accuracy: 100.0% Submissions: 48 Points: 4
An IT company is working on a large project. The project is broken into N modules and distributed to different teams. The amount of time (in months) required to complete each module is given in an array duration[ ]. Two modules can be processed simultaneously only if their is no dependency between them and it is given that M modules have interdependecies. 
As the project manager, compute the minimum time required to complete the project.

Example 1:

Input:
N = 6 6
duration[] = {1, 2, 3, 1, 3, 2}
dependencies:
5 2
5 0
4 0 
4 1
2 3
3 1
Output: 
8
Explanation: 
graph
The Graph of dependency forms this and 
the project will be completed when Module 
1 is completed which takes 8 months.
Example 2:

Input:
N = 3 3
duration[] = {5, 5, 5}
dependencies:
0 1
1 2
2 0
Output: 
-1
Explanation: 
There is a cycle in the dependency graph 
hence the project cannot be completed.
Your Task:
Complete the function minTime() which takes N, M, duration array, and dependencies array as input parameter and return the minimum time required. Return -1 if the project can not be completed. 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 105
1 ≤ M ≤ 2*105
1 ≤ duration[i] ≤ 105

Topic Tags*/

// Back-end complete function Template for Java

class Solution {
    class cycleHelper {
        boolean[] visited;
        boolean[] isStack;
        cycleHelper(int n) {
            this.visited = new boolean[n];
            this.isStack = new boolean[n];
        }
    }
    // refer https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
    // for cycle detection in directed graph
      public boolean
        checkCycle(int nd, ArrayList<ArrayList<Integer>> adj,
                   cycleHelper cyHlp) {
        // insert into stack
        cyHlp.isStack[nd] = true;
        for (int it : adj.get(nd)) {
            // if next node is visited
            if (cyHlp.visited[it] == true) {
                // if the node is in stack then cycle is found
                if (cyHlp.isStack[it] == true) return true;
                continue;
            }
            cyHlp.visited[it] = true;
            if (checkCycle(it, adj, cyHlp)) return true;
        }
        // removing from stack
        cyHlp.isStack[nd] = false;
        return false;
    }
    /*
        nd: current node
        adj: adjacency list of the graph
        duration: time to complete each module
        reqTime: time to complete project from ith module to end
    */
    public int dfs(int nd, ArrayList<ArrayList<Integer>> adj, int[] duration,
            int[] reqTime) {
        // return the time to complete the project starting from the node i if
        // it is
        // already calculated
        if (reqTime[nd] != -1) return reqTime[nd];
        int maxi = 0;
        for (int it : adj.get(nd)) {
            maxi = Math.max(maxi, dfs(it, adj, duration, reqTime));
        }
        // time to complete this module and maximum time to complete child
        // modules
        reqTime[nd] = maxi + duration[nd];
        return reqTime[nd];
    }
    public int minTime(ArrayList<pair> dependency, int[] duration, int n, int m) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        // stores number of modules should be completed before ith module
        int[] independent = new int[n];
        for (int i = 0; i < m; i++) {
            // create graph from dependency of modules
            adj.get(dependency.get(i).x).add(dependency.get(i).y);
            independent[dependency.get(i).y]++;
        }

        int flag = 0;
        for (int i = 0; i < n; i++) {
            // if independent module or not
            if (independent[i] == 0) {
                flag = 1;
            }
        }
        // no independent module return -1
        if (flag == 0) {
            return -1;
        }
        cycleHelper cyHlp = new cycleHelper(n);
        for (int i = 0; i < n; i++) {
            if (independent[i] != 0) {
                continue;
            }
            cyHlp.visited[i] = true;
            // check if cycle is present then return -1
            if (checkCycle(i, adj, cyHlp)) return -1;
        }
        int[] reqTime = new int[n];
        Arrays.fill(reqTime, -1);
        int ans = 0;
        // starting from any independent module find the maximum time to
        // complete
        // the project
        for (int i = 0; i < n; i++)
            if (independent[i] == 0)
                ans = Math.max(ans, dfs(i, adj, duration, reqTime));

        return ans;
    }
}
