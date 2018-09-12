public class RemoveLinkedList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }

    public ListNode removeDuplicate(ListNode head) {
        if (head == null || head.next == null) {
            ListNode curr = head;
            ListNode prev = curr;
            ListNode nextNode = prev.next;
            while (curr.next != null) {
                while (nextNode != null) {
                    if (curr.val == nextNode.val) {
                        if (nextNode.next == null) {
                            prev.next = null;
                            break;
                        } else {
                            prev.next = nextNode.next;
                            nextNode.next = nextNode.next.next;
                        }
                    } else {
                        prev = prev.next;
                        nextNode = prev.next;

                    }
                }
                if (curr.next == null) break;
                curr = curr.next;
                prev = curr;
                nextNode = prev.next;
            }
        }
        return head;
    }
}
