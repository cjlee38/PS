from typing import Optional
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:

    def to_number(self, node: Optional[ListNode]) -> int:
        num = 0
        digit = 1
        while node:
            num += node.val * digit
            digit *= 10
            node = node.next
        return num

    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        num1 = self.to_number(l1)
        num2 = self.to_number(l2)
        ans = str(num1 + num2)
        node = init = ListNode()
        for i in ans[::-1]:
            cur = ListNode(int(i), None)
            node.next = cur
            node = node.next

        return init.next

