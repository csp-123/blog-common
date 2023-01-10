package com.csp.yiyan.controller.web;

import com.csp.yiyan.enums.SentenceTypeEnum;
import com.csp.yiyan.pojo.Sentence;
import com.csp.yiyan.service.SentenceService;
import com.csp.yiyan.vo.SentenceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * Title:
 * Description:
 * Project: yiyan
 * Author: csp
 * Create Time:2023/1/10 10:57
 */
@RestController
@RequestMapping("/oneSentence/web")
public class OneSentenceFrontController {

    private static final String DEFAULT_SENTENCE = "总有一句话在等你，在当下。";

    @Autowired
    SentenceService sentenceService;

    /**
     * 获取一条语句
     * @param type
     * @return
     */
    @GetMapping("/getOneSentence")
    public SentenceVO getOneSentence(Integer type) {

        if (Objects.nonNull(type)) {
            Assert.notNull(SentenceTypeEnum.find(type), "非法类型");
        }

        Sentence oneRandomSentence = sentenceService.getOneRandomSentence(type);

        if (oneRandomSentence == null) {
            oneRandomSentence = new Sentence();
            oneRandomSentence.setSentence(DEFAULT_SENTENCE);
            oneRandomSentence.setSource("csp");
        }

        return SentenceVO.convert(oneRandomSentence);
    }
}
