/* Definition for Node
class Node
{
    int data;
    Node left;
    Node right;
    Node(int val)
    {
        this.data = val;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public ArrayList<ArrayList<Integer>> paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> allpath = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        helper(root,allpath,path);
        return allpath;
    }
    public void helper(Node root,ArrayList<ArrayList<Integer>> allpath,ArrayList<Integer> path){
        if(root==null)return;
        
        path.add(root.data);
        if(root.left==null && root.right==null){
            allpath.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }
        helper(root.left,allpath,path);
        helper(root.right,allpath,path);
        path.remove(path.size()-1);
    }
}