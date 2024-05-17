package other;

import java.util.HashMap;
import java.util.Map;

public class _13_罗马数字转整数 {
    public static int romanToInt(String s) {
        int count = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (i < charArray.length - 1 && charArray[i] == 'I' && charArray[i + 1] == 'V') {
                count += 4;
                i++;
                continue;
            }
            if (i < charArray.length - 1 && charArray[i] == 'I' && charArray[i + 1] == 'X') {
                count += 9;
                i++;
                continue;
            }
            if (i < charArray.length - 1 && charArray[i] == 'X' && charArray[i + 1] == 'L') {
                count += 40;
                i++;
                continue;
            }
            if (i < charArray.length - 1 && charArray[i] == 'X' && charArray[i + 1] == 'C') {
                count += 90;
                i++;
                continue;
            }
            if (i < charArray.length - 1 && charArray[i] == 'C' && charArray[i + 1] == 'D') {
                count += 400;
                i++;
                continue;
            }
            if (i < charArray.length - 1 && charArray[i] == 'C' && charArray[i + 1] == 'M') {
                count += 900;
                i++;
                continue;
            }
            count += map.get(charArray[i]);


        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
