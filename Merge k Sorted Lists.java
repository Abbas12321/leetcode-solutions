public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        int end = lists.length -1;
        while(end > 0)
        {
            int begin = 0;
            while(begin < end)
            {
                lists[begin] = mergeTwoLists(lists[begin],lists[end]);
                begin++;
                end--;
            }
        }
        return lists[0];
    }
    
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        while(l1 != null && l2 != null)
        {
            if(l1.val <= l2.val)
            {
                prev.next = l1;
                l1 = l1.next;
            }
            else
            {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        if(l1 != null) prev.next = l1;
        if(l2 != null) prev.next = l2;
        return dummy.next;
    }
}
