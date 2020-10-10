# Itrip-FreeMaker ![](https://img.shields.io/badge/license-MIT-blue)
分布式系统FreeMaker模版构建发布

## 适用范围
 对分布式框架的搭建很适用，小型项目需要进一步配置分包路径

## 安装使用
1.直接下载本仓库 然后使用IDEA直接打开并做如下配置
  + 打开PathConstant类根据注释含义修改路径
  + 进入模板路径ftl文件夹下根据你的项目需要修改 当然你需要对FreeMarker语法有过了解

2. 其他文件不需要变动 如果是小型web项目需要在MvcHandler进行进一步配置分包路径 其他不需要变动！

3. 需要的依赖MySql5.7+  jdk1.7+  FreeMarker2.3.23 具体以pom.xml为准

```java
  
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.2</version>
        </dependency>
        <dependency>
            <groupId>org.freemarker</groupId>
            <artifactId>freemarker</artifactId>
            <version>2.3.23</version>
        </dependency>
        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>1.2.12</version>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.26</version>
        </dependency>
```