package 字符串;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 @CharSequence： CharSequence是char值的可读序列。
     @所有已知实现类：
        CharBuffer ， Segment ， String ， StringBuffer ， StringBuilder

 @注： 由于String的不可变性，String的所有方法都不会改变字符串

 @关键点： 左闭右开，原字符串不变，正则表达式

 */
public class 常用方法 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String topStr = "Hello Java";

        {
            // <名称> public int length()
            // <解释> 返回字符串长度
            // <底层实现> byte[]数组的长度：value.length
            System.out.println("length：" + topStr.length());
        }

        {
            // <名称> public String concat(String str)
            // <解释> 拼接,等价于+，创建一个新的 String 对象并返回
            String str1 = ", I am studying.";
            String str2 = topStr.concat(str1);
            System.out.println("concat：" + str2);
        }

        {
            // <名称> public char charAt(int index)
            // <解释> 返回指定索引处的 char 值。
            char char1 = topStr.charAt(1);
            System.out.println("charAt：" + char1);
        }

        {
            // <名称> public int indexOf(String str/char char)
            // <解释> 返回指定字符（串）在此字符串中第一次出现处的索引,未找到返回-1
            // <名称> indexOf(String str/char char, int fromIndex)
            // <解释> 返回指定字符（串）在此字符串中第一次出现处的索引,从指定的索引 fromIndex (包含)开始,未找到返回-1
            System.out.println("indexOf：" + topStr.indexOf("l"));
            System.out.println("indexOf：" + topStr.indexOf('l'));
            System.out.println("indexOf：" + topStr.indexOf("Java"));
            System.out.println("indexOf：" + topStr.indexOf("l", 3));
        }

        {
            // <名称> public int lastIndexOf(String str/int ch)
            // <解释> 返回最后一次出现目标字符串 str 或目标字符 ch 的索引位置，未找到返回-1
            // <名称> public int lastIndexOf(String str/int ch, int fromIndex)
            // <解释> 索引0 - fromIndex之间寻找，返回最后一次出现目标字符串 str 或目标字符 ch 的索引位置，未找到返回-1
            // <注> int ch是字符对应的Unicode值，传入char会自动转型
            String str = "hello2hello";
            System.out.println("lastIndexOf ：" + str.lastIndexOf("e"));// 7
            System.out.println("lastIndexOf ：" + str.lastIndexOf('2'));// 5
            System.out.println("lastIndexOf ：" + str.lastIndexOf('2'+0));// 5
            System.out.println("lastIndexOf ：" + str.lastIndexOf("e", 2));// 1
        }

        {
            // <名称> public boolean contains(CharSequence s)
            // <解释> 判断字符串是否包含 s
            // <底层实现> return indexOf(s.toString()) >= 0;
            String str = "Gemute";
            System.out.println("contains ：" + str.contains("emu"));// true
            System.out.println("contains ：" + str.contains("emue"));// false
        }

        {
            // <名称> public String substring(int beginIndex)
            // <解释> 剪切，从指定索引 beginIndex (包含)的字符开始，直到此字符串末尾，创建并返回剪切的字符串。
            // <名称>  public String substring(int beginIndex, int endIndex)
            // <解释> 剪切，从指定索引 beginIndex (包含)的字符开始，直到索引 endIndex （不包含）结束，创建并返回剪切的字符串。
            // <ps> 左闭右开[)，beginIndex - 起始索引（包含）,endIndex - 结束索引（不包含）。
            String str1 = topStr.substring(6);//
            String str2 = topStr.substring(6, 7);
            System.out.println("substring：" + str1);
            System.out.println("substring：" + str2);
        }

        {
            // <名称> public char[] toCharArray()
            // <解释> 将此字符串转换为一个新的字符数组并返回。
            char[] charArr1 = topStr.toCharArray();
            System.out.println("toCharArray：" + charArr1[0]);
        }


        {
            // <名称> public byte[] getBytes()
            // <解释> 编码，将此字符串转换为一个新的字节数组并返回，使用默认字符集转换。
            // <名称> public byte[] getBytes(String charsetName)
            // <解释> 编码，将此字符串转换为一个新的字节数组并返回，使用特定字符集转换。
            String str = "abc123中国";
            byte[] byteArr1 = str.getBytes();
            byte[] byteArr2 = str.getBytes("UTF-16");
            byte[] byteArr3 = str.getBytes("US-ASCII");
            byte[] byteArr4 = str.getBytes("GBK");
            System.out.println("getBytes：" + Arrays.toString(byteArr1));
            System.out.println("getBytes：" + Arrays.toString(byteArr2));
            System.out.println("getBytes：" + Arrays.toString(byteArr3));
            System.out.println("getBytes：" + Arrays.toString(byteArr4));
        }

        {
            // <名称>  public native String intern()
            // <解释> 当调用 intern 方法时，如果常量池已存在一个等于此 String 对象的字符串（用 equals(Object) 方法确定），则返回池中的字符串。
            //       否则，将此 String 对象添加到池中，并返回此 String 对象的引用。
            // <返回> 返回内容一致的数组，不过是在放在常量池中的
            String str1 = new String("abc");
            String str2 = str1.intern();
            String str3 = "abc";
            System.out.println("intern：" + str1 == str2);// false
            System.out.println("intern：" + str2 == str3);// true
        }

        {
            // <名称> public boolean isEmpty()
            // <返回> length()为0时返回true,其他返回false
            System.out.println("isEmpty1 ：" + topStr.isEmpty());// false
            System.out.println("isEmpty2 ：" + "".isEmpty());// true
        }

        {
            // <名称> public String toLowerCase()
            // <名称> public String toUpperCase()
            // <返回> 转换大小写,创建并返回新的字符串。
            System.out.println("toLowerCase ：" + "abcDef123".toLowerCase());
            System.out.println("toUpperCase ：" + "abcDef123".toUpperCase());
        }

        {
            // <名称> public String trim()
            // <返回> 去除首位空格,创建并返回新的字符串。
            // <应用> 用户输入账号密码可用到
            System.out.println("trim =" + " ab cd   ".trim() + ";");
        }

        {
            // <名称> public int compareTo(String anotherString)
            // <返回> 按字典顺序比较两个字符串。 比较是基于字符串中每个字符的Unicode值。 由该String对象表示的字符序列按字典顺序与由参数字符串表示的字符序列进行比较。
            // <应用>
            // 用于字符串排序比较
            String str1 = "abc";// c99
            String str2 = "abde";// d100 e101
            String str3 = "5";
            String str4 = "10";
            System.out.println("compareTo ：" + str1.compareTo(str2));
            System.out.println("compareTo ：" + str3.compareTo(str4));
        }

        {
            // <名称> public boolean endsWith(String suffix)
            // <解释> 判断字符串是否以 suffix 结尾
            // <名称> public boolean startsWith(String suffix)
            // <解释> 判断字符串是否以 suffix 开头
            // <名称>  public boolean startsWith(String prefix, int toffset)
            // <解释> 判断字符串从 toffset （包含）索引开始，是否以 suffix 开头
            String str = "Gemute";
            System.out.println("endsWith ：" + str.endsWith("te"));// true
            System.out.println("endsWith ：" + str.endsWith("AGemute"));// false
            System.out.println("startsWith ：" + str.startsWith("G"));// true
            System.out.println("startsWith ：" + str.startsWith("mut"));// false
            System.out.println("startsWith ：" + str.startsWith("mut", 2));// true
        }

        {
            // <名称> replace(CharSequence target, CharSequence replacement)
            // <名称> public String replace(char oldChar, char newChar)
            // <解释> 替换，匹配所有 target 字符串，替换成 replacement 字符串，创建并返回新的字符串。
            String str1 = "北京在北边所以叫北京";
            String str2 = str1.replace("北", "东");
            String str3 = str1.replace('京', '城');
            System.out.println("replace：" + str2);
            System.out.println("replace：" + str3);
        }

        {
            // <名称> public String replaceAll(String regex, String replacement)
            // <解释> 替换，匹配所有 regex 字符串，替换成 replacement 字符串，创建并返回新的字符串。
            // <注> regex 字符串表示正则表达式的字符串
            String str1 = "123abc四五六，123abc四五六";
            String str2 = str1.replaceAll("abc", "ABC");
            String str3 = str1.replaceAll("\\d+", "。");
            String str4 = str1.replaceAll("^123|四五六$|，", "*");
            System.out.println("replaceAll：" + str2);
            System.out.println("replaceAll：" + str3);
            System.out.println("replaceAll：" + str4);
        }

        {
            // <名称> public boolean matches(String regex)
            // <解释> 匹配，匹配字符串是否符合正则表达式的规则
            // <注> regex 字符串表示正则表达式的字符串
            String str1 = "123abc四五六，123abc四五六";
            System.out.println("matches：" + str1.matches(".*abc.*"));// true
            System.out.println("matches：" + str1.matches("^123[a-z]{3}.*四五六$"));// true
        }

        {
            // <名称> public String[] split(String regex)
            // <名称> public String[] split(String regex, int limit)
            // <参数> regex 分割标识符，limit 切割个数阈值
            // <解释> 分割，从左往右切割，直到达到阈值为止，创建并返回的字符串数组。
            // <注> regex 字符串表示正则表达式的字符串
            String str = "aaa,bbb,ccc,ddd";
            String[] stringArr1 = str.split(",");// {"aaa", "bbb", "ccc", "ddd"}
            String[] stringArr2 = str.split(",", 2);// {"aaa", "bbb,ccc,ddd"}
            System.out.println("split：" + Arrays.toString(stringArr1));
            System.out.println("split：" + Arrays.toString(stringArr2));
        }
    }
}
