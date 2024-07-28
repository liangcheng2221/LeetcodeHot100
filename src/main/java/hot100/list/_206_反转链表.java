package hot100.list;

/**
 * @author <a href="https://github.com/liangcheng2221">yinjie</a>
 * @date 2024-04-27 10:38
 */
public class _206_反转链表 {
    /**
     * 递归解法
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextHead = head.next;
        ListNode listNode = reverseList(head.next);
        head.next = nextHead.next;
        nextHead.next = head;

        return listNode;
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
