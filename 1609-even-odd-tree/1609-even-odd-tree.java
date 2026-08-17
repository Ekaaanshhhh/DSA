import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) return true;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int lev = 0;
        
        while (!q.isEmpty()) {
            int k = q.size();
            // Use Integer.MIN_VALUE or MAX_VALUE to track the previous node value
            int prev = (lev % 2 == 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            
            for (int i = 0; i < k; i++) {
                TreeNode cur = q.remove();
                
                // Even level: values must be ODD and STRICTLY INCREASING
                if (lev % 2 == 0) {
                    if (cur.val % 2 == 0 || cur.val <= prev) {
                        return false;
                    }
                } 
                // Odd level: values must be EVEN and STRICTLY DECREASING
                else {
                    if (cur.val % 2 != 0 || cur.val >= prev) {
                        return false;
                    }
                }
                
                // Update tracking variable
                prev = cur.val;
                
                // Queue up next level children safely
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
            lev++;
        }
        return true;
    }
}
