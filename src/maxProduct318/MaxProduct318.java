package maxProduct318;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串数组words，找到length(word[i]) * length(word[j])的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-of-word-lengths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxProduct318 {
    // 位运算，记录每个word中的字母
    public static int maxProduct(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();
        for (String word : words) {
            int mask = 0;
            for (int j = 0; j < word.length(); j++) {
                mask |= 1 << (word.charAt(j) - 'a');
            }
            map.put(mask, Math.max(map.getOrDefault(mask, 0), word.length()));
        }

        int ans = 0;

        for (Integer x : map.keySet()) {
            for (Integer y : map.keySet()) {
                if ((x & y) == 0) {
                    ans = Math.max(ans, map.get(x) * map.get(y));
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"abc", "xyz", "jeffrey"};
        System.out.println(maxProduct(words));
    }
}
