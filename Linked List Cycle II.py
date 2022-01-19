# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def detectCycle(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head:
            return None
        p = head
        q = head
        while True:
            if p.next:
                p = p.next
            else:
                return None
            if q.next and q.next.next:
                q = q.next.next
            else:
                return None
            if p == q:
                q = head
                while p!=q:
                    p = p.next
                    q = q.next
                return p
