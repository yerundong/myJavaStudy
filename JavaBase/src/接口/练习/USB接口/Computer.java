package 接口.练习.USB接口;

public class Computer {

    // 电脑开机
    public void powerOn(){
        System.out.println("电脑开机");
    }

    // 电脑关机
    public void powerOff(){
        System.out.println("电脑关机");
    }

    // 使用USB设备
    public void useUsbDevice(USB usbDevice){
        usbDevice.open();

        // 特有行为，需要向下转型
        if(usbDevice instanceof Mouse){
            // 向下转型
            Mouse mouse = (Mouse) usbDevice;
            mouse.click();
        }else if(usbDevice instanceof Keyboard){
            // 向下转型，匿名写法
            ((Keyboard) usbDevice).type();
        }

        usbDevice.close();
    }
}
