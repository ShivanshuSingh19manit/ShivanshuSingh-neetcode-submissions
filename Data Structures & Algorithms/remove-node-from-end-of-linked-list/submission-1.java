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
        ArrayList<ListNode> ll = new ArrayList<>();
        ListNode curr = head;
        while(curr != null){
            ll.add(curr);
            curr = curr.next;
        }
        int size = ll.size();
        ll.remove(size-n);
        if(ll.size() == 0){
            return null;
        }
        ListNode temp = new ListNode();
        ListNode curr1 = temp;
        for(int i=0;i<ll.size();i++){
           temp.next =  ll.get(i);
           temp = temp.next;
        }
        temp.next = null;
        return curr1.next;
    }
}
