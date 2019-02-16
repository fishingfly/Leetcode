package leetcode;

import javafx.beans.binding.StringBinding;

/**
 * @Auther: user
 * @Date: 2019/2/16 15:05
 * @Description:
 */
public class LongestPalindrome {

    /**
     * @Description: 我自己写的，复杂度较高，没有标准答案好，而且空间复杂度也蛮高
     * @param
     * @return
     * @throws
     * @author user
     * @date 2019/2/16 16:42
     */
    public String longestPalindrome(String s) {
        if (s ==  null || s.equals(""))  return s;
        int i = 0,j = 0;
        int len = s.length();
        String subStr = null;
        String resultStr = null;
        int maxLen = 0;
        while (i < len) {
            subStr = s.substring(i,j);
            if (isPalindromeStr(subStr) && subStr.length() > maxLen) {
                resultStr = subStr;
                maxLen = subStr.length();
            }
            if (j == len) {
                i++;
                j = i;
            } else {
                j++;
            }
        }
        return resultStr;
    }

    public boolean isPalindromeStr(String str) {
        int start = 0;
        int end = str.length() - 1;
        int medium = str.length() / 2;
        while (start <= medium && end >= medium) {
            if (str.charAt(start) == str.charAt(end)) {
                start++;
                end--;
            }
            else return false;
        }
        return true;
    }

    /**
     * @Description: 标准答案，就是采用了动态规划
     * @param
     * @return
     * @throws
     * @author user
     * @date 2019/2/16 16:42
     */
    public String longestPalindrome1(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }


    public static void main(String[] args) {
        LongestPalindrome l = new LongestPalindrome();
        System.out.println(l.longestPalindrome("abcada"));
    }
}
