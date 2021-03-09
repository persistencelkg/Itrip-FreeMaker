package cn.itrip.util;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Map;

/**
 * @description: freemarker 生成器
 * @author: 浮~沉
 * @create: 2020-07-15 15:46
 */
public abstract class FreeMarkerUtil {


    /**
     * 1.初始化freemarker配置
     * 2.获取模版
     *
     * @return
     */
    private static Template getTemplate(String templateFileName) {
        Template template = null;
        Configuration configuration = new Configuration(Configuration.getVersion());
        try {
            //设置所有模板文件所在文件夹
            String ftlPath = FreeMarkerUtil.class.getClassLoader().getResource("ftl").getPath();
            configuration.setDirectoryForTemplateLoading(new File(ftlPath));
            configuration.setDefaultEncoding("UTF-8");

            //获取模版
            template = configuration.getTemplate(templateFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return template;
    }


    /**
     * 组装模版 和 数据 生成目标文件
     * @param dataMap 数据
     * @param templateFileName 模版文件名
     * @param savePath 模板生成的文件路径
     */
    public static void generateFile(Map<String, Object> dataMap, String templateFileName, String savePath, String saveFileName) {
        try {
            Template template = getTemplate(templateFileName);
            //保存路径
            File file  = new File(savePath + File.separator);
            if (!file.exists())
                file.mkdirs();
            //输出的文件
            FileOutputStream stream = new FileOutputStream(savePath + File.separator + saveFileName);
            template.process(dataMap, new OutputStreamWriter(stream));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
