# idea文件左下角显示橙色J
- 原因：没有添加到maven
- 解决：文件-项目结构-模块-源-添加内容根目录
- 参考：[链接](https://jingyan.baidu.com/article/c910274b5c23a1cd361d2d3b.html)



# idea无法识别.md文件

- 原因：改文件被文本文件类型识别
- 解决：
1. 确保下载markdown插件；
2. 去setting-编辑器-文件类型-文本文件中看看是否有添加该文件类型。



# idea所有重载方法参数自动提示设置

- 解决：设置-编辑器-编辑器-代码完成-参数信息，勾选所有



# 设置类和接口的生成模板

- 解决：设置-编辑器-file and code templates，选择Class
- 参考：[链接](https://blog.csdn.net/qushaming/article/details/96867190)
```
/**
 * @Description TODO
 * @Author 叶润东
 * @Date ${DATE}
 * @Version 1.0
 */
```



# 设置活动模板（以方法注释模板为例）

- 解决：设置-编辑器-活动模板，创建UserDefined组,添加*
- 参考：[链接](https://blog.csdn.net/qushaming/article/details/96867190)
```
**
 * @Description TODO
 * @Param $param$
 * @Author 叶润东
 * @Date $time$ $date$
 * @return $return$
 */
```



# 编码不一致导致编译报错

- 解决：设置-编辑器-file encodings，选择utf-16，再切回GBK
- 参考：[链接](https://blog.csdn.net/qq_41723615/article/details/103908486)



# idea卡顿

- 解决：
  1. 关闭不需要的插件
  2. 设置 idea.exe.vmoptions 和 idea64.exe.vmoptions文件
- 参考：[链接](https://blog.csdn.net/zhangxingyu126/article/details/106365083)



# 错误：无效的源发行版

- 解决：设置-项目结构-项目，语言级别和sdk版本需要一致



# idea保存自动格式化代码

- 解决：
    1. 安装save-actions插件，重启
    2. 设置-其他设置-save-actions，勾选保存时需要做得操作选项
    
- 参考：[链接](https://jingyan.baidu.com/article/17bd8e529d627185ab2bb8eb.html)



# 行注释不显示在行首

- 解决：设置 -> Code Style -> Java -> 代码生成 -> 注释的代码 -> 勾选右侧的相应框



# idea单元测试System.in没办法输入

- 解决：help -> Edit Custom VM Options，加上 -Deditable.java.test.console=true



# idea可序列化类自动生成serialVersionUID

- 参考：[链接](https://blog.csdn.net/qq_27900925/article/details/100728179)



# 无限重置idea插件

settings -> plugins -> 设置-> Manage Repositories 中添加 https://plugins.zhile.io  

就可以搜索到重置插件 IDE eval reset  



# IDEA中启动Tomcat后一直在build，或者一直在Copying resource问题

- 参考：https://blog.csdn.net/weixin_42248123/article/details/107234492