package cn.itrip.bean;

import lombok.Data;

/**
 * @description: 封装数据表中列的信息
 * @author: 浮~沉
 * @create: 2020-07-15 11:02
 */

@Data
public class DbColumn {

    /**
     * 列名称 - mybatis的映射文件
     */
    private String columnName;

    /**
     * 属性名称 - 查询条件
     * tip：可以根据情况进行映射，映射方式自行决定
     */
    private String attributeName;

    /**
     * 列的jdbc类型
     */
    private String columnJdbcType;

    /**
     * 列的java类型
     */
    private String columnJavaType;

    /**
     * 首字母大写列名  为set/get方法提供 当然如果使用lomock就无需配置了
     */
    private String upperColumnName;

    /**
     * 列的注释
     */
    private String comment;









































}
