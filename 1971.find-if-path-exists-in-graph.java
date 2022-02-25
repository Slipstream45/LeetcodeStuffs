//DFS implementation using Stack
//I did both Recursion and Stack method, Stack method has a good performance over Recurr (73ms, 132.4MB- 87% top)

import java.util.*;
class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) 
    {
        
        LinkedList<Integer> adj[] = new LinkedList[n];
        int i=0;
        for(i=0;i<n;i++)
        {
            adj[i] = new LinkedList<Integer>();
        }
        for(i=0;i<edges.length;i++)
        {
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }
        boolean[] vis = new boolean[n];
        return dfs(adj,start, end, vis);
    }
        
    public boolean dfs(LinkedList<Integer> adj[],int start, int end, boolean vis[])
    {    
         Stack<Integer> stk = new Stack<Integer>();
         vis[start]=true;
        stk.push(start);
        
        while(!stk.isEmpty())
        {
            int current = stk.pop();
            if(current == end)
            {
                return true;
            }
            for(int neighbour: adj[current])
            {
                if(!vis[neighbour])
                {
                    vis[neighbour]=true;
                    stk.push(neighbour);
                }
            }
        }
        return false;
    }
}
