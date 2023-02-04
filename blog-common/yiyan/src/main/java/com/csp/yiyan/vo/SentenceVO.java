package com.csp.yiyan.vo;

import com.csp.yiyan.pojo.Sentence;
import lombok.Getter;
import lombok.Setter;

/**
 * Title:
 * Description:
 * Project: yiyan
 * Author: csp
 * Create Time:2023/1/10 11:50
 */
@Getter
@Setter
public class SentenceVO {


    /**
     * 一言
     */
    private String hitokoto;

    /**
     * 来源
     */
    private String from;

    /**
     * 分类
     */
    private String type;


    /**
     * 长度
     */
    private Integer length;




    public static SentenceVO convert(Sentence sentence) {
        SentenceVO vo = new SentenceVO();
        vo.setHitokoto(sentence.getSentence());
        vo.setFrom(sentence.getSource());
        vo.setType(sentence.getType());
        vo.setLength(sentence.getSentence().length());
        return vo;
    }
}
