package leetcode;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;

/**
 * @Auther: user
 * @Date: 2019/2/18 21:51
 * @Description:
 */
public class LongestCommonPrefix {
    /**
     * @Description: n平方的复杂度, Vertical scanning
     * @param
     * @return
     * @throws
     * @author user
     * @date 2019/2/25 23:36
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        int minLen = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            minLen = strs[i].length() < minLen ? strs[i].length() : minLen;
        }
        if (minLen == 0) return "";
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < minLen ; i++) {
            if (charIsSameInStrs(strs, i)) {
                sb.append(strs[0].charAt(i));
            } else {
                break;
            }
        }
        return sb.toString();
    }

    public boolean charIsSameInStrs(String[] strs, int index) {
        HashSet<Character> letter = new HashSet<Character>();
        for (String str : strs) {
            letter.add(str.charAt(index));
        }
        return letter.size() == 1;
    }

    //我觉得这个的复杂度还是不错的，使用的是二分法，nlog(n) Divide and conquer
    public String longestCommonPrefix_2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0 , strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        }
        else {
            int mid = (l + r)/2;
            String lcpLeft =   longestCommonPrefix(strs, l , mid);
            String lcpRight =  longestCommonPrefix(strs, mid + 1,r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    String commonPrefix(String left,String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if ( left.charAt(i) != right.charAt(i) )
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String[] strs = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix.longestCommonPrefix(strs));
    }
}
