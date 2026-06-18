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

    public ListNode reverseList(ListNode head){
        if(head == null){
            return null;
        }
        ListNode pre = null;
        ListNode curr = head;
        ListNode temp = curr;

        while(curr != null){
           temp = curr.next;
           curr.next = pre;
           pre = curr;
           curr = temp;
        }
        return pre;
    }

    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode revNode = reverseList(slow.next);
        slow.next = null;
        ListNode curr = head;
        ListNode revnex = revNode;
        ListNode currnex = head;

        while(revNode != null && curr != null){
                revnex = revNode.next;
                currnex = currnex.next;

                curr.next = revNode;
                revNode.next = currnex;

                curr = currnex;
                revNode = revnex;
        }
        
    }
}
