package com.csp.onepic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.csp.onepic.pojo.Picture;
import com.csp.onepic.mapper.PictureMapper;
import com.csp.onepic.service.PictureService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author baomidou
 * @since 2023-01-17
 */
@Service
public class PictureServiceImpl extends ServiceImpl<PictureMapper, Picture> implements PictureService {

    @Override
    public Picture randomOne(Integer type) {

        LambdaQueryWrapper<Picture> countWrapper = new LambdaQueryWrapper<>();
        if (Objects.nonNull(type)) {
            countWrapper.eq(Picture::getType, type);
        }
        // 计算随机下标
        long count = count(countWrapper);
        double random = Math.random();
        int index = ((Double)Math.floor(random * count)).intValue();

        LambdaQueryWrapper<Picture> wrapper = new LambdaQueryWrapper<>();

        // 分类筛选
        if (Objects.nonNull(type)) {
            wrapper.eq(Picture::getType, type);
        }

        wrapper.orderByDesc(Picture::getId);
        // 随机一条
        wrapper.last(" limit " + index +",1 ");
        return getOne(wrapper);


    }
}
