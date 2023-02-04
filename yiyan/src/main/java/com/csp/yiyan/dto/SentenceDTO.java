package com.csp.yiyan.dto;

import com.csp.yiyan.enums.CommonStatusEnum;
import com.csp.yiyan.pojo.Sentence;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Title:
 * Description:
 * Project: yiyan
 * Author: csp
 * Create Time:2023/1/10 15:03
 */
@Getter
@Setter
public class SentenceDTO {

    /**
     * id
     */
    private Integer id;

    /**
     * 语句
     */
    private String sentence;

    /**
     * 分类
     */
    private String type;

    /**
     * 来源
     */
    private String source;

    public static Sentence convert(SentenceDTO dto) {
        return new Sentence()
                .setSentence(dto.getSentence())
                .setSource(dto.getSource())
                .setType(dto.getType())
                .setIsDelete(CommonStatusEnum.NO.getCode().byteValue())
                .setCreateTime(new Date())
                .setId(dto.getId());
    }
}
