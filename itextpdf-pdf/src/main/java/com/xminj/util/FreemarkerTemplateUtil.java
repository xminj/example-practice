package com.xminj.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

public class FreemarkerTemplateUtil {
    private FreemarkerTemplateUtil() {
    }

    private final static Configuration configuration;

    static {
        configuration = new Configuration(Configuration.VERSION_2_3_31);
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    }

    /**
     * 解析模版
     *
     * @param templatePath     模版路径
     * @param templateFileName 模版名称
     * @return 模版内容
     */
    public static String loadTemplate(String templatePath, String templateFileName, Map<String, Object> data) {
        try {
            configuration.setDirectoryForTemplateLoading(new File(templatePath));
            Template template = configuration.getTemplate(templateFileName);
            StringWriter stringWriter = new StringWriter();
            template.process(data, stringWriter);
            return stringWriter.toString();
        } catch (IOException | TemplateException e) {
            throw new RuntimeException("解析模版出错：" + e.getMessage());
        }
    }
}
