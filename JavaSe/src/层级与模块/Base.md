> 层级顺序：项目-模块-包-源文件

> 源文件：.java 结尾的文件

> 字节码文件：也叫class文件（Java class），以 .class 结尾，是源文件编译完生成的

### 包
包主要用来对类和接口进行分类。当开发 Java 程序时，可能编写成百上千的类，因此很有必要对类和接口进行分类。

> 包声明格式 
* package packageName1.packageName2.packageName3

> 包命名规范
* 小驼峰（myPackage）

> 注意事项：
1. 如果一个类定义在某个包中，那么 package 语句应该在源文件的首行。
2. package 语句对源文件中定义的所有类都有效。