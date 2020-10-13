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
        //注意: 这里需要和DbTableUtil的133行-137行代码对应
        //若上面代码区间没有注释 就是开启model层模版生成
        //若已经注释 就是开启其他模版生成
       /* for (DBTable table : dbTables) {
            mvcHandler.executeService(table);
            mvcHandler.executeServiceImpl(table);
            mvcHandler.executeMapper(table);
            mvcHandler.executeClazzMapper(table);
        }*/
        for (DBTable table : dbTables) {
            mvcHandler.executeModel(table);
        }


    }
}