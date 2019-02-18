package leetcode;

import java.util.HashMap;

/**
 * @Auther: user
 * @Date: 2019/2/17 15:37
 * @Description:
 */
public class IntegerToRoman {
    private static HashMap<Integer, String> integerRomanMap = new HashMap<Integer, String>() {{
        put(1, "I");
        put(5, "V");
        put(10, "X");
        put(50, "L");
        put(100, "C");
        put(500, "D");
        put(1000,"M");
    }};

    /**
     * @Description: 87%
     * @param
     * @return
     * @throws
     * @author user
     * @date 2019/2/17 22:13
     */
    public String intToRoman(int num) {
        if (integerRomanMap.containsKey(num)) return integerRomanMap.get(num);
        StringBuilder sb = new StringBuilder();
        int oldNum = num;
        int danwei = 1000;
        while (num > 0) {
            if (integerRomanMap.containsKey(num)) {
                sb.append(integerRomanMap.get(num));
                break;
            }
            int wei = num / danwei;
            if (wei != 0) {
                sb.append(getStringLessThanFour(wei, danwei));
            }
            num = num % danwei;
            danwei = danwei / 10;
        }
        integerRomanMap.put(oldNum, sb.toString());
        return sb.toString();
    }

    public String getStringLessThanFour(int num, int weishuNum) {
        if (integerRomanMap.containsKey(num*weishuNum)) return integerRomanMap.get(num*weishuNum);
        String dan;
        StringBuilder sb = new StringBuilder();
        if (0 < num && num < 4) {
            dan = integerRomanMap.get(1 * weishuNum);
            while (num > 0) {
                sb.append(dan);
                num--;
            }
        } else if(num == 4) {
            sb.append(integerRomanMap.get(1 * weishuNum)).append(integerRomanMap.get(5 * weishuNum));
        } else if (num >=5 && num <= 8){
            sb.append(integerRomanMap.get(5 * weishuNum)).append(getStringLessThanFour(num % 5, weishuNum));
        } else if (num == 9) {
            sb.append(integerRomanMap.get(1 * weishuNum)).append(integerRomanMap.get(10 * weishuNum));
        } else {
            sb.append("");
        }
        integerRomanMap.put(num*weishuNum, sb.toString());
        return sb.toString();
    }

//    public String intToRoman(int num) {
//        if (integerRomanMap.containsKey(num)) return integerRomanMap.get(num);
//        int weishu = 0;
//        StringBuilder sb = new StringBuilder();
//        String[] s = new String[4];
//        String cached = null;
//        while (num > 0) {
//            int wei = num % 10;
//            if (wei != 0) {
//                if (wei == 0) {
//                    continue;
//                } else {
//                    s[weishu] = getStringLessThanFour(wei, (int)Math.pow(10, weishu));
//                }
//            }
//            num = num / 10;weishu++;
//        }
//        String result = new String("");
//        for (int i = s.length - 1; i >= 0; i-- ) {
//            if (s[i] == null) {
//                continue;
//            }
//            result += s[i];
//        }
//        integerRomanMap.put(num, result);
//        return result;
//    }
//
//    public String getStringLessThanFour(int num, int weishuNum) {
//        if (integerRomanMap.containsKey(weishuNum*num)) return integerRomanMap.get(weishuNum*num);
//        String dan;
//        StringBuilder sb = new StringBuilder();
//        if (0 < num && num < 4) {
//            dan = integerRomanMap.get(1 * weishuNum);
//            while (num > 0) {
//                sb.append(dan);
//                num--;
//            }
//        } else if(num == 4) {
//            sb.append(integerRomanMap.get(1 * weishuNum)).append(integerRomanMap.get(5 * weishuNum));
//        } else if (num >=5 && num <= 8){
//            sb.append(integerRomanMap.get(5 * weishuNum)).append(getStringLessThanFour(num % 5, weishuNum));
//        } else if (num == 9) {
//            sb.append(integerRomanMap.get(1 * weishuNum)).append(integerRomanMap.get(10 * weishuNum));
//        } else {
//            sb.append("");
//        }
//        if(!integerRomanMap.containsKey(weishuNum*num)) {
//            integerRomanMap.put(weishuNum*num,sb.toString());
//        }
//        return sb.toString();
//    }

    public  static  void main (String[] args) {
        IntegerToRoman ir = new IntegerToRoman();
        System.out.println(ir.intToRoman(12));
    }

}
