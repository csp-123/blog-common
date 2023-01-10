//package com.csp.mqtest.cunsumer;
//
//import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
//import org.apache.rocketmq.spring.annotation.SelectorType;
//import org.apache.rocketmq.spring.core.RocketMQListener;
//import org.springframework.stereotype.Service;
//
///**
// * Title:  模拟mq消费者
// * Description:
// * Project: pass-center
// * Author: csp
// * Create Time:2022/7/21 21:32
// */
//@Service
//@RocketMQMessageListener(topic = "${rocketmq.consumer.topic}", consumerGroup = "${rocketmq.consumer.group}", selectorType = SelectorType.TAG, selectorExpression = "${rocketmq.consumer.tag.employee}")
//public class EmployeeConsumer implements RocketMQListener<String> {
//
//
//    @Override
//    public void onMessage(String message) {
//        System.out.println(message);
//    }
//
//
//}
