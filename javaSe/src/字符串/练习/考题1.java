package 字符串.练习;

import org.junit.jupiter.api.Test;

/**
 * @考题1 模拟一个trim方法，去除字符串两端的空格
 * @考题2 获取一个字符串在另一个字符串中出现的次数
 */
public class 考题1 {
    @Test
    public void test() {
        // 考题1
        String str1 = "    abc 123 ";
        System.out.println("\"" + weed(str1) + "\"");// "abc 123"
        System.out.println("\"" + weed(str1, true) + "\"");// "abc123"

        // 考题2
        String str2 = "dddaaaddd";
        System.out.println(count(str2, "da"));
    }

    /**
     * @Description 剔除空格
     */
    public String weed(String s) {
        return s.replaceAll("^\\s+|\\s+$", "");
    }

    /**
     * @Description 剔除空格
     * @Param   global
     *          是否全部剔除
     */
    public String weed(String s, boolean global) {
        if(!global){
            return weed(s);
        }else{
            return s.replaceAll("\\s", "");
        }
    }

    /**
     * @Description 匹配个数
     */
    public int count(String s1, String s2) {
        int len1 = s1.length();
        s1 = s1.replace(s2, "");
        int len2 = s1.length();
        int len3 = s2.length();
        return (len1 - len2) / len3;
    }
}
