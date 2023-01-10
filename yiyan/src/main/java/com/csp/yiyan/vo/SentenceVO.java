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


    public static SentenceVO convert(Sentence sentence) {
        SentenceVO vo = new SentenceVO();
        vo.setHitokoto(sentence.getSentence());
        vo.setFrom(sentence.getSource());
        return vo;
    }
}
