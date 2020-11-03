package 类和对象.练习.银行业务流程;

/**
 * @Description 抽象类、模板方法的应用
 * @Author 叶润东
 * @Date 2020/11/3
 * @Version 1.0
 */
public abstract class BankTemplateMethod {

    public void takeNumber(){
        System.out.println("排队取号");
    }

    // 办理业务
    // hook 钩子函数 具体方法由子类控制，但位置由父类控制
    public abstract void transact();

    // 评分
    public void giveScore() {
        System.out.println("给五星好评");
    }

    // 流程
    public void process(){
        this.takeNumber();
        this.transact();
        this.giveScore();
    }
}

class DrawMoney extends BankTemplateMethod {

    @Override
    public void transact() {
        System.out.println("我要办理存款业务");
    }

}

