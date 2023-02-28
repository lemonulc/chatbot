package com.hjp.chatbot.test;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class AppTest {
    @Test
    public void query_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet("https://api.zsxq.com/v2/groups/48884844221528/topics?scope=all&count=20");
        httpGet.addHeader("cookie", "zsxq_access_token=6DDD9026-1061-3631-AAFA-B2264805F243_9971D06B45CC9834; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22818545551881842%22%2C%22first_id%22%3A%22186066f84d6893-0d9b5b17ab28868-26021051-1327104-186066f84d7bc0%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg2MDY2Zjg0ZDY4OTMtMGQ5YjViMTdhYjI4ODY4LTI2MDIxMDUxLTEzMjcxMDQtMTg2MDY2Zjg0ZDdiYzAiLCIkaWRlbnRpdHlfbG9naW5faWQiOiI4MTg1NDU1NTE4ODE4NDIifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22818545551881842%22%7D%2C%22%24device_id%22%3A%22186066f84d6893-0d9b5b17ab28868-26021051-1327104-186066f84d7bc0%22%7D; zsxqsessionid=57305130a3317fb5d67abce06ab3e9ef; abtest_env=product");
        httpGet.addHeader("content-type", "application/json; charset=UTF-8");
        CloseableHttpResponse execute = httpClient.execute(httpGet);
        if (execute.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String s = EntityUtils.toString(execute.getEntity());
            System.out.println(s);
        } else {
            System.out.println(execute.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void commit_question() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        //todo 改topic
        HttpPost httpPost = new HttpPost("https://api.zsxq.com/v2/topics/214822448542551/comments");
        httpPost.addHeader("cookie", "zsxq_access_token=6DDD9026-1061-3631-AAFA-B2264805F243_9971D06B45CC9834; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22818545551881842%22%2C%22first_id%22%3A%22186066f84d6893-0d9b5b17ab28868-26021051-1327104-186066f84d7bc0%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg2MDY2Zjg0ZDY4OTMtMGQ5YjViMTdhYjI4ODY4LTI2MDIxMDUxLTEzMjcxMDQtMTg2MDY2Zjg0ZDdiYzAiLCIkaWRlbnRpdHlfbG9naW5faWQiOiI4MTg1NDU1NTE4ODE4NDIifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22818545551881842%22%7D%2C%22%24device_id%22%3A%22186066f84d6893-0d9b5b17ab28868-26021051-1327104-186066f84d7bc0%22%7D; zsxqsessionid=57305130a3317fb5d67abce06ab3e9ef; abtest_env=product");
        httpPost.addHeader("content-type", "application/json; charset=UTF-8");
        String comment = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"8764876\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"mentioned_user_ids\": []\n" +
                "  }\n" +
                "}";
        StringEntity stringEntity = new StringEntity(comment, ContentType.create("text/json", "UTF-8"));
        httpPost.setEntity(stringEntity);
        CloseableHttpResponse execute = httpClient.execute(httpPost);
        if (execute.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String s = EntityUtils.toString(execute.getEntity());
            System.out.println(s);
        } else {
            System.out.println(execute.getStatusLine().getStatusCode());
        }
    }
}
