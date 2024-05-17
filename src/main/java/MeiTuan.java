import java.util.*;

public class MeiTuan {
    public static void main(String[] args) {
        int count = 0;
        int max = 0;
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        String[] s = string.split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        List<Integer> list = new ArrayList<>();
        String string1 = in.nextLine();
        String[] s1 = string1.split(" ");
        Arrays.stream(s1).forEach((value) -> {
            list.add(Integer.parseInt(value));
        });
        System.out.println(list);
        Object[] array = list.toArray();

        for (int i = 0; i < n; i++) {
            max += (Integer) array[i];
            if (max >= k) {
                count += (n - i + 2) * (n - i + 1) / 2 + 1;
            }
            int j = i;
            for (; j < n; j++) {
                if ((Integer) array[j] < k) {
                    i = j - 1;
                    break;
                }
            }
            if (j == n){
                break;
            }
        }
        System.out.println(count);
    }
}
