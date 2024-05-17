package other;

import javax.sound.midi.Soundbank;

public class _58_最后一个单词的长度 {
    public  static int lengthOfLastWord(String s) {
        int count = 0;
        for (int i = s.length() - 1; i > 0; i--) {
            char c = s.charAt(i);
            if (c != ' ') {
                count++;
                if (s.charAt(i-1) == ' '){
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
    }
}
