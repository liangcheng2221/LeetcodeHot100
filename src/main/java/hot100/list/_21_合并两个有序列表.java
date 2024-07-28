package hot100.list;

import java.util.List;

/**
 * @author <a href="https://github.com/liangcheng2221">yinjie</a>
 * @date 2024-05-01 21:40
 */
public class _21_合并两个有序列表 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode node = head;
        if (list1 == null && list2 == null) {
            return null;
        }

        while (!(list1 == null && list2 == null)) {
            if (list1 == null) {
                head.next = new ListNode(list2.val);
                list2 = list2.next;
            } else if (list2 == null) {
                head.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                if (list1.val >= list2.val) {
                    head.next = new ListNode(list2.val);
                    list2 = list2.next;
                } else {
                    head.next = new ListNode(list1.val);
                    list1 = list1.next;
                }
            }
            head = head.next;
        }

        return node.next;
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
