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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        
        ArrayList<Integer> ll = new ArrayList<Integer>();
        
        while(list1 != null){
            ll.add(list1.val);
            list1 = list1.next;
        }
        while(list2 != null){
            ll.add(list2.val);
            list2 = list2.next;
        }
        Collections.sort(ll);
        ListNode node = new ListNode(ll.get(0));
        ListNode root = node;
        for(int i=1;i<ll.size();i++){
           ListNode temp = new ListNode(ll.get(i));
           root.next = temp;
           root = root.next;
        }
        return node;
    }
}