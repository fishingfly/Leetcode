package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Auther: user
 * @Date: 2019/2/16 14:02
 * @Description: Longest Substring Without Repeating Characters
 */
public class LengthOfLongestSubstring {
    /**
     * @Description: 两次循环，时间复杂度是n的平方，这个算是最普通的方法了
     * @param
     * @return
     * @throws
     * @author user
     * @date 2019/2/16 14:34
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        int len = s.length();
        int index = 0;
        HashSet<Character> set = new HashSet<>();
        int maxLenSubstring = 0;
        for (int j = 0; j < len; j++) {
            for (int i = j; i < len; i++) {
                if (set.add(s.charAt(i)) == false) {
                    break;
                }
            }
            maxLenSubstring = maxLenSubstring < set.size() ? set.size() : maxLenSubstring;
            set.clear();
        }
        return maxLenSubstring;
    }

    /**
     * @Description: 时间复杂度是2n,写到这个还算是可以的
     * @param
     * @return
     * @throws
     * @author user
     * @date 2019/2/16 14:52
     */
    public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * @Description: 写出这个就牛逼了。降到n了
     * 想法就是：The reason is that if s[j]s[j] have a duplicate in the range [i, j)[i,j) with index j'j
     * ′
     *  , we don't need to increase ii little by little. We can skip all the elements in the range [i, j'][i,j
     * ′
     *  ] and let ii to be j' + 1j
     * ′
     *  +1 directly.
     * @param
     * @return
     * @throws
     * @author user
     * @date 2019/2/16 14:53
     */
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("abcabcs"));
    }

}
