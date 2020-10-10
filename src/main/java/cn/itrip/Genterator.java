package cn.itrip;

import cn.itrip.bean.DBTable;
import cn.itrip.handler.MvcHandler;
import cn.itrip.util.DbTableUtil;

import java.util.List;

/**
 * 总生成器
 */


public class Genterator {

    public static void main(String args[]) throws Exception {
        List<DBTable> dbTables = DbTableUtil.getTable();
        MvcHandler mvcHandler = new MvcHandler();
        for (DBTable table : dbTables) {
            mvcHandler.executeModel(table);
            mvcHandler.executeService(table);
            mvcHandler.executeServiceImpl(table);
            mvcHandler.executeMapper(table);
            mvcHandler.executeClazzMapper(table);
        }
    }
}