package 异常处理;

import java.io.IOException;

/**
 *
 @作用： 抛出异常对象
    注：异常对象是指 Throwable 或其子类的对象

 @格式： throw 异常对象

 @注： 抛出非自定义异常，一般选择 Exception 或 RuntimeException
*
* 二、生成自定义异常对象，并抛出
*
* 如何自定义异常对象？
* 1.创建一个类，继承Exception 或 RuntimeException
* 2.提供静态常量：serialVersionUID
* 3.提供重载构造器
*
* */
public class throw关键字 {

    public static void main(String[] args) {
        try {
            Student stu1 = new Student(0);
        } catch (NumberSmallerThanZeroException e) {
            System.out.println("id必须大于0");
            e.printStackTrace();
        } catch (RuntimeException e) {
            System.out.println("id不能等于0");
            e.printStackTrace();
        }
    }

    static class Student{
        private int id;

        public Student(int id) throws RuntimeException {
            if(id > 0){
                this.id = id;
            }else if (id == 0){
                // 抛出内置异常
                throw new RuntimeException("id不能等于0");
            }else{
                // 抛出自定义异常
                throw new NumberSmallerThanZeroException("id必须大于0");
            }
        }
    }

    // 自定义异常
    static class NumberSmallerThanZeroException extends RuntimeException{
        @java.io.Serial
        static final long serialVersionUID = -703489633745766939L;

        public NumberSmallerThanZeroException() {
            super("数字小于0异常");
        }

        public NumberSmallerThanZeroException(String message) {
            super(message);
        }
    }
}
