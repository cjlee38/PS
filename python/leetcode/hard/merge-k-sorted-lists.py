# Definition for singly-linked list.
from typing import Optional, List


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        arr = []
        head = init = ListNode()
        for l in lists:
            while l:
                arr.append(l.val)
                l = l.next
        for i in sorted(arr):
            cur = ListNode(i, None)
            head.next = cur
            head = head.next
        return init.next



# print(Solution().mergeKLists([]))
print(Solution().mergeKLists([ListNode()]))