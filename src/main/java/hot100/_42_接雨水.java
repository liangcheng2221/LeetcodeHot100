package hot100;

public class _42_接雨水 {

    /**
     * 依次找左右最高的记录下来:TODO 这个不是很好理解，先记住怎么做
     *
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int countLeft = 0;
        int count = 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        for (int i = 0; i < height.length; i++) {
            countLeft = Math.max(countLeft, height[i]);
            left[i] = countLeft;
        }
        countLeft = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            countLeft = Math.max(countLeft, height[i]);
            right[i] = countLeft;
        }

        for (int i = 0; i < height.length; i++) {
            if (Math.min(left[i], right[i]) > height[i]) {
                count += Math.min(left[i], right[i]) - height[i];
            }
        }

        return count;

    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
