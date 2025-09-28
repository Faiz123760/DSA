class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node curr = head;

        // Step 1: Create new nodes and insert them after each original node
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // Step 2: Assign random pointers
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate original and copied list
        curr = head;
        Node pseudoHead = new Node(0);
        Node copyCurr = pseudoHead;

        while (curr != null) {
            Node copy = curr.next;
            curr.next = copy.next; // restore original list
            copyCurr.next = copy;  // build copied list
            copyCurr = copy;
            curr = curr.next;
        }

        return pseudoHead.next;
    }
}
