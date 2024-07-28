package sort;

import cn.hutool.core.util.RandomUtil;

/**
 * @author <a href="https://github.com/liangcheng2221">yinjie</a>
 * @date 2024-04-08 10:13
 */
public class Shell {
    public static void main(String[] args) {
        int[] arr = new int[Insert.ONE_MILLION * 10];
        for (int i = 0; i < Insert.ONE_MILLION * 10 ;i++) {
            arr[i] = RandomUtil.randomInt();
        }
//        int[] arr = new int[]{1,55,10,52,2,50};
        ShellSort2(arr);
//        System.out.println(Arrays.toString(arr));
    }


    /**
     * 4s 8万
     * @param arr
     */
    public static void shellSort(int[] arr) {
        int length = arr.length;
        int tmp = 0;
        long l = System.currentTimeMillis();
        // 这里是分割的次数
        for (int i = length / 2; i > 0; i /= 2) {
            // 这里他是从后面往前面递减
            for (int j = i; j < length; j++) {
                // 这里是每次循环完，再间隔i进行交换，主要保证每个元素都能交换到
                for (int k = j - i; k >= 0; k -= i) {
                    if (arr[k] > arr[k + i]) {
                        tmp = arr[k + i];//小
                        arr[k + i] = arr[k];//后面的位置是大的位置
                        arr[k] = tmp;//小的位置是小的
                    }
                }

            }
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - l) + "ms");
    }

    /**
     * 26s一个亿，1千万也就1秒左右
     * @param arr
     */
    public static void ShellSort2(int[] arr) {
        long l = System.currentTimeMillis();
        for (int gar = arr.length; gar > 0; gar /= 2) {
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gar; i < arr.length; i++) {
                int tmp = arr[i];
                int j = i;
                if (arr[i] < arr[j - gar]) {
                    while (j - gar >= 0 && tmp < arr[j - gar]) {
                        arr[j] = arr[j - gar];//移动
                        j -= gar;
                    }
                    arr[j] = tmp;//这里减去了相隔的距离
                }
            }
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - l) + "ms");


    }
}
