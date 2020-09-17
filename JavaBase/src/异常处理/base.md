### 异常：在java语言中，将程序执行中发生不正常的情况称为“异常”
> 注意：语法错误和逻辑错误不称为异常

1. Throwable 类是 Java 语言中所有错误或异常的超类（广义上的异常）。
2. Throwable有两个子类：
    1. Error：java虚拟机无法解决的严重错误，无法捕获，它们在Java程序处理的范畴之外。例如，JVM 内存溢出
    2. Exception：编程错误或偶然性的外在因素导致的一般性问题，可以用针对性的代码处理（一般说的狭义上的异常）

+ 继承关系如下：    
![继承](./截图/继承.jpg)

+ 异常分为两类：
1. 编译时异常，也叫受检异常（checked），如IOException、ClassNotFoundException、CloneNotSupportedException等
2. 运行时异常，也叫非受检异常（unchecked），Error、RuntimeException极其子类异常


