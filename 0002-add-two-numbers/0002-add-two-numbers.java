import java.math.BigInteger;
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String listOne = "";
        while (l1.next != null) {
            listOne = String.valueOf(l1.val) + listOne;
            l1 = l1.next;
        }
        listOne = String.valueOf(l1.val) + listOne;
        String listTwo = "";
        while (l2.next != null) {
            listTwo = String.valueOf(l2.val) + listTwo;
            l2 = l2.next;
        }
        listTwo = String.valueOf(l2.val) + listTwo;
        BigInteger one = new BigInteger(listOne);
        BigInteger two = new BigInteger(listTwo);
        ListNode currentListNode = null;
        ListNode firstListNode = null;
        BigInteger remainder = one.add(two);
        if (remainder.compareTo(new BigInteger("0")) == 0) return new ListNode(0);
        while (remainder.compareTo(new BigInteger("0")) != 0) {
            ListNode newListNode = new ListNode((remainder.mod(new BigInteger("10"))).intValue());
            if(currentListNode != null) currentListNode.next = newListNode;
            if(currentListNode == null) firstListNode = newListNode;
            currentListNode = newListNode;            
            remainder = remainder.divide(new BigInteger("10"));
        } 
        return firstListNode;
    }
}