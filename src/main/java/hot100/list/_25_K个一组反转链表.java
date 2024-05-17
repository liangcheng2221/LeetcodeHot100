package hot100.list;

/**
 * @author yinjie
 * @date 2024-04-03 8:39
 */
public class _25_K个一组反转链表 {
    /**
     * 思路：翻转链表的一种进阶
     * 1. 记录每组的最后一个节点的下一个节点
     * 2. 将最后一个节点的下一个节点指向空
     * 3. 进行每组的链表反转
     * 4. 拼接每组的最后一个节点的下一个节点
     *
     * @param head 头结点
     * @param k    分组
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {

        ListNode newHead = new ListNode();
        newHead.next = head;

        ListNode node = newHead;
        int count = 0;

        // 记录节点的个数
        while (node.next != null) {
            count++;
            node = node.next;
        }
        node = newHead;

        final int len = Math.floorDiv(count, k);

        for (int i = 0; i < len; i++) {
            // 翻转链表
            node.next = reverseList(node.next, k);
            node = update(node, k);
        }

        return newHead.next;
    }

    /**
     * @param node 每组的一个头结点
     * @param k    反转的个数
     * @return 返回反转后的链表
     */
    private static ListNode reverseList(ListNode node, int k) {
        if (node == null) {
            return null;
        }
        // 截掉最后一个节点的下一个节点
        ListNode test = node;
        for (int i = 1; i < k; i++) {
            test = test.next;
        }
        // 记录下一个节点
        ListNode next = test.next;

        // 下一个节点指向空
        test.next = null;

        test = node;

        // 反转后接上
        ListNode result = reverse(test);
        ListNode result1 = result;
        while (result1.next != null) {
            result1 = result1.next;
        }

        result1.next = next;
        return result;
    }

    /**
     * 整个链表的翻转
     *
     * @param test
     * @return
     */
    private static ListNode reverse(ListNode test) {

        if (test == null || test.next == null) {
            return test;
        }
        ListNode last = test.next;
        ListNode reverse = reverse(test.next);
        test.next = last.next;
        last.next = test;
        return reverse;
    }


    /**
     * 每次翻转进行移动
     *
     * @param newHead
     * @param k
     * @return
     */
    private static ListNode update(ListNode newHead, int k) {
        for (int i = 0; i < k; i++) {
            newHead = newHead.next;
        }
        return newHead;
    }

    public static void main(String[] args) {

        ListNode listNode = new ListNode();
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next = new ListNode(5);

        System.out.println(reverseKGroup(listNode.next, 3));
    }

    public static class ListNode {
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
