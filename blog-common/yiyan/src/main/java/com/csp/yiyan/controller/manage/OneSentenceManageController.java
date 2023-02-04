package com.csp.yiyan.controller.manage;

import com.csp.yiyan.base.Result;
import com.csp.yiyan.dto.SentenceDTO;
import com.csp.yiyan.service.SentenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title:
 * Description:
 * Project: yiyan
 * Author: csp
 * Create Time:2023/1/10 15:01
 */
@RestController
@RequestMapping("/oneSentence/manage")
public class OneSentenceManageController {


    @Autowired
    private SentenceService sentenceService;


    /**
     * 编辑
     * @param dto
     * @return
     */
    @PostMapping("/editSentence")
    public Result editSentence(SentenceDTO dto) {
        sentenceService.editSentence(dto);
        return Result.success();
    }

    @GetMapping("/delete")
    public Result deleteSentence(Integer id) {
        sentenceService.deleteById(id);
        return Result.success();
    }


}
