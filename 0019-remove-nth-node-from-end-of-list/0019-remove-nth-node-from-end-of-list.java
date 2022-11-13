/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) return null;
        ArrayList<ListNode> nodeList = new ArrayList<>();
        while (head != null) {
            nodeList.add(head);
            head = head.next;
        }
        if(n==nodeList.size()) {
            return nodeList.get(0).next;
        }
        if(n==1) {
            nodeList.get(nodeList.size()-1-n).next = null;
            return nodeList.get(0);
        }
        ListNode node1 = nodeList.get(nodeList.size()-1-n);
        node1.next = nodeList.get(nodeList.size() - 1 - n + 2);
        return nodeList.get(0);
    }
}