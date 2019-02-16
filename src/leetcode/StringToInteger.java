package leetcode;

import java.math.BigInteger;
import java.util.HashSet;

/**
 * @Auther: user
 * @Date: 2019/2/16 21:49
 * @Description:
 */
public class StringToInteger {

    private static BigInteger MaxNum = new BigInteger("2147483647");

    private static BigInteger MinNum = new BigInteger("-2147483648");

    /**
     * @Description: 我这边时间基本损耗在BigInteger.不借助这个类，时间仍然可以以提升
     * @param
     * @return
     * @throws
     * @author user
     * @date 2019/2/16 23:19
     */
    public int myAtoi(String str) {
        String numStr = getNumStrFromInputStr(str.trim());
        if (numStr.equals("") || numStr.equals("+") || numStr.equals("-")) {return 0;}
        int result = 0;
        BigInteger binInt = new BigInteger(numStr);
        if (binInt.compareTo(MinNum) < 0) {
            result = -2147483648;
        } else if (binInt.compareTo(MaxNum) > 0) {
            result = 2147483647;
        } else {
            result =  Integer.parseInt(numStr);
        }
        return result;

    }

    public String getNumStrFromInputStr(String input) {
        StringBuilder resultStr = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (i == 0 && (input.charAt(i) == '-' || input.charAt(i) == '+')) {
                resultStr.append(input.charAt(i));
            } else if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {
                resultStr.append(input.charAt(i));
            } else {
                break;
            }
        }
        return resultStr.toString();
    }

    public int myAtoi_1(String str) {
        if (str == null)
            return 0;
        int i = 0;
        int signSeenCount = 0; // + or - should be seen only once
        boolean isNegetive = false;
        while (i < str.length()) {
            if (signSeenCount == 0 && str.charAt(i) == ' ') {
            } else if (signSeenCount == 0 && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
                isNegetive = str.charAt(i) == '-' ? true : false;
                signSeenCount++;
            } else if (str.charAt(i) < '0' || str.charAt(i) > '9')
                return 0;
            else
                break;
            i++;
        }

        int result = 0; // This is int and not long as is the case with solutions
        while (i < str.length()) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9')
                break;
            int digit = str.charAt(i) - '0';
            // Overflow check
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10) ) {
                if (isNegetive)
                    return Integer.MIN_VALUE;
                else
                    return Integer.MAX_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return isNegetive ? -result : result;

    }

    public static void main(String[] args) {

    }
}
