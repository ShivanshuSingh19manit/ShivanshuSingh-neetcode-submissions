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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode curr = head;
        while(curr != null){
            size++;
            curr = curr.next;
        }
        int k = size-n;
        if(k == 0){
            return head.next;
        }
        ListNode slow = head;
        
        while(k != 1){
            k--;
            slow = slow.next;
        }
        // System.out.println(slow.val);
        if(slow.next != null){
        slow.next = slow.next.next;
        }

        return head;

    }
}
