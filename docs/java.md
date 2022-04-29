# 总概

JavaSE、JavaEE、JavaME共同组成了java整个体系。

三者关系：

![20200114171423813](.\images\java\20200114171423813.png)

## JavaSE

Java SE 以前称为 J2SE。现在通常是指Java Standard Edition，Java标准版，就是一般Java程序的开发就可以(如桌面程序)，可以看作是JavaEE的子集。它允许开发和部署在桌面、服务器、嵌入式环境和实施环境中使用的Java应用程序。JavaSE 包括支持JavaＷeb服务开发的类，并为JavaEE提供基础。

可以理解为javaSE是java的基石，如果将java程序想象成一座高楼大厦，那么javaSE就是地基。

**javaSE包含了：**

1. 面向对象
2. 多线程
3. IO流
4. javaSwing
5. 等



## JavaEE

Java Enterprise Edition，Java企业版，多用于企业级开发，包括web开发等等。之前称为Java 2 Platform, Enterprise Edition (J2EE) ，2018年3月更名为 **Jakarta**
EE(这个名称应该还没有得到群众认可)。  是 Sun 公司为企业级应用推出的标准平台，用来开发B/S架构软件。

JavaEE帮助开发和部署可移植、健壮、可伸缩切安全的服务端Java应用。Java EE是**在JavaSE的基础上**构建的他提供Web 服务、组建模型、管理和通信API.可以用来实现企业级的面向服务体系结构(service-oriented architecture,SOA)和web2.0应用程序。

javaEE个人理解的就是在javaSE的基础上，添砖加瓦后出现的一种规范，说是框架也行。

同时要知道：**JavaEE 是 Java 应用最广泛的部分。**

**JavaEE包含了：**

1. servlet
2. jstl
3. jsp
4. spring
5. mybatis
6. 等



## JavaME

Java ME 又称为J2ME（Java Platform，Micro Edition），是为机顶盒、移动电话和PDA之类嵌入式消费电子设备提供的Java语言平台，包括虚拟机和一系列标准化的Java API。



# 三层架构模式

https://www.cnblogs.com/1994-12/p/9958274.html?ivk_sa=1024320u

https://blog.csdn.net/liguangyao213/article/details/123210858?utm_medium=distribute.pc_relevant.none-task-blog-2~default~baidujs_baidulandingword~default-1.pc_relevant_default&spm=1001.2101.3001.4242.2&utm_relevant_index=3

![JavaEE的三层架构](.\images\java\JavaEE的三层架构.png)



## 各层命名规则

![360截图17001013355343](.\images\java\360截图17001013355343.png)