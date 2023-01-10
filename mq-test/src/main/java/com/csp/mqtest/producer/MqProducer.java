package com.csp.mqtest.producer;

import com.alibaba.fastjson.JSON;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Title:
 * Description:
 * Project: pass-center
 * Author: csp
 * Create Time:2022/7/23 12:52
 */
@Component
public class MqProducer {


    @Value("${rocketmq.producer.group}")
    private String producerGroup;

    @Resource
    DefaultMQProducer producer;

    @Scheduled(cron = "0 0/1 * * * ? ")
    public void testAdd() throws Exception {

        Map<String, Object> mq = new HashMap<>();
        Map<String, Object> after = new HashMap<>();
        after.put("employeeName", "mq新增2");
        after.put("employeeId", String.valueOf(System.currentTimeMillis()));
        after.put("mobileNo", "13501899279");
        after.put("genderCode", "2");
        after.put("empStatusCode", "1");
        after.put("empStatusName", "在岗");
        after.put("buName", "aaa");
        after.put("buCode", "codeaaa");
        after.put("ptName", "platformaaa");
        after.put("ptCode", "platformCodeaaa");
        after.put("orgManagerId", "123131");
        after.put("orgManagerName", "manager");

        mq.put("after", after);
        Map<String, Object> before = new HashMap<>();
        List<Map<String, Object>> columns = new ArrayList<>();
        mq.put("before", before);
        mq.put("columns", columns);
        mq.put("eventType", "insert");
        mq.put("executeTime", 1658714383000L);
        List<Map<String, Object>> keys = new ArrayList<>();
        mq.put("keys", keys);
        List<Map<String, Object>> oldKeys = new ArrayList<>();
        mq.put("oldKeys", oldKeys);
        mq.put("pairId", "-1");
        mq.put("primaryKey", "1");
        mq.put("remedy", false);
        mq.put("schemaName", "databaseName");
        mq.put("size", 65);
        mq.put("tableId", 635);
        mq.put("tableName", "tableName");
        mq.put("testAA", "aa");
        mq.put("testBB", "aa");
        mq.put("testCC", "aa");

        List<Map<String, Object>> updateColumns = new ArrayList<>();
        mq.put("updateColumns", updateColumns);
        List<Map<String, Object>> updateKeys = new ArrayList<>();
        mq.put("updateKeys", updateKeys);
        mq.put("withoutSchema", false);


        Message message = new Message("pass-center", "employee", JSON.toJSONBytes(mq));
        Message message1 = new Message("pass-center", "supplier", JSON.toJSONBytes(mq));
        Message message2 = new Message("pass-center", "visitor", JSON.toJSONBytes(mq));
        producer.setProducerGroup(producerGroup);
        SendResult send = producer.send(message);
        producer.send(message1);
        producer.send(message2);
        String result = "";
        result = SendStatus.SEND_OK.equals(send.getSendStatus()) ? "发送成功" : "发送失败";
        System.out.println(result);
    }



    //@Scheduled(cron = "0 0/1 * * * ? ")
    public void testUpdate() throws Exception {

        //Map<String, Object> mq = new HashMap<>();
        //Map<String, Object> after = new HashMap<>();
        //after.put("staffName", "mq更新");
        //after.put("staffId", "1235109");
        //after.put("phone", "13501899279");
        //after.put("gender", "2");
        //after.put("statusCode", "1");
        //after.put("statusName", "在岗");
        //after.put("field", "newaaa");
        //after.put("fieldCode", "newcodeaaa");
        //after.put("platform", "platformaaa");
        //after.put("platformCode", "platformCodeaaa");
        //after.put("managerStaffId", "123131");
        //after.put("managerStaffName", "manager");
        //
        //mq.put("after", after);
        //Map<String, Object> before = new HashMap<>();
        //List<Map<String, Object>> columns = new ArrayList<>();
        //mq.put("before", before);
        //mq.put("columns", columns);
        //mq.put("eventType", "update");
        //mq.put("executeTime", 1658714385000L);
        //List<Map<String, Object>> keys = new ArrayList<>();
        //mq.put("keys", keys);
        //List<Map<String, Object>> oldKeys = new ArrayList<>();
        //mq.put("oldKeys", oldKeys);
        //mq.put("pairId", "-1");
        //mq.put("primaryKey", "1");
        //mq.put("remedy", false);
        //mq.put("schemaName", "databaseName");
        //mq.put("size", 65);
        //mq.put("tableId", 635);
        //mq.put("tableName", "tableName");
        //mq.put("testAA", "aa");
        //mq.put("testBB", "aa");
        //mq.put("testCC", "aa");
        //
        //List<Map<String, Object>> updateColumns = new ArrayList<>();
        //mq.put("updateColumns", updateColumns);
        //List<Map<String, Object>> updateKeys = new ArrayList<>();
        //mq.put("updateKeys", updateKeys);
        //mq.put("withoutSchema", false);
        //
        //
        //Message message = new Message("testMq", "employee", JSON.toJSONBytes(mq));
        //producer.setProducerGroup(producerGroup);
        //SendResult send = producer.send(message);
        //String result = "";
        //result = SendStatus.SEND_OK.equals(send.getSendStatus()) ? "发送成功" : "发送失败";
        //System.out.println(result);
    }


    //@Scheduled(cron = "0 0/1 * * * ? ")
    public void testDelete() throws Exception {

        //Map<String, Object> mq = new HashMap<>();
        //Map<String, Object> after = new HashMap<>();
        //
        //mq.put("after", after);
        //Map<String, Object> before = new HashMap<>();
        //before.put("staffName", "mq更新");
        //before.put("staffId", "1235109");
        //before.put("phone", "13501899279");
        //before.put("gender", "2");
        //before.put("statusCode", "1");
        //before.put("statusName", "在岗");
        //before.put("field", "newaaa");
        //before.put("fieldCode", "newcodeaaa");
        //before.put("platform", "platformaaa");
        //before.put("platformCode", "platformCodeaaa");
        //before.put("managerStaffId", "123131");
        //before.put("managerStaffName", "manager");
        //List<Map<String, Object>> columns = new ArrayList<>();
        //mq.put("before", before);
        //mq.put("columns", columns);
        //mq.put("eventType", "delete");
        //mq.put("executeTime", 1658714385000L);
        //List<Map<String, Object>> keys = new ArrayList<>();
        //mq.put("keys", keys);
        //List<Map<String, Object>> oldKeys = new ArrayList<>();
        //mq.put("oldKeys", oldKeys);
        //mq.put("pairId", "-1");
        //mq.put("primaryKey", "1");
        //mq.put("remedy", false);
        //mq.put("schemaName", "databaseName");
        //mq.put("size", 65);
        //mq.put("tableId", 635);
        //mq.put("tableName", "tableName");
        //mq.put("testAA", "aa");
        //mq.put("testBB", "aa");
        //mq.put("testCC", "aa");
        //
        //List<Map<String, Object>> updateColumns = new ArrayList<>();
        //mq.put("updateColumns", updateColumns);
        //List<Map<String, Object>> updateKeys = new ArrayList<>();
        //mq.put("updateKeys", updateKeys);
        //mq.put("withoutSchema", false);
        //
        //
        //Message message = new Message("testMq", "employee", JSON.toJSONBytes(mq));
        //producer.setProducerGroup(producerGroup);
        //SendResult send = producer.send(message);
        //String result = "";
        //result = SendStatus.SEND_OK.equals(send.getSendStatus()) ? "发送成功" : "发送失败";
        //System.out.println(result);
    }
}
