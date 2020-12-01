package 字符串;

/**
 * @Description TODO
 */
public class ggg {
    public static void main(String[] args) {
        // <名称> public boolean endsWith(String suffix)
        // <解释> 判断字符串是否以 suffix 结尾
        // <名称> public boolean startsWith(String suffix)
        // <解释> 判断字符串是否以 suffix 开头
        // <名称>  public boolean startsWith(String prefix, int toffset)
        // <解释> 判断字符串从 toffset （包含）索引开始，是否以 suffix 开头
        String str15 = "Gemute";
        System.out.println("endsWith = " + str15.endsWith("te"));// true
        System.out.println("endsWith = " + str15.endsWith("AGemute"));// false
        System.out.println("startsWith = " + str15.startsWith("G"));// true
        System.out.println("startsWith = " + str15.startsWith("mut"));// false
        System.out.println("startsWith = " + str15.startsWith("mut", 2));// true

        // <名称> public boolean contains(CharSequence s)
        // <解释> 判断字符串是否包含 s
        // <底层实现> return indexOf(s.toString()) >= 0;
        System.out.println("contains = " + str15.contains("emu"));// true
        System.out.println("contains = " + str15.contains("emue"));// false

        // <名称> public int lastIndexOf(String str/int ch)
        // <解释> 返回最后一次出现目标字符串 str 或目标字符 ch 的索引位置，未找到返回-1
        // <名称> public int lastIndexOf(String str/int ch, int fromIndex)
        // <解释> 索引0 - fromIndex之间寻找，返回最后一次出现目标字符串 str 或目标字符 ch 的索引位置，未找到返回-1
        // <注> int ch是字符对应的Unicode值，传入char会自动转型
        String str16 = "hello2hello";
        System.out.println("lastIndexOf = " + str16.lastIndexOf("e"));// 7
        System.out.println("lastIndexOf = " + str16.lastIndexOf('2'));// 5
        System.out.println("lastIndexOf = " + str16.lastIndexOf('2'+0));// 5
        System.out.println("lastIndexOf = " + str16.lastIndexOf("e", 2));// 1
    }
}
