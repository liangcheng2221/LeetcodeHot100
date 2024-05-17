package other;

public class _495_提莫攻击 {
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        //记录秒数
        int count = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            if (timeSeries[i + 1] - timeSeries[i] >= duration) {
                count += duration;
            } else {
                count += timeSeries[i + 1] - timeSeries[i] ;
            }
        }
        count += duration;

        return count;
    }

    public static void main(String[] args) {
        System.out.println(findPoisonedDuration(new int[]{1, 4}, 2));
        System.out.println(findPoisonedDuration(new int[]{1, 2}, 2));
    }
}
