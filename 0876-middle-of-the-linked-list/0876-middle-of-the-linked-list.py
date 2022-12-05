# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        midNode = head
        while True:
            if head.next == None:
                    return midNode
            head = head.next
            midNode = midNode.next
            if head.next != None:
                head = head.next
            
            