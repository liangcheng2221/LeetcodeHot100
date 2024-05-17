package hot100;

public class _76_最小覆盖子串 {

    /**
     * 本质应该就是求最小子串
     *
     * @param s
     * @param t
     * @return
     */
    public static String minWindow(String s, String t) {

        if (t.length() > s.length()){
            return "";
        }

        int length = s.length();

        for (int i = 0; i < length - t.length(); i++) {
            for (int j = 0; j <= length - t.length() - i; j++) {
                String substring = s.substring(j,j+t.length() - 1);
                if (substring.contains(t)){
                    return s;
                }
            }
        }
        return "";
    }
    /**
     * 滑动窗口
     *
     * @param s
     * @param t
     * @return
     */
    public static String minWindowBy(String s, String t) {
//        Map<Character,Integer>

        return "";
    }

    public static void main(String[] args) {
        System.out.println(minWindowBy("ADOBECODEBANC", "ABC"));
    }
}
