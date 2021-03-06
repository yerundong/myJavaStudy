### 接口（Interface）
接口，是Java语言中一种引用类型，是方法的集合，是多个类的公共规范。如果说类的内部封装了成员变量、构造方法和成员方法，
那么接口的内部主要就是封装了方法，其中最重要的就是的：抽象方法。接口与类是并列的两个结构

### 举例：JDBC、USB接口

### 定义方式
    public interface 接口名称 {
        // 接口内容
    }

### 接口的命名规范： 大驼峰（MyInterface）

### 接口与类的对比异同
 1. 编写接口的方式和类很相似，但是它们属于不同的概念。
 2. 类描述对象的属性和方法，接口则包含类要实现的方法。
 3. 接口不能实例化（没有构造函数），同过类实现起作用。
 4. 接口里的所有的方法必须是抽象方法。
 5. 接口支持多继承，多实现，而类只支持单继承。
 6. 与类一样，接口文件保存在.java 结尾的文件中，文件名使用接口名。
 7. 与类一样，接口的字节码文件保存在 .class 结尾的文件中。
 8. 接口不能包含成员变量、构造方法、代码块
 9. 与类一样，接口也具有多态性
 
### 不同版本Java，接口包含的内容
- Java 7包含的内容有：
1. 常量
2. 抽象方法

- Java 8，额外包含有：
3. 默认方法
4. 静态方法
 
- Java 9，额外包含有：
5. 私有方法

### 关系：
     接口-类：（多）实现
     接口-接口：（多）继承
     类-类：（单）继承

### 实现
接口不能直接使用，必须有一个“实现类”来实现该接口

- 实现关键字： implements

- 多重实现：一个“实现类”可以同时实现多个接口

### 格式
- 多重实现格式：
```
    public class 实现类名称 implements 接口名称[, 接口名称2, 接口名称3, ...] {
        ...
    }
```
- 同时继承和实现：先继承，后实现    
```
    public class ClassA extends ClassB implements Interface1, Interface2 {
        ...
    }
```
- 多重继承格式：
```
     public Interface1 extends Interface2[, Interface3, Interface4...] {
        ...
     }
```

### 标识接口
标识接口是没有任何方法和属性的接口。标识接口不对实现它的类有任何语义上的要求，它仅仅表明实现它的类属于一个特定的类型。如Serializable
