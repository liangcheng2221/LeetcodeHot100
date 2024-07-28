package sort;

import cn.hutool.core.util.RandomUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author <a href="https://github.com/liangcheng2221">yinjie</a>
 * @date 2024-04-07 10:27
 */
public class Insert {
    public static final int ONE_MILLION = 1000000;

    public static void main(String[] args) {
        int[] arr = new int[ONE_MILLION / 10];
        for (int i = 0; i < ONE_MILLION / 10; i++) {
            arr[i] = RandomUtil.randomInt();
        }
        insertSort(arr);
//        System.out.println(Arrays.toString(arr));
    }

    /**
     * 插入排序：时间复杂度：平均复杂度为二重循环，最好的情况能达到一次遍历（前提是已经是有序的情况）
     *
     * @param test
     */
    public static void insertSort(int[] test) {


        int length = test.length;
        long l = System.currentTimeMillis();
        for (int i = 1; i < length; i++) {
            // 记录要插入的值
            int indexValue = test[i];
            int index = i - 1;

            // 如果插入的元素小于前面的元素，就移动
            while (index >= 0 && test[index] > indexValue) {
                test[index + 1] = test[index];
                index--;
            }

            // 只要移动了就进行赋值操作
            if (index + 1 != i) {
                test[index + 1] = indexValue;
            }

        }
        System.out.println("耗时：" + (System.currentTimeMillis() - l) + "ms");

    }
}
