package integerReplacement397;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个正整数n ，你可以做如下操作：
 * <p>
 * 如果n是偶数，则用n / 2替换n 。
 * 如果n是奇数，则可以用n + 1或n - 1替换n 。
 * n变为 1 所需的最小替换次数是多少？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-replacement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntegerReplacement397 {
    static Map<Integer, Integer> memo = new HashMap<>();

    public static int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        }
        if (n % 2 == 0) {
            return 1 + integerReplacement(n / 2);
        }
        return 2 + Math.min(integerReplacement(n / 2), integerReplacement(n / 2 + 1));
    }

    public static int integerReplacement1(int n) {
        if (n == 1) {
            return 0;
        }
        if (!memo.containsKey(n)) {
            if (n % 2 == 0) {
                memo.put(n, 1 + integerReplacement1(n / 2));
            } else {
                memo.put(n, 2 + Math.min(integerReplacement1(n / 2), integerReplacement1(n / 2 + 1)));
            }
        }
        return memo.get(n);
    }

    public static void main(String[] args) {
        System.out.println(integerReplacement(11));
        System.out.println(integerReplacement(22));
        System.out.println(integerReplacement(33));
        System.out.println(integerReplacement(44));
        System.out.println(integerReplacement(55));

    }
}
