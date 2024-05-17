package other;

public class _1550_存在连续三个奇数的数组{
    public static boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int i : arr){
            if (isOdd(i)){
                count++;
            }else {
                count = 0;
            }
            if (count == 3){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {

    }
    public static  boolean isOdd(int num) {
        return num % 2 != 0;
    }
}
