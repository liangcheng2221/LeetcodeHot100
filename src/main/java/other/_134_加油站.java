package other;

public class _134_加油站 {
    /**
     * 暴力
     *
     * @param gas
     * @param cost
     * @return
     */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        while (start < gas.length) {
            int count = 0;
            int i = 0;
            for (i = 0; i < cost.length; i++) {
                if (count + gas[(start + i) % gas.length] == 0) {
                    break;
                }
                count = count + gas[(start + i) % gas.length] - cost[(start + i) % gas.length];
                if (count < 0) {
                    break;
                }
            }
            if (count >= 0 && i == cost.length) {
                return start;
            }
            start++;
        }
        return -1;
    }

    /**
     * 贪心
     *
     * @param gas
     * @param cost
     * @return
     */
    public static int canCompleteCircuit1(int[] gas, int[] cost) {

        /*
         * 如果前面的和小于零（可以稍微证明）直接跳到后面一个（如果没有后面一个就已经没有了）
         */

        int[] test = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            test[i] = gas[i] - cost[i];
        }

        int start = 0;
        int count = 0;
        for (int i = 0; i < gas.length; i++) {
            count += test[i];
            if (count < 0) {
                if (i == gas.length - 1) {
                    return -1;
                }
                start = i + 1;
                count = test[start];
            }
        }
        return start;

    }

    public static void main(String[] args) {

        System.out.println(canCompleteCircuit1(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
    }
}
