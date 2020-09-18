###### title
##### title
#### title
### title
## title
# title

## items

- item1
- item2
- item3
+ item1
+ item2
+ item3
* item1
* item2
* item3
1. item1
2. item2
3. item3

- a
  - b
    - c
        - d
        - e
          - f

## block

> block1
>> block2
>>> block3  

## code block

`Single line code`   

    method () {  
        Multiline code  
    }
    
```js
const obj = {   
    msg: "Multiline code"  
}  
```    

## link

[url]: http://www.google.com/
1. 这是一个链接 [菜鸟教程](https://www.runoob.com)
2. go to [block](#block)
3. 变量地址 [Google][url]  

## image

+ 用法：`![alt属性](图片地址 "可选标题")`  

![RUNOOB图标](http://static.runoob.com/images/runoob-logo.png "标题")

+ 使用变量： 

[img]: https://t8.baidu.com/it/u=3571592872,3353494284&fm=79&app=86&size=h300&n=0&g=4n&f=jpeg?sec=1600936275&t=41bf42bdb7648be6f6b6415d2275cb88
![美女][img]
  
 ## table
 
 |  表头   | 表头  |
 |  ----  | ----  |
 | 单元格  | 单元格 |
 | 单元格  | 单元格 |
 
 | 左对齐 | 右对齐 | 居中对齐 |
 | :-----| ----: | :----: |
 | 单元格 | 单元格 | 单元格 |
 | 单元格 | 单元格 | 单元格 |
 
 使用 <kbd>Ctrl</kbd>+<kbd>Alt</kbd>+<kbd>Del</kbd> 重启电脑
 
 - [boss-admin-web](#boss-admin-web)
   - [目录结构](#目录结构)
   - [框架使用](#框架使用)
     - [接口配置](#接口配置)
     - [模块集成](#模块集成)
     - [菜单配置](#菜单配置)
   - [模块开发约定](#模块开发约定)
     - [属性注入](#属性注入)
     - [异步组件](#异步组件)
   - [框架功能](#框架功能)
     - [登录拦截](#登录拦截)
     - [接口请求](#接口请求)
     - [接口模拟](#接口模拟)
     - [接口代理](#接口代理)
     - [异常捕获](#异常捕获)
     - [在线换肤](#在线换肤)
   - [开发规范](#开发规范)
     - [UI规范](#UI规范)
     - [文件命名规范](#文件命名规范)
     - [代码规范](#代码规范)
   - [其他](#其他)
     - [资源引用](#资源引用)
     - [常见问题](#常见问题)
   - [Build Setup](#build-setup)
   
 ```
 ├── public
 │ ├── index.html
 │ ├── static --静态资源
 │   └── theme --主题目录
 │     └── default --主题名称
 │       ├── style.css --外部化资源
 ├── src
 │ ├── api  --接口注册
 │ ├── assets  --内部资源
 │ ├── components --通用组件
 │   └── business --通用业务组件
 │   └── common --通用非业务组件
 │ ├── config  --系统配置
 │ ├── constant  --系统常量定义
 │ ├── directive  --全局指令
 │ ├── filter  --全局过滤器
 │ ├── mock  --接口模拟
 │ ├── plugin  --全局插件
 │ ├── router  --路由器
 │ ├── store  --数据中心
 │ ├── util  --工具函数
 │ ├── views  --业务模块
 │ ├── App.vue --入口组件
 │ └── main.js --入口函数
 ```
