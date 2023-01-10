package com.csp.yiyan.service;

import com.csp.yiyan.dto.SentenceDTO;
import com.csp.yiyan.pojo.Sentence;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author baomidou
 * @since 2023-01-10
 */
public interface SentenceService extends IService<Sentence> {

    /**
     * 查询有效语句数量
     * @param type
     * @return
     */
    long countSentence(Integer type);

    /**
     * 随机获取一句语句
     * @param type
     * @return
     */
    Sentence getOneRandomSentence(Integer type);

    /**
     * 通过id查询
     * @param id
     * @return
     */
    Sentence findById(Integer id);

    /**
     * 编辑一句话
     * @param dto
     */
    void editSentence(SentenceDTO dto);

    /**
     * 通过id删除
     * @param id
     */
    void deleteById(Integer id);
}
