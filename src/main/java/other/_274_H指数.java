package other;

import java.util.Arrays;

public class _274_H指数 {
    public static int hIndex(int[] citations) {
        int h = citations.length;
        while (h > 0) {
            int count = 0;
            for (int citation : citations) {
                if (citation >= h) {
                    count++;
                }
                if (count == h) {
                    return count;
                }
            }
            h--;
        }
        return 0;
    }

    public static int hIndex1(int[] citations) {
//        Arrays.sort(citations);
//
//        for (int i = citations.length - 1; i >= 0; i--) {
//            if (citations.length - i >= citations[i]){
//                return citations.length - i;
//            }
//        }
//
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(hIndex1(new int[]{1, 3, 1}));
    }
}
