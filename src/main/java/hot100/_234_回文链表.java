package hot100;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class _234_回文链表 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public boolean isPalindrome(ListNode head) {

        List<Integer> list = new ArrayList<>();
        if (head == null) {
            return false;
        }
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int left = 0;
        int right = list.size() - 1;
        while (left <= right){

            if (!Objects.equals(list.get(left), list.get(right))){
                return false;
            }

            right--;
            left++;
        }

        return true;

    }

    public ListNode reverse(ListNode head) {

        if (head.next == null) {
            return head;
        }

        ListNode node = head;
        ListNode headNext = head.next;
        ListNode newHead = reverse(head.next);
        node.next = headNext.next;
        headNext.next = node;
        return newHead;
    }

}
