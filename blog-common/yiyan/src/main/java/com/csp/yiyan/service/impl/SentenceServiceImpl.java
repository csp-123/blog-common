package com.csp.yiyan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.csp.yiyan.dto.SentenceDTO;
import com.csp.yiyan.mapper.SentenceMapper;
import com.csp.yiyan.pojo.Sentence;
import com.csp.yiyan.service.SentenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author baomidou
 * @since 2023-01-10
 */
@Service
public class SentenceServiceImpl extends ServiceImpl<SentenceMapper, Sentence> implements SentenceService {

    @Autowired
    SentenceMapper sentenceMapper;

    @Override
    public long countSentence(Integer type) {
        LambdaQueryWrapper<Sentence> wrapper = new LambdaQueryWrapper<>();
        // 分类筛选
        if (Objects.nonNull(type)) {
            wrapper.eq(Sentence::getType, type);
        }

        return sentenceMapper.selectCount(wrapper);
    }

    @Override
    public Sentence getOneRandomSentence(Integer type) {
        // 计算随机下标
        long count = countSentence(type);
        double random = Math.random();
        int index = ((Double)Math.floor(random * count)).intValue();

        LambdaQueryWrapper<Sentence> wrapper = new LambdaQueryWrapper<>();

        // 分类筛选
        if (Objects.nonNull(type)) {
            wrapper.eq(Sentence::getType, type);
        }

        wrapper.orderByDesc(Sentence::getId);
        // 随机一条
        wrapper.last(" limit " + index +",1 ");
        return getOne(wrapper);
    }

    @Override
    public Sentence findById(Integer id) {
        LambdaQueryWrapper<Sentence> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Sentence::getId, id);

        Sentence sentence = sentenceMapper.selectOne(wrapper);
        Assert.notNull(sentence, "未查询到指定id的语句：[" + id + "]");
        return sentence;
    }

    @Override
    public void editSentence(SentenceDTO dto) {
        // 校验参数
        validateEditParam(dto);

        // 判断新增或修改
        Sentence convert = SentenceDTO.convert(dto);
        if (dto.getId() == null) {
            save(convert);
        } else {
            findById(dto.getId());
            updateById(convert);
        }
    }

    @Override
    public void deleteById(Integer id) {
        Sentence sentence = findById(id);

        sentenceMapper.deleteById(sentence);
    }

    /**
     * 校验编辑参数
     * @param dto
     */
    private void validateEditParam(SentenceDTO dto) {
        Assert.isTrue(Objects.nonNull(dto.getSentence()) && Objects.nonNull(dto.getType()) && Objects.nonNull(dto.getSource()), "语句、分类、来源均不可为空");
    }
}
