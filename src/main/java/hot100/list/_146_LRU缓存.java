package hot100.list;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;

/**
 * @author yinjie
 * @date 2024-04-07 8:33
 */
public class _146_LRU缓存 {
    // 记录当前元素数量
    private int index;
    private int capacity;
    private final Object[] objects = new Object[10000];

    /**
     * 判断是否超过容量是否满
     *
     * @return
     */
    private boolean checkIndex() {
        return index + 1 != capacity;
    }

    public _146_LRU缓存(int capacity) {
        this.capacity = capacity;
        index++;
    }

    public int get(int key) {

        return 0;
    }

    public void put(int key, int value) {
        if (!checkIndex()) {
            objects[key % 512] = new HashMap<Integer, Integer>() {{
                put(key, value);
            }};
        }
    }
}
