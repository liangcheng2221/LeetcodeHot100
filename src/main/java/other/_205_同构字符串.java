package other;

import java.util.HashMap;
import java.util.Objects;

public class _205_同构字符串 {
    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Integer> s1 = new HashMap<>();
        HashMap<Character, Integer> t1 = new HashMap<>();
        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            if (!Objects.equals(s1.get(s.charAt(i)), t1.get(t.charAt(i)))) {
                return false;
            }
            s1.put(s.charAt(i), i + 1);
            t1.put(t.charAt(i), i + 1);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("paper", "title"));
    }
}
