package 多态.练习.USB接口;

public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer();

        // 电脑开机
        computer.powerOn();

        // 创建一个鼠标
        Mouse mouse = new Mouse();
        // 向上转型
        USB usbMouse = mouse;
        // 使用鼠标
        computer.useUsbDevice(usbMouse);

        // 创建一个键盘
        Keyboard keyboard = new Keyboard();
        // 使用键盘
        computer.useUsbDevice(keyboard);// 注意：这里会发生自动类型转换（向上转型），keyboard -> USB

        // 电脑关机
        computer.powerOff();
    }
}
