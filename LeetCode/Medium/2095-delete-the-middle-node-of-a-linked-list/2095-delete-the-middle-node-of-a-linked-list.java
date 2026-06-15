class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null)
            return null;
            
        ListNode fs = head.next.next;
        ListNode sl = head;

        while (fs != null && fs.next != null) {
            sl = sl.next;
            fs = fs.next.next;
        }

        sl.next = sl.next.next;

        return head;
    }
}