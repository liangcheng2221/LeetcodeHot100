package sort;

/**
 * @author yinjie
 * @date 2024-04-07 10:25
 */

import cn.hutool.core.util.RandomUtil;

import java.util.Arrays;

/**
 * 冒泡排序思想：两两比较
 */
public class Bubble {
    public static void main(String[] args) {
        int[] arr = new int[Insert.ONE_MILLION / 10];
        for (int i = 0; i < Insert.ONE_MILLION / 10; i++) {
            arr[i] = RandomUtil.randomInt();
        }
//        int[] arr = new int[]{1,55,10,52,2,50};
        BubbleSort(arr);
//        System.out.println(Arrays.toString(arr));
    }

    public static void BubbleSort(int[] arr) {
        long l = System.currentTimeMillis();
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
//            System.out.printf("第%d趟排序的数组",i+1);

            if (!flag){
                break;
            }
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - l) + "ms");
    }
}
