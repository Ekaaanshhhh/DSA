/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class Solution {
    class Element{
        Node root;int dist;
        public Element(Node root,int dist){
            this.root = root;
            this.dist = dist;
        }
    }
    public ArrayList<Integer> topView(Node root) {
        // code here
       Queue<Element> q = new LinkedList<>();
       q.add(new Element(root,0));
       ArrayList<Integer> left = new ArrayList<>();
       ArrayList<Integer> right = new ArrayList<>();
       HashSet<Integer> set = new HashSet<>();
       set.add(0);
       while(!q.isEmpty()){
           int k = q.size();
           for(int i=0;i<k;i++){
                Node top = q.peek().root;
                int hd = q.peek().dist;
                q.remove();
                if(top.left!=null){
                    if(!set.contains(hd-1)){
                        left.add(top.left.data);
                        set.add(hd-1);
                    }
                    q.add(new Element(top.left,hd-1));
                }
                if(top.right!=null){
                    if(!set.contains(hd+1)){
                        right.add(top.right.data);
                        set.add(hd+1);
                    }
                    q.add(new Element(top.right,hd+1));
                }
           }
       }
       Collections.reverse(left);
       left.add(root.data);
       left.addAll(right);
       
       return left;
    }
}