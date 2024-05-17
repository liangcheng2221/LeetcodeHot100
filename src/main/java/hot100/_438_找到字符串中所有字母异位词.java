package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _438_找到字符串中所有字母异位词 {

    /**
     * 这个还是有点小抽象，但是好理解，不太好写，就定义一个哈希记录他们的值，每次循环一次就删除前面存储的值，
     * 加上后面存储的值。
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams(String s, String p) {

        if (p.length() >s.length()){
            return new ArrayList<>();
        }

        int[] pTest = new int[26];
        int[] sTest = new int[26];
        char[] pArray = p.toCharArray();
        char[] sArray = s.toCharArray();
        for (int i = 0; i < p.length(); i++) {
            pTest[pArray[i] - 'a']++;
            sTest[sArray[i] - 'a']++;
        }
        List<Integer> result = new ArrayList<>();

        if (Arrays.equals(pTest,sTest)){
            result.add(0);
        }

        for (int i = 0; i < s.length() - p.length(); i++) {
            sTest[sArray[i] - 'a']--;
            sTest[sArray[i + p.length()] - 'a']++;

            if (Arrays.equals(pTest,sTest)){
                result.add(i + 1);
            }

        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }
}
