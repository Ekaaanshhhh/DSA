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
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode prev=null;
        ListNode curr=slow;
        ListNode next=null;
        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        ListNode last=prev;
        ListNode first=head;
        while(first.next!=last && last!=first && last!=null && first!=null)
        {
            ListNode tobef=first.next;
            ListNode tobel=last.next;
            first.next=last;
            last.next=tobef;
            first=tobef;
            last=tobel;
        }
    }
}