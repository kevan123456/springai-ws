package com.ws.ollama.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.image.ImageModel;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

/**
 * @author yunhua
 * @date 2024-12-10
 * @see
 * @since 1.0.0
 */
@RestController
@RequestMapping("ollama")
public class OllamaChatClientController {

    @Autowired
    private OllamaChatModel ollamaChatModel;
    @Autowired
    private ChatClient chatClient ;


    @GetMapping("/chat")
    public String chat(@RequestParam(value = "message",defaultValue = "给我讲个笑话") String message) {
        Prompt prompt = new Prompt(message,OllamaOptions.builder().withModel("qwen2:0.5b").withTemperature(0.4).build());
        ChatResponse response = ollamaChatModel.call(prompt);
        return response.getResult().getOutput().getContent() ;
    }

    @GetMapping("/talk")
    public String generation(@RequestParam(value = "message",defaultValue = "给我讲个笑话") String message) {
        Prompt prompt = new Prompt(message,OllamaOptions.builder().withModel("qwen2:0.5b").withTemperature(0.4).build());
        return chatClient.prompt(prompt)
                .user(message)
                //预设当前时间
                .system(promptSystemSpec -> promptSystemSpec.param("currentDate", LocalDate.now().toString()))
                .call()
                .content();
    }

}

    