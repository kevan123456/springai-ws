package com.ws.ollama.config;

import com.ws.ollama.advisors.LoggingAdvisors;
import com.ws.ollama.function.CancelBookFunction;
import com.ws.ollama.function.GetBookDetailFunction;
import com.ws.ollama.tools.BookTools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.PromptChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
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
@ComponentScan(value = "com.ws.ollama.service")
public class OllamaConfig {

    @Bean
    ChatClient chatClient(ChatClient.Builder builder,ChatMemory chatMemory) {
        //角色预设
        return builder
                //设置当前时间
                .defaultSystem(
                            """
                            你是"图灵"航空公司客户端代理，正在通过在线聊天系统与客户互动。
                            在进⾏有关预订或取消预订的信息之前，您必须始终从⽤户处获取以下信息：预订号、客户姓名。
                            在询问⽤户之前，请检查消息历史记录以获取此信息。
                            在更改或退订之前，请先获取预订信息并且⽤户确定信息。
                            请说中文。
                            今天日期是{currentDate}。
                           """
                )
                .defaultAdvisors(
                        //设置对话记忆
                        new PromptChatMemoryAdvisor(chatMemory),
                        //记录对话日志
                        new LoggingAdvisors()
                )
                .defaultFunctions("cancelBook","getBookDetail")
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

    @Bean
    @Description("取消机票预定")
    public Function<CancelBookFunction.Request,CancelBookFunction.Response> cancelBook(){
        return new CancelBookFunction() ;
    }

    @Bean
    @Description("获取机票详细")
    public Function<GetBookDetailFunction.Request, BookTools.BookDetail> getBookDetail(){
        return new GetBookDetailFunction() ;
    }


}

    