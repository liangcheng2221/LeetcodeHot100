package hot100.list;

/**
 * @author <a href="https://github.com/liangcheng2221">yinjie</a>
 * @date 2024-05-01 21:50
 */
public class _2_两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode();
        ListNode head = listNode;
        int count = 0;
        while (!(l1 == null && l2 == null)) {
            if (l1 == null) {
                listNode.next = new ListNode((count + l2.val) % 10);
                count = (count + l2.val) / 10;
                l2 = l2.next;
            } else if (l2 == null) {
                listNode.next = new ListNode((count + l1.val) % 10);
                count = (count + l1.val) / 10;
                l1 = l1.next;
            } else {
                listNode.next = new ListNode((count + l1.val + l2.val) % 10);
                count = (count + l1.val + l2.val) / 10;
                l1 = l1.next;
                l2 = l2.next;
            }
            listNode = listNode.next;
        }
        if (count != 0) {
            listNode.next = new ListNode(count);
        }
        return head.next;
    }

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
}
