# 开发流程
1. 分析需求，设计原型，编写需求文档
2. 前端：编写前端静态页面
3. 数据库：创建数据库，分析需求，列举出所有需求所需的对象，然后创建对应的表，比如用户表、商品表等，设计表结构、表字段。
4. 后端：
   1. 创建java代码目录结构：controller、dao、pojo、service、test、utils；
   2. 创建表对应的bean对象，入用户对象：User，商品对象：Goods等；
   3. 编写jdbcUtils并测试，创建druid配置文件，配合druid连接池、Apache Commons DBUtils使用，这些作为提供操作jdbc的工具方法；
   4. 编写BaseDao抽象类并测试，包含基本的增删改查方法；
   5. 编写bean对象对应的dao接口，如UserDao、GoodsDao；
   6. 编写bean对象对应的dao实现类并测试，如UserDaoImpl、GoodsDaoImpl；




# 启动步骤

1. 若未建库、表，请先执行db/init.sql文件
2. 

