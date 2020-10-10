package cn.itrip.handler;


import cn.itrip.bean.DBTable;
import cn.itrip.util.FreeMarkerUtil;
import cn.itrip.util.PathConstant;
import cn.itrip.util.StringUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 三层组件的模版生成控制器
 * 需要注意两点: 此处的模版生成 是基于分布式系统  如果是小型项目 建议直接修改PathContant里的参数
 */

public class MvcHandler {


    /**
     * 初始化数据模版数据
     * @param table
     * @return
     */
    private Map initDataMap(DBTable table) {
        Map input = new HashMap();
        input.put("table", table);
        input.put("package", PathConstant.PACKAGE);
        return input;
    }

    /**
     * 生成Model层
     * @param table
     */
    public void executeModel(DBTable table) {
        Map data = initDataMap(table);
        String saveFileName = table.getClassName() + ".java";
        FreeMarkerUtil.generateFile(data, "model.ftl", PathConstant.MODEL_SAVE_PATH, saveFileName);
    }


    /***
     * 生成服务层
     * @param table
     */
    public void executeService(DBTable table) {
        Map data = initDataMap(table);
        String saveFileName = table.getClassName() + "Service.java";
        String savePath = PathConstant.SERVICE_SAVE_PATH + StringUtil.toLowerFirstWord(table.getClassName());
        FreeMarkerUtil.generateFile(data,  "service.ftl", savePath, saveFileName);
    }

    /**
     * 生成服务层实现类
     * @param table
     */
    public void executeServiceImpl(DBTable table) {
        Map data = initDataMap(table);
        String saveFileName = table.getClassName() + "ServiceImpl.java";
        String savePath = PathConstant.SERVICE_IMPL_SAVE_PATH + StringUtil.toLowerFirstWord(table.getClassName());
        FreeMarkerUtil.generateFile(data,  "serviceImpl.ftl", savePath, saveFileName);
    }

    public void executeMapper(DBTable table) {
        Map data = initDataMap(table);
        String saveFileName = table.getClassName() + "Mapper.xml";
        String savePath = PathConstant.MAPPER_SAVE_PATH + StringUtil.toLowerFirstWord(table.getClassName());
        FreeMarkerUtil.generateFile(data,  "mapper.ftl", savePath, saveFileName);
    }

    public void executeClazzMapper(DBTable table) {
        Map data = initDataMap(table);
        String saveFileName = table.getClassName() + "Mapper.java";
        String savePath = PathConstant.MAPPER_SAVE_PATH + StringUtil.toLowerFirstWord(table.getClassName());
        FreeMarkerUtil.generateFile(data,  "clazzMapper.ftl", savePath, saveFileName);
    }
}
