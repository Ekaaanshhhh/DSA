/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int numComponents(ListNode head, int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i:nums){
            set.add(i);
        }

        ListNode temp = head;
        int count=0;
        while(temp!=null && temp.next!=null){
            if(set.contains(temp.val)&&set.contains(temp.next.val))count++;
            temp=temp.next;
        }
        return count+(nums.length-count*2);
    }
}