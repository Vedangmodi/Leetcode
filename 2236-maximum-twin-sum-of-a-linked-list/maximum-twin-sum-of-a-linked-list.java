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
    public int pairSum(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode sec = slow;
        ListNode prev = null;

        while(sec != null){
            ListNode temp = sec.next;
            sec.next = prev;
            prev = sec;
            sec = temp;
        }  

        ListNode first = head;
        ListNode second = prev;

        int max = 0;

        while(second != null){
            int sum = first.val + second.val;
            max = Math.max(max, sum);

            first = first.next;
            second = second.next;

        }

        return max;




    }
}


