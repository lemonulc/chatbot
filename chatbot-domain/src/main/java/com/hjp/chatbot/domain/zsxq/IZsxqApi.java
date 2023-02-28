package com.hjp.chatbot.domain.zsxq;

import com.hjp.chatbot.domain.zsxq.model.vo.All;

import java.io.IOException;

public interface IZsxqApi {
    All queryAll(String groupId, String cookie) throws IOException;
    boolean answer(String groupId, String cookie, String topicId, String text) throws IOException;
}
