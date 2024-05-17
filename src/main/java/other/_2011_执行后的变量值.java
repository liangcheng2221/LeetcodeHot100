package other;

public class _2011_执行后的变量值 {
    public static int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        for (String string : operations) {
            char c = string.charAt(1);
            if (c == '+'){
                ans++;;
            }else {
                ans--;
            }
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}
