package 字符串.练习;

import org.junit.jupiter.api.Test;

/**
 * @Description 寻找两个字符串共同存在的最长子字符串
 */
public class 找最长相同子串 {
    @Test
    public void test(){
        String str1 = "asdfshappynewyeardfbchellosdfsdfsd", str2="dsafsdfhelloskadjfkadsjhf";
        String sameString = getMaxSameString(str1, str2);
        System.out.println(sameString);
    }

    public String getMaxSameString(String s1, String s2) {
        String longStr, shortStr;
        int longLen, shortLen;

        if (s1.length() > s2.length()) {
            longStr = s1;
            longLen = s1.length();
            shortStr = s2;
            shortLen = s2.length();
        } else {
            longStr = s2;
            longLen = s2.length();
            shortStr = s1;
            shortLen = s1.length();
        }

        if (longStr.contains(shortStr)){
            return shortStr;
        }

        // shortLen = subLen + removeNum
        for (int removeNum = 1; removeNum < shortLen; removeNum++) {
            int subLen = shortLen - removeNum;// 当前匹配的字符串长度
            for (int beginIndex = 0; beginIndex < removeNum + 1; beginIndex++) {
                int endIndex = beginIndex + subLen;
                String activeStr = shortStr.substring(beginIndex, endIndex);
                if (longStr.contains(activeStr)){
                    return activeStr;
                }
            }
        }
        return null;
    }
}
