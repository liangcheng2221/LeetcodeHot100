package other;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1935_可以输入的最大单词数 {
    public static int canBeTypedWords(String text, String brokenLetters) {
        int count = 0;
        boolean flag = true;

        Map<Character, Integer> map = new HashMap<>();
        for (char c : brokenLetters.toCharArray()) {
            map.put(c, 1);
        }

        for (char c : text.toCharArray()) {
            if (map.get(c) == null) {
                flag = false;
            }
            if (' ' == c) {
                if (flag) {
                    count++;
                } else {
                    flag = true;
                }
            }
        }
        if (flag) {
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(canBeTypedWords("hello world", "ad"));
    }
}
