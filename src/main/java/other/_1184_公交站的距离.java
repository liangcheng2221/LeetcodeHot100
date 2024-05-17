package other;

import java.util.Stack;

public class _1184_公交站的距离 {
    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int count = 0;
        int count1 = 0;
        if (start < destination) {
            int left = start;
            for (int i = 0; i < distance.length; i++) {
                if (left + i >= destination) {
                    count1 += distance[(left + i) % distance.length];
                } else {
                    count += distance[left + i];
                }
            }
        } else {
            int left = destination;
            for (int i = 0; i < distance.length ; i++) {
                if (left + i >= start) {
                    count1 += distance[(left + i) % distance.length];
                } else {
                    count += distance[left + i];
                }
            }
        }

        return Math.min(count, count1);
    }

    public static void main(String[] args) {
        System.out.println(distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 1));
        System.out.println(distanceBetweenBusStops(new int[]{7, 10, 1, 12, 11, 14, 5, 0}, 7, 2));
        System.out.println(distanceBetweenBusStops(new int[]{3,6,7,2,9,10,7,16,11}, 6, 2));
    }
}
