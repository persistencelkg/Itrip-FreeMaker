package cn.itrip.util;

import cn.itrip.bean.DBColumn;
import cn.itrip.bean.DBTable;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 用于获取数据库的详细信息
 * 表 字段 类型
 * @author: 浮~沉
 * @create: 2020-07-15 10:11
 */
public class DbTableUtil {

    private static final String DRIVER_CLASS_NAME = PropertiesUtil.getValue("driverClassName");

    private static final String URL = PropertiesUtil.getValue("url");

    private static final String UNAME = PropertiesUtil.getValue("uname");

    private static final String PASSWORD = PropertiesUtil.getValue("password");

    private static Connection connection = null;
    private static DatabaseMetaData metaData = null;

    static {
        //获取数据库连接
        try {
            Class.forName(DRIVER_CLASS_NAME);
            //获取数据库连接
            connection = DriverManager.getConnection(URL, UNAME, PASSWORD);
            //获取元数据
            metaData = connection.getMetaData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取数据库中的所有表信息
     * @return
     */
    public static List<DBTable> getTable() {
        //获取所有表名 的结果集
        ResultSet rs = null;
        List<DBTable> tableList = new ArrayList<>();
        try {
            //catalog: mysql中没有这个属性 oracle,我是基于mysql所以设置null
            //shemaPattern: 那个数据库 默认就是连接的数据库名 为null就是默认
            //tableNamePattern: 表名的正则匹配 为null代表都要
            //最后一个取出所有表信息
            //**********************************************************************************************************
            //                                                 特别注意
            //mysql驱动5.x 获取连接数据库信息 直接使用metaData.getTables(null, null, null, new String[]{"TABLE"});
            //mysql驱动8.x 若直接使用上面会获取所有数据库的所有表信息
            //解决方案: 在db.propertie 设置nullCatalogMeansCurrent为true, 8.x默认为false
            //**********************************************************************************************************

            rs = metaData.getTables(null, null, null, new String[]{"TABLE"});
        //遍历结果集
            while(rs.next()) {
                String tableName = rs.getString("TABLE_NAME");
                DBTable table = new DBTable();
                table.setTableName(tableName);
                table.setClassName(StringUtil.removeUnderLine(tableName));
                table.setColumnList(getColumns(tableName));
                table.setComment(getTableComment(tableName));
                table.setDaoName(StringUtil.toLowerFirstWord(StringUtil.removeUnderLine(tableName)));
                tableList.add(table);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                if(rs != null)
                    rs.close();
                if(connection != null)
                    connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return  tableList;

    }


    /***
     * 获取表注释
     * @param tableName
     * @return
     * @throws SQLException
     */
    private static String getTableComment(String tableName) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("show create table " + tableName);
        ResultSet rs = statement.executeQuery();
        String secondColumn = null;
        if(rs != null && rs.next())
            secondColumn = rs.getString(2);
        int commentIndex = secondColumn.indexOf("COMMENT='");
        if(commentIndex == -1) {
            return "";
        } else {
            String comment = null;
            //COMMENT=' 长度为9
            comment = secondColumn.substring(commentIndex + 9);
            //舍弃最后一个逗号
            return comment.substring(0, comment.length() - 1);
        }

    }




    /**
     * 获取表中的所有字段信息
     * @param tableName
     */
    private static List<DBColumn> getColumns(String tableName) throws SQLException {
        List<DBColumn> columnList = new ArrayList<>();

        ResultSet rsColumns = metaData.getColumns(null, "%", tableName, "%");
        //遍历table下的所有字段
        while (rsColumns.next()) {

        //获取列名
            String columnName = rsColumns.getString("COLUMN_NAME");
            //为了抽离BasePojo 需要这段代码 但是其他模版生成不能有 故分开启动模版生成
            if(columnName.equals("id") || columnName.equals("creationDate")||
                        columnName.equals("createdBy") || columnName.equals("modifyDate") || columnName.equals("modifiedBy") )
                continue;
        //获取列的类型
            String typeName = rsColumns.getString("TYPE_NAME");
        //获取列的注释
            String remarks = rsColumns.getString("REMARKS");

            DBColumn column = new DBColumn();
            column.setColumnName(columnName);
            column.setAttributeName(columnName);
            column.setColumnJdbcType(typeName);
        //jdbc-->java
            column.setColumnJavaType(SwitchTypeUtil.getJavaType(typeName));
        //首字母大写
            column.setUpperColumnName(StringUtil.toUpperWithIndex(columnName, 1));
            column.setComment(remarks);

            columnList.add(column);
        }

        return  columnList;
    }




    public static void main(String[] args) throws Exception {
        List<DBTable> table = getTable();
        table.forEach(System.out::println);
        //getColumns("web_admin");
    }


}
