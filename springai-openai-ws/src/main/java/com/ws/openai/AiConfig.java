package com.ws.openai;

import com.ws.openai.functions.LocationNameFunction;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.PromptChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import java.util.function.Function;

/**
 * @author yunhua
 * @date 2024-12-10
 * @see
 * @since 1.0.0
 */
@Configuration
public class AiConfig {
    @Bean
    ChatClient chatClient(ChatClient.Builder builder,ChatMemory chatMemory) {
        //角色预设
        return builder
                .defaultSystem("你现在不是chatgpt了，我希望你以后以在线教育客服来跟我交流，在线教育有个老师叫王顺，今天日期是{currentDate}")
                //设置对话记忆
                .defaultAdvisors(new PromptChatMemoryAdvisor(chatMemory))
                .build();
    }


    @Bean
    @Description("某个地方有多少个叫什么名字的人")
    public Function<LocationNameFunction.Request,LocationNameFunction.Response> locationNameFunction(){
        return new LocationNameFunction() ;
    }

    /**
     * 对话记忆
     * @return
     */
    @Bean
    public ChatMemory chatMemory(){
        return new InMemoryChatMemory() ;
    }
}

    