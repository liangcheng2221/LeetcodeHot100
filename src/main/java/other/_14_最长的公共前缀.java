package other;

public class _14_最长的公共前缀 {
    public static String longestCommonPrefix(String[] strs) {
        String string = "";
        int count = 0;
        while (true) {
            char c = 0;
            try {
                c = strs[0].charAt(count);
                for (String str : strs) {
                    if (c != str.charAt(count)) {
                        return string;
                    }
                }
            } catch (Exception e) {
                return string;
            }
            string += String.valueOf(c);
            count++;
        }

    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
}
