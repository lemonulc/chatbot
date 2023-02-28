package com.hjp.chatbot.test;

import com.alibaba.fastjson.JSON;
import com.hjp.chatbot.domain.zsxq.IZsxqApi;
import com.hjp.chatbot.domain.zsxq.model.vo.All;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRunTest {
    private Logger logger = LoggerFactory.getLogger(SpringBootRunTest.class);
    @Value("${chatbot.groupId}")
    private String groupId;
    @Value("${chatbot.cookie}")
    private String cookie;
    @Resource
    IZsxqApi zsxqApi;

    @Test
    public void test1() throws IOException {
        All all = zsxqApi.queryAll(groupId, cookie);
        logger.info("测试结果:{}", JSON.toJSONString(all));
    }

    @Test
    public void test2() throws IOException {
        All all = zsxqApi.queryAll(groupId, cookie);
        long topic_id = all.getResp_data().getTopics().get(0).getTopic_id();
        logger.info("topic_id:{}", topic_id);
        boolean b = zsxqApi.answer(groupId, cookie, String.valueOf(topic_id), "不错不错");
        logger.info("测试结果:{}", JSON.toJSONString(all));
    }
}
