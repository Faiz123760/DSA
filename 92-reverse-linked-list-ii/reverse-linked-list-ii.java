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
        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Step 1: Move prev to the node before "left"
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Step 2: Reverse sublist [left, right]
        ListNode curr = prev.next;
        ListNode next = null;
        ListNode prevSub = null;

        for (int i = 0; i <= right - left; i++) {
            next = curr.next;
            curr.next = prevSub;
            prevSub = curr;
            curr = next;
        }

        // Step 3: Connect reversed sublist
        prev.next.next = curr;   // connect end of reversed part to "curr"
        prev.next = prevSub;     // connect prev to start of reversed part

        return dummy.next;

    }
}