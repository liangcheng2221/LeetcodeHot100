package hot100.list;

import java.util.HashMap;
import java.util.Map;

public class _142_环形链表2 {
    public ListNode detectCycle(ListNode head) {

        Map<ListNode, Integer> map = new HashMap<>();

        ListNode node = head;
        while (node != null) {
            if (map.get(node) != null) {
                return node;
            }
            map.put(node,1);
            node = node.next;
        }

        return null;

    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
