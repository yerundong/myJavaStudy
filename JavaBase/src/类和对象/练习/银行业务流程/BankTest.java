package 类和对象.练习.银行业务流程;


public class BankTest {
    public static void main(String[] args) {
        BankTemplateMethod dw = new DrawMoney();

        dw.process();
    }
}