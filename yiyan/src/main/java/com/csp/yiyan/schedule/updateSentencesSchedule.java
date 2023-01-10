package com.csp.yiyan.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Title: 更新语句库
 * Description:
 * Project: yiyan
 * Author: csp
 * Create Time:2023/1/10 15:23
 */
@Component
public class updateSentencesSchedule {

    /**
     * 凌晨两点执行
     */
    @Scheduled(cron = " 0 0 2 1/1 * ? ")
    public void update() {

    }
}
