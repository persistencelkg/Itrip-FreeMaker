package cn.itrip.handler;


import cn.itrip.bean.DbTable;
import cn.itrip.util.FreeMarkerUtil;
import cn.itrip.util.PathConstant;
import cn.itrip.util.StringUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 三层组件的模版生成控制器
 * 需要注意两点: 此处的模版生成 是基于分布式系统  如果是小型项目 建议直接修改PathContant里的参数
 * @author lkg 
 */

public class MvcHandler {


    /**
     * 初始化数据模版数据
     * @param table 表
     * @return 模版数据集
     */
    private Map<String, Object>  initDataMap(DbTable table) {
        Map<String, Object>  input = new HashMap<>(16);
        input.put("table", table);
        input.put("package", PathConstant.PACKAGE);
        Map<String, String> map= System.getenv();
        // 获取用户名
        String userName = map.get("USER");
        input.put("user", userName);
        return input;
    }

    /**
     * 生成Model层
     * @param table 表
     */
    public void executeModel(DbTable table) {
        Map<String, Object> data = initDataMap(table);
        String saveFileName = table.getClassName() + ".java";
        FreeMarkerUtil.generateFile(data, "model.ftl", PathConstant.MODEL_SAVE_PATH, saveFileName);
    }


    /***
     * 生成服务层
     * @param table 表
     */
    public void executeService(DbTable table) {
        Map<String, Object> data = initDataMap(table);
        String saveFileName = table.getClassName() + "Service.java";
        String savePath = PathConstant.SERVICE_SAVE_PATH + StringUtil.toLowerFirstWord(table.getClassName());
        FreeMarkerUtil.generateFile(data,  "service.ftl", savePath, saveFileName);
    }

    /**
     * 生成服务层实现类
     * @param table 表
     */
    public void executeServiceImpl(DbTable table) {
        Map<String, Object> data = initDataMap(table);
        String saveFileName = table.getClassName() + "ServiceImpl.java";
        String savePath = PathConstant.SERVICE_IMPL_SAVE_PATH + StringUtil.toLowerFirstWord(table.getClassName());
        FreeMarkerUtil.generateFile(data,  "serviceImpl.ftl", savePath, saveFileName);
    }

    /**
     * 生成服务层实现类
     * @param table 表
     */
    public void executeMapper(DbTable table) {
        Map<String, Object> data = initDataMap(table);
        String saveFileName = table.getClassName() + "Mapper.xml";
        String savePath = PathConstant.MAPPER_SAVE_PATH + StringUtil.toLowerFirstWord(table.getClassName());
        FreeMarkerUtil.generateFile(data,  "mapper.ftl", savePath, saveFileName);
    }

    public void executeClazzMapper(DbTable table) {
        Map<String, Object> data = initDataMap(table);
        String saveFileName = table.getClassName() + "Mapper.java";
        String savePath = PathConstant.MAPPER_SAVE_PATH + StringUtil.toLowerFirstWord(table.getClassName());
        FreeMarkerUtil.generateFile(data,  "clazzMapper.ftl", savePath, saveFileName);
    }
}
