package 异常处理;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/*
@ try-catch-finally：用来捕获并处理异常（编译时+运行时）
@ 注意：
    1.catch只捕获对应的异常类，一旦捕获，将不执行其他catch
    2.catch参数，子类应在前，父类在后，不然报错
    3.finally兜底，放在最后，无论有没有发生异常，异常有没有捕获，他无论如何都会执行
    4.try中只要检测到异常，代码将中止，进入catch或finally代码块
    5.catch代码块中若也发生异常，会进入同级的finally中
    6.运行时异常一般不必用try-catch-finally处理，因为太多了，编译时必须处理，将它延迟到运行时出现

@ try-catch-finally中的return：
    1.try、catch、finally的代码块执行不会被return截止，会先执行各自return前的代码，最后执行return
    2.try、catch、finally只会执行一次return
    3.finally的return优先级大于try、catch

*/
public class TryCatch {
    public static void main(String[] args) {
        int[] arr1 = new int[1];
        String str1 = "abc";
        try {
            // 运行时异常
            // System.out.println(arr1[1]);// Exception--ArrayIndexOutOfBoundsException
            // System.out.println(str1.charAt(3));// Exception
            // int[] ints = new int[1024 * 1024 * 1024];// Error--OutOfMemoryError

            // 编译时异常
            File file = new File("text.txt");
            FileInputStream fis = new FileInputStream(file);// FileNotFoundException
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("出现异常--数组索引越界");
        }catch (FileNotFoundException e){
            System.out.println("出现异常--FileNotFoundException");
        }catch (OutOfMemoryError e){
            System.out.println("出现错误--OutOfMemoryError");
            System.out.println(str1.charAt(3));
        }
        catch (Exception e){
            System.out.println("e：" + e);
            System.out.println("toString()：" + e.toString());
            System.out.println("getMessage()：" + e.getMessage());
            System.out.println("getStackTrace()：" + e.getStackTrace());
            System.out.println("getLocalizedMessage()：" + e.getLocalizedMessage());
            // e.printStackTrace();
            System.out.println("出现异常--Exception");
        }catch (Error e){
            System.out.println(e);
            System.out.println("出现错误--Error");
        }finally {
            System.out.println("--finally--");
        }

        System.out.println(says());// 2
    }

    static int says(){
        int[] arr1 = new int[1];
        try{
            System.out.println(arr1[1]);
            return 1;
        }catch (Exception e){
            System.out.println("*** catch ***");
            return 2;
        }finally {
            System.out.println("*** finally ***");
            return 3;
        }
    }
}
