# 安装

官网下载：https://maven.apache.org/download.cgi

免安装，解压到本地即可。



# 配置环境变量

需要配置两个环境变量：

1. MAVEN_HOME，maven解压文件的路径
2. M2_HOME，maven解压文件下bin文件夹的路径

只将%MAVEN_HOME%\bin添加到path中即可。

打开cmd，执行 `mvn -version` ，可执行则配置成功。



# 配置镜像

## 1 为什么需要配置maven国内镜像？

1、在不配置镜像的情况下,maven默认会使用**中央库**.

2、maven中央库在国外,有时候访问会很慢,尤其是下载较大的依赖的时候,有时候速度会很慢,甚至会出现无法下载的情况.

3、为了解决依赖下载速度的问题,需要配置maven国内镜像



## 2 镜像配置方式和比较

1、maven镜像有两种配置,一种是在pom.xml中进行配置,第二种是在settings.xml中进行配置.

2、在settings.xml中进行配置会对**所有maven工程**有效,当在升级maven版本的时候,需要注意复制已经配置好的settings.xml到新的maven目录下

3、使用第一种配置pom.xml的方式只会对**当前工程**有效,本文建议大家使用第二种配置方式。



## Maven 常用镜像站地址

https://blog.csdn.net/geekswg/article/details/119976216



# 配置本地仓库

新建一个本地文件，将其路径添加到settings.xml中的localRepository标签。以后下载到本地的包将会储存在此处。如下：

```
<localRepository>D:\apache-maven-3.8.4\maven-repo</localRepository>
```



# IDEA配置Maven

![20220105164910](.\images\maven\20220105164910.png)

配置导入参数：

![20220105170251](.\images\maven\20220105170251.png)

# 使用maven创建一个项目

![20220105171005](.\images\maven\20220105171005.png)

不使用模板创建，创建完目录结构为：

![20220105171501](.\images\maven\20220105171501.png)

如果是web项目，则在main下增加目录：

![20220105172326](.\images\maven\20220105172326.png)



# POM

https://www.runoob.com/maven/maven-pom.html

https://blog.csdn.net/shao_yc/article/details/105317764

https://www.cnblogs.com/64Byte/p/13054759.html
