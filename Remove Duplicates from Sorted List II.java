public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode it = fakeHead;
        while (it.next != null && it.next.next != null) {
            if (it.next.val == it.next.next.val) {
                int val = it.next.val;
                while (it.next != null && it.next.val == val) {
                    it.next = it.next.next;
                }
            }
            else {
                it = it.next;
            }
        }
        return fakeHead.next;
    }
}
