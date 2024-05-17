package other;

public class _88_合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[m + n];
        int length1 = 0;
        int length2 = 0;
        int length3 = 0;
        while (length1 < m || length2 < n) {
            if (length2 >= n) {
                nums3[length3++] = nums1[length1++];
                continue;
            }
            if (length1 >= m) {
                nums3[length3++] = nums2[length2++];
                continue;
            }
            if (nums1[length1] <= nums2[length2]){
                nums3[length3++]= nums1[length1++];

            }else {
                nums3[length3++] = nums2[length2++];
            }
        }
        for (int i = 0; i < nums3.length; i++){
            nums1[i] = nums3[i];
        }
    }
}
