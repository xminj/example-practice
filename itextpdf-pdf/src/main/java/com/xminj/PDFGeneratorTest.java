package com.xminj;

import cn.hutool.core.bean.BeanUtil;
import com.xminj.entity.CommunityCorrectionFieldVisitRegistrationForm;
import com.xminj.util.FreemarkerTemplateUtil;
import com.xminj.util.ItextpdfUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * https://printcss.live/ ：在线预览pdf打印效果
 */
public class PDFGeneratorTest {
    public static void main(String[] args) {
        ClassLoader classLoader = PDFGeneratorTest.class.getClassLoader();
        String path = Objects.requireNonNull(classLoader.getResource("templates/")).getPath();
        String fontPath = Objects.requireNonNull(classLoader.getResource("templates/fonts/SimSun.ttf")).getPath();
        String htmlContent = FreemarkerTemplateUtil.loadTemplate(path, "visit.html.ftl", getData());
        // System.out.println(htmlContent);
        ItextpdfUtil.convertToPdf(htmlContent, fontPath, "test_2.pdf");
    }

    private static Map<String, Object> getData() {
        List<String> visitReasonList = getStrings();

        String correctorSignatureUrl = "http://local-file.aipsybot.com/image/bot/icon/202408/20240801195452544497691.png";

        String url = "<img style='width:60px; height:40px;' src='"+correctorSignatureUrl+" '/>";
        CommunityCorrectionFieldVisitRegistrationForm form = CommunityCorrectionFieldVisitRegistrationForm
                .builder()
                .correctiveInstitution("lastPart")
                .visitObjectName("getRealName")
                .visitObjectSex("getGender")
                .correctiveType("getExtendStringH")
                .visitTime("getInterviewTime")
                .visitPlace("getInterviewAddress")
                .staffMember("getOperatorName")
                .visitReason("getInterviewReason")
                .visitReasonList(visitReasonList)
                .visitObjectSignature(url)
                .staffMemberSignature(url)
                .attach_1("")
                .attach_2("")
                .build();


        return BeanUtil.beanToMap(form);
    }

    /**
     * 图片位置需要调整好，不然排版会乱
     */
    private static List<String> getStrings() {
        List<String> visitReasonList = new ArrayList<>();
        visitReasonList.add("问: getItemName");
        visitReasonList.add("答：dgsrhrthrhrtjtjtjtjtjtj");

        String imgUrl = "http://local-file.aipsybot.com/image/bot/icon/202408/20240801192946647514570.png";

        String url = "<img style='width:250px; height:250px;' src='"+imgUrl+" '/>";
        visitReasonList.add(url);
        visitReasonList.add(url);
        visitReasonList.add(url);
        visitReasonList.add(url);
        visitReasonList.add(url);
        visitReasonList.add(url);
        visitReasonList.add(url);
        visitReasonList.add(url);
        visitReasonList.add(url);
        visitReasonList.add(url);
        return visitReasonList;
    }

}
