package hot100.list;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author yinjie
 * @date 2024-04-07 7:39
 * TODO 这题的题解三个方法都没看懂
 */
public class _23_合并k个升序列表 {
    /**
     * 暴力求解
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode head1 = new ListNode();
        int length = lists.length;
        ListNode node = null;
        ListNode head = head1;
        for (ListNode list : lists) {
            node = list;
            while (node != null) {
                head.next = node;
                node = node.next;
                head = head.next;
            }
        }
        ListNode listNode = head1.next;
        int count = 0;

        while (listNode != null){
            count++;
            listNode = listNode.next;
        }
        int[] result = new int[count];
        listNode = head1.next;
        count = 0;

        while (listNode != null){
            result[count] = listNode.val;
            count++;
            listNode = listNode.next;
        }

        count = 0;
        listNode = head1.next;
        Arrays.sort(result);
        while (listNode != null){
            listNode.val = result[count];
            count++;
            listNode = listNode.next;
        }
        return head1.next;

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
