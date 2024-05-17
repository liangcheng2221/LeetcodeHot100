package hot100.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yinjie
 * @date 2024-04-03 8:12
 */
public class _160_相交链表 {
    /**
     * 做法一：直接双重循环依次判断（Violent enumeration）
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNodeByEnumeration(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode A = headA;
        ListNode B = headB;
        while (A != null) {
            while (B != null) {
                if (A == B) {
                    return A;
                }
                B = B.next;
            }
            B = headB;
            A = A.next;
        }
        return null;
    }

    /**
     * 做法二：链表存储（这里好像有损性能）、哈希存储（键为节点，又可能哈希冲突）其中一个链表的每个节点判断即可
     *   todo 感觉这里数据量多了会有问题（HashMap的详细了解）
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNodeByHash(ListNode headA, ListNode headB) {

        final Object PERSISTENCE_OBJECT = new Object();

        if (headA == null || headB == null) {
            return null;
        }

        Map<ListNode, Object> map = new HashMap<>();
        List<ListNode> list = new ArrayList<>();

        ListNode A = headA;
        ListNode B = headB;
        while (A != null) {
//            list.add(A);
            map.put(A, PERSISTENCE_OBJECT);
            A = A.next;
        }

        while (B != null) {
            if (map.containsKey(B)) {
                return B;
            }
            B = B.next;
        }

        return null;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}



