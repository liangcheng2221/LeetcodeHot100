package other;

import java.util.HashMap;
import java.util.Map;

public class _2744_最大字符串配对数目 {
    public static int maximumNumberOfStringPairs(String[] words) {
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word.charAt(1)*100 + word.charAt(0))){
                count++;
            }
            map.put(word.charAt(0)*100 + word.charAt(1),1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(maximumNumberOfStringPairs(new String[]{"aa","ab","ba"}));// 1
    }
}
