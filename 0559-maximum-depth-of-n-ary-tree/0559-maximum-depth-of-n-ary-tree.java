/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    class Element{
        Node root;
        int dist;
        public Element(Node root,int dist){
            this.root = root;
            this.dist = dist;
        }
    }
    public int maxDepth(Node root) {
        if(root==null)return 0;
        Queue<Element> q = new LinkedList<>();
        q.add(new Element(root,1));
        int max_depth = 0;
        while(!q.isEmpty()){
            Element e = q.remove();
            Node top = e.root;
            int distance = e.dist;
            max_depth = Math.max(distance,max_depth);
            for(Node j:top.children){
                q.add(new Element(j,distance+1));
            }
        }
        return max_depth;
    }
}