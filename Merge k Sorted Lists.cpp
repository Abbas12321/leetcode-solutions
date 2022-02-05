class Solution {
public:
    ListNode *mergeKLists(vector<ListNode *> &lists) {
        if (lists.empty()) {
            return nullptr;
        }

        int left = 0, right = lists.size() - 1;
        while (right > 0) {
            lists[left] = mergeTwoLists(lists[left], lists[right]);
            ++left;
            --right;
            if (left >= right) {
                left = 0;
            }
        }
        return lists[0];
    }
    
private:
    ListNode *mergeTwoLists(ListNode *l1, ListNode *l2) {
        ListNode dummy{0};
        auto curr = &dummy;

        while (l1 && l2) {
            if (l1->val <= l2->val) {
                curr->next = l1;
                l1 = l1->next;
            } else {
                curr->next = l2;
                l2 = l2->next;
            }
            curr = curr->next;
        }
        curr->next = l1 ? l1 : l2;

        return dummy.next;
    }
};
