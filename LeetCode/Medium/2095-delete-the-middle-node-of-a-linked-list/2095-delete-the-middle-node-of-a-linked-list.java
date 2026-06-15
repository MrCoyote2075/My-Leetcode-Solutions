class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null)
            return null;
            
        ListNode fs = head;
        ListNode sl = head;
        ListNode prev = head;

        while (fs != null && fs.next != null) {
            prev = sl;
            sl = sl.next;
            fs = fs.next.next;
        }

        prev.next = sl.next;

        return head;
    }
}