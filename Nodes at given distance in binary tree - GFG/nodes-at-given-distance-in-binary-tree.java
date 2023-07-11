//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException
    {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            Solution T = new Solution();
            int target = Integer.parseInt(br.readLine().trim());
            int k = Integer.parseInt(br.readLine().trim());
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = T.KDistanceNodes(root,target,k);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right;
// }

class Solution
{

    // finding reference of target node

    private static Node findNode(Node root,int target){
        if(root == null)
            return null;
            
        if(root.data == target)
            return root;
            
        Node left = findNode(root.left,target);
        Node right = findNode(root.right,target);
        
        if(left != null)
            return left;
        if(right != null)
            return right;
        
        return null;
    }
    

    // store parent node for all nodes into the map


    private static void findParent(Node root,Map<Node,Node> parent){
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();

            for (int i = 0; i < size; i ++){
                Node popped = queue.poll();

                if (popped.left != null){
                    queue.add(popped.left);
                    parent.put(popped.left,popped);
                }
                if (popped.right != null){
                    queue.add(popped.right);
                    parent.put(popped.right,popped);
                }
            }
        }
    }
    


    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        if (root == null)
            return ans;
            
        Node startingNode = findNode(root,target);
        
        Map<Node,Node> parent = new HashMap<>();

        findParent(root,parent);

        Queue<Node> queue = new LinkedList<>();
        Map<Node,Integer> visited = new HashMap<>();

        queue.add(startingNode);
        visited.put(startingNode,0);

        int i = 0;

        while (i < k){
            int size = queue.size();

            for (int index = 0; index < size; index ++){
                Node popped = queue.poll();

                if (!visited.containsKey(popped.left) && popped.left != null){
                    queue.add(popped.left);
                    visited.put(popped.left,0);
                }
                if (!visited.containsKey(popped.right) && popped.right != null) {
                    queue.add(popped.right);
                    visited.put(popped.right,0);
                }
                if (parent.containsKey(popped) && !visited.containsKey(parent.get(popped))){
                    queue.add(parent.get(popped));
                    visited.put(parent.get(popped),0);
                }
            }
            i ++;
        }

        while (!queue.isEmpty()){
            pq.add(queue.poll().data);
        }
        
        while(!pq.isEmpty()){
            ans.add(pq.poll());
        }
        
        return ans;
    }
};