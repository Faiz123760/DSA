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
        ListNode prev=head, tmp=head;
        int count=0;
        while(tmp!=null){
            count++;
            tmp=tmp.next;
        }
        if(count==n) return head.next;
        int i=1, target=count-n;
        while(i<target){
            i++;
            prev=prev.next;
        }
        prev.next=prev.next.next;
        return head;
    }
}