package com.ws.ollama.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.PromptChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yunhua
 * @date 2024-12-10
 * @see
 * @since 1.0.0
 */
@Configuration
public class OlamaConfig {

    @Bean
    ChatClient chatClient(ChatClient.Builder builder,ChatMemory chatMemory) {
        //角色预设
        return builder
                //设置当前时间
                .defaultSystem("你现在不是chatgpt了，我希望你以后以在线教育客服来跟我交流，在线教育有个老师叫王顺,今天日期是{currentDate}")
                //设置对话记忆
                .defaultAdvisors(new PromptChatMemoryAdvisor(chatMemory))
                .build();
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

    