package cn.itrip.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @description: 封装数据表中列的信息
 * @author: 浮~沉
 * @create: 2020-07-15 11:02
 */

@ToString
public class DBColumn {

    @Getter
    @Setter
    private String columnName;      //列名称

    @Getter
    @Setter   
    private String attributeName;   //属性名称 本项目中列名==属性名 如果有的数据库设计的不对应改属性适用于mybatis的resultMap匹配

    @Getter
    @Setter
    private String columnJdbcType;  //列的jdbc类型

    @Getter
    @Setter
    private String columnJavaType;  //列的java类型

    @Getter
    @Setter
    private String upperColumnName; //首字母大写列名  为set/get方法提供 当然如果使用lomock就无需配置了

    @Getter
    @Setter
    private String comment;         //列的注释









































}
