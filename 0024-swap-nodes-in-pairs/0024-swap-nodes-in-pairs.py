# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head == None:
            return None
        nodelist = []
        while head != None:
            nodelist.append(head)
            head = head.next
        for i in range(0,len(nodelist)-1,2):
            print(i)
            nodelist[i+1].next = nodelist[i]
            nodelist[i].next = None
            if i != 0:
                nodelist[i-2].next = nodelist[i+1]
        if len(nodelist) % 2 == 1 and len(nodelist) > 2:
            nodelist[len(nodelist)-3].next = nodelist[len(nodelist)-1]
        if len(nodelist) > 1:   
            return nodelist[1]
        else:
            return nodelist[0]