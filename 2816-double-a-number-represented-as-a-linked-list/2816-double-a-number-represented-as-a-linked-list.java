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
    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev=curr;
            curr=next;
        }

        return prev;
    }
    public ListNode doubleIt(ListNode head) {
        head = reverse(head);
        int carry=0;
        ListNode temp = head;
        while(temp!=null){
            int value = carry+temp.val*2;
            temp.val = value%10;
            carry = value/10;

            temp=temp.next;
        }
        if(carry!=0){
            ListNode newnode = new ListNode(carry);
            newnode.next = reverse(head);
            head = newnode;
            return head;
        }
        else{
            return reverse(head);
        }
        
    }
}