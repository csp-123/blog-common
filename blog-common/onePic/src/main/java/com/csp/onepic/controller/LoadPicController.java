package com.csp.onepic.controller;


import com.csp.onepic.base.Result;
import com.csp.onepic.schedule.LoadPicSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author baomidou
 * @since 2023-01-17
 */
@RestController
@RequestMapping("/onepic/loadPic")
public class LoadPicController {



    @Autowired
    private LoadPicSchedule loadPicSchedule;

    /**
     * 立即加载
     */
    @GetMapping("/loadNow")
    public Result randomOne() {

        loadPicSchedule.loadPicNow();

        return Result.success();

    }


}
