package com.xminj;

import com.xminj.util.FreemarkerTemplateUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PDFGeneratorTest {

    // /Users/xminj/Documents/work/j_project/example-practice/itextpdf-pdf/src/main/resources/templates/example.ftl
    public static void main(String[] args) {
        ClassLoader classLoader = PDFGeneratorTest.class.getClassLoader();
        String path = Objects.requireNonNull(classLoader.getResource("templates/")).getPath();
        String htmlContent = FreemarkerTemplateUtil.loadTemplate(path, "example.html.ftl", getData());
        System.out.println(htmlContent);
    }

    private static Map<String, Object> getData(){
        Map<String,Object> data = new HashMap<>();
        data.put("correctiveInstitution", "xminj");
        data.put("name", "xminj");
        data.put("sex", "nan");
        data.put("correctiveType", "xminj");
        data.put("correctiveObjectName", "xminj");
        data.put("correctiveTime_1", "xminj");
        data.put("correctivePlace", "xminj");
        data.put("correctiveWorker", "xminj");
        data.put("correctiveReason", "xminj");
        data.put("correctiveRecord", "xminj");
        data.put("correctiveObjectSignature", "xminj");
        data.put("correctiveWorkerSignature", "xminj");
        data.put("correctiveTime", "correctiveTime");
        return data;
    }
}
