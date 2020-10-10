package cn.itrip.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @description: 封装模板数据 -- 数据表信息
 * @author: 浮~沉
 * @create: 2020-07-15 11:00
 */

@ToString
public class DBTable {

    @Getter
    @Setter
    private String tableName;               //表名


    @Getter
    @Setter
    private String className;               //类名 表名去除下划线并首字母大写


    @Getter
    @Setter
    private String daoName;                //dao下的分包 来自于

    @Getter
    @Setter
    private String comment;                 //表-类 注释


    @Getter
    @Setter
    private List<DBColumn> columnList;      //表中字段列表


}

