package com.ws.ollama.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yunhua
 * @date 2024-12-10
 * @see
 * @since 1.0.0
 */
@RestController
@RequestMapping("ollama")
public class ChatClientController {

    @Autowired
    private ChatClient chatClient;

    @GetMapping("/chat")
    public String generation(@RequestParam(value = "message",defaultValue = "给我讲个笑话") String message) {
        //prompt提示词
        return this.chatClient.prompt()
                //用户信息
                .user(message)
                //远程请求大模型
                .call()
                //返回文本
                .content();
    }
}

    