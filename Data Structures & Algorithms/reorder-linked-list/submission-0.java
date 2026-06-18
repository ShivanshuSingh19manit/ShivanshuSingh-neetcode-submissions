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
       
       if(head == null){
         return; 
       }
        ArrayList<ListNode> ll = new ArrayList<>();
        ListNode curr = head;

        while(curr != null){
            ll.add(curr);
            curr = curr.next;
        }
        int i = 0;
        int j = ll.size()-1;

        while(i < j){
            ll.get(i).next = ll.get(j);
            i++;
            if(i >= j){
                break;
            }
            ll.get(j).next = ll.get(i);
            j--;
        }
           ll.get(i).next = null;
    }
}
