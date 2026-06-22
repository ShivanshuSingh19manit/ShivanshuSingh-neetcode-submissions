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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ArrayList<Integer> ll = new ArrayList<Integer>();
        ListNode curr = head;
        while(curr != null){
            ll.add(curr.val);
            curr = curr.next;
        }
        while(left < right){
            Collections.swap(ll, left-1, right-1);   
            left++;
            right--;
        }
        ListNode dummy = new ListNode(0);
        curr = dummy;
        int i = 0;
        while(i != ll.size()){
            curr.next = new ListNode(ll.get(i));
            i++;
            curr = curr.next;
        }
        return dummy.next;

    }
}