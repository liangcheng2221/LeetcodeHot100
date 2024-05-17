package hot100.list;

import java.util.Arrays;

/**
 * @author yinjie
 * @date 2024-04-07 7:26
 */
public class _148_排序列表 {
    /**
     * 直接暴力求解：空间复杂度为O(n),时间复杂度为O(log n),排序用的是快排
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {

        ListNode listNode = head;
        int count = 0;
        while (listNode != null){
            count++;
            listNode = listNode.next;
        }

        int[] collect = new int[count];

        listNode = head;
        count = 0;
        while (listNode != null){
            collect[count] = listNode.val;
            count++;
            listNode = listNode.next;
        }

        count = 0;
        listNode = head;
        Arrays.sort(collect);

        while (listNode != null){
            listNode.val = collect[count];
            count++;
            listNode = listNode.next;
        }

        return head;

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
