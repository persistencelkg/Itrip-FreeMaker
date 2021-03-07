package cn.itrip.bean;

import lombok.Data;

import java.util.List;

/**
 * @description: 封装模板数据 -- 数据表信息
 * @author: 浮~沉
 * @create: 2020-07-15 11:00
 */

@Data
public class DbTable {

    /**
     * 表名
     */
    private String tableName;


    /**
     * 类名 表名去除下划线并首字母大写
     */
    private String className;


    /**
     * dao下的分包
     */
    private String daoName;

    /**
     * 表-类 注释
     */
    private String comment;


    /**
     * 表中字段列表
     */
    private List<DbColumn> columnList;


}

