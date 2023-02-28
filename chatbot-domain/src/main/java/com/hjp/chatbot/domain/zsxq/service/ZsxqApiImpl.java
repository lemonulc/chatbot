package com.hjp.chatbot.domain.zsxq.service;

import com.alibaba.fastjson.JSON;
import com.hjp.chatbot.domain.zsxq.IZsxqApi;
import com.hjp.chatbot.domain.zsxq.model.vo.All;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.rmi.RemoteException;

@Service
public class ZsxqApiImpl implements IZsxqApi {

    private Logger logger = LoggerFactory.getLogger(ZsxqApiImpl.class);

    @Override
    public All queryAll(String groupId, String cookie) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet("https://api.zsxq.com/v2/groups/"+groupId+"/topics?scope=all&count=20");
        httpGet.addHeader("cookie",cookie);
        httpGet.addHeader("content-type", "application/json; charset=UTF-8");
        CloseableHttpResponse execute = httpClient.execute(httpGet);
        if (execute.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String s = EntityUtils.toString(execute.getEntity());
            logger.info("拉取的问题：{}",s);
            return JSON.parseObject(s,All.class);
        } else {
            throw new RemoteException("queryAll error：" + execute.getStatusLine().getStatusCode());
        }
    }

    @Override
    public boolean answer(String groupId, String cookie, String topicId, String text) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost("https://api.zsxq.com/v2/topics/"+topicId+"/comments");
        httpPost.addHeader("cookie", cookie);
        httpPost.addHeader("content-type", "application/json; charset=UTF-8");
        String comment = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \""+text+"\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"mentioned_user_ids\": []\n" +
                "  }\n" +
                "}";
        StringEntity stringEntity = new StringEntity(comment, ContentType.create("text/json", "UTF-8"));
        httpPost.setEntity(stringEntity);
        CloseableHttpResponse execute = httpClient.execute(httpPost);
        if (execute.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String s = EntityUtils.toString(execute.getEntity());
            logger.info("回答的问题：{}",s);
            System.out.println(s);
            return true;
        } else {
            throw new RemoteException("answer error：" + execute.getStatusLine().getStatusCode());
        }
    }
}
