package 异常处理;

import java.io.IOException;

/*
* 一、手动生成异常对象，并抛出
*
* 格式：throw 异常对象
*
* 注：一般throw内置对象选择 Exception 或 RuntimeException
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
            Student stu1 = new Student(1);
            Student stu2 = new Student(-1);
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println("id必须大于0");
        }
    }

    static class Student{
        private int id;

        public Student(int id) throws NumberSmallerThanZeroException {
            if(id > 0){
                this.id = id;
            }else{
                throw new NumberSmallerThanZeroException("id必须大于0");
            }
        }
    }

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
