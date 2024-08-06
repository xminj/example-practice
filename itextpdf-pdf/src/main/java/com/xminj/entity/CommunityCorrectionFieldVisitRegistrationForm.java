package com.xminj.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 社区矫正实地查访情况登记表
 * Created by xminj on 2017/7/6.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommunityCorrectionFieldVisitRegistrationForm {
    /**
     * 矫正机构
     */
    private String correctiveInstitution;

    /**
     * 查访对象姓名
     */
    private String visitObjectName;

    /**
     * 性别
     */
    private String visitObjectSex;

    /**
     * 矫正类别
     */
    private String correctiveType;

    /**
     * 查访时间
     */
    private String visitTime;

    /**
     * 查访场所
     */
    private String visitPlace;

    /**
     * 工作人员
     */
    private String staffMember;

    /**
     * 走访事由
     */
    private String visitReason;

    /**
     * 图片内容
     */
    private List<String> visitReasonList;

    /**
     * 查访对象签字
     */
    private String visitObjectSignature;

    /**
     * 工作人员签字
     */
    private String staffMemberSignature;

    /**
     * 附加字段1
     */
    private String attach_1;

    /**
     * 附加字段2
     */
    private String attach_2;
}
