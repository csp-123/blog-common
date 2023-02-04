package com.csp.onepic.service;

import com.csp.onepic.pojo.Picture;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author baomidou
 * @since 2023-01-17
 */
public interface PictureService extends IService<Picture> {


    Picture randomOne(Integer type);

}
