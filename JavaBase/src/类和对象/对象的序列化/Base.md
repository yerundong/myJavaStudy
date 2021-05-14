### Java对象的序列化和反序列化：
在Java中，我们可以通过多种方式来创建对象，并且只要对象没有被回收我们都可以复用此对象。但是，我们创建出来的这些对象都存在于JVM中的堆（heap）内存中，
只有JVM处于运行状态的时候，这些对象才可能存在。一旦JVM停止，这些对象也就随之消失；但是在真实的应用场景中，我们需要将这些对象持久化下来，并且在需要的时候
将对象重新读取出来，Java的序列化可以帮助我们实现该功能。

对象序列化机制（object serialization）是java语言内建的一种对象持久化方式，通过对象序列化，可以将对象的状态信息保存未字节数组，并且可以在有需要的
时候将这个字节数组通过反序列化的方式转换成对象，对象的序列化可以很容易的在JVM中的活动对象和字节数组（流）之间进行转换。在JAVA中，对象的序列化和反序列化被
广泛的应用到RMI（远程方法调用）及网络传输中。


### 定义一个可序列化的类的步骤：
1. 继承Serializable接口
2. 声明全局常量：serialVersionUID
- 注意：如果内部属性有其他对象，这些对象也必须是可序列化的，否则该类无法可序列化

### serialVersionUID：
简单来说，JAVA序列化的机制是通过判断类的serialVersionUID来验证的版本一致的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID于本地相应实体类
的serialVersionUID进行比较。如果相同说明是一致的，可以进行反序列化，否则会出现反序列化版本一致的异常，即是InvalidCastException。

serialVersionUID有两种显示的生成方式：
1. 是默认的1L，比如：private static final long serialVersionUID = 1L;
2. 是根据包名，类名，继承关系，非私有的方法和属性，以及参数，返回值等诸多因子计算得出的，极度复杂生成的一个64位的哈希字段。基本上计算出来的这个值是唯一的。
比如：private static final long  serialVersionUID = xxxxL;

如果类没有显示定义这个静态常量，它的值是Java运行时环境根据类的内部细节自动生成的。若类的实例变量做了修改，serialVersionUID 可能发生变化。故建议，
显式声明。

### 注意
1. static和transient修饰的成员变量无法序列化