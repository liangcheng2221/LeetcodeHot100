package other;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class _859_亲密字符串 {
    public static boolean buddyStrings(String s, String goal) {

        /*
         * 思路：定义两个hash表，如果两个hash表不相等，就返回false
         * 在定义一个count记录不相等的字符个数超过两个返回false
         */

        Boolean flag = false;
        if (s.length() != goal.length()) {
            return false;
        }

        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map1 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                count++;
            }
            if (count > 2) {
                return false;
            }
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            map1.put(goal.charAt(i), map1.getOrDefault(goal.charAt(i), 0) + 1);
        }
        Set<Character> characters = map.keySet();
        for (Character character : characters){
            if (!Objects.equals(map.get(character), map1.get(character))){
                return false;
            }
            if (map1.get(character)>=2){
                flag = true;
            }
        }
        if (count == 0){
            return flag;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(buddyStrings("ab", "ba"));
        System.out.println(buddyStrings("ab", "ab"));
        System.out.println(buddyStrings("aa", "aa"));
        System.out.println(buddyStrings("aaaaaaabc", "aaaaaaacb"));
    }
}
