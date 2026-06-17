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
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ArrayList<Integer> ll = new ArrayList<>();
        while(head != null){
            ll.add(head.val);
            head = head.next;
        }
        Collections.reverse(ll);
        ListNode root = new ListNode(ll.get(0));
        ListNode ans = root;
        for(int i=1;i<ll.size();i++){
            ListNode temp = new ListNode(ll.get(i));
            root.next = temp;
            root = root.next;
        }
         return ans;
    }
}
