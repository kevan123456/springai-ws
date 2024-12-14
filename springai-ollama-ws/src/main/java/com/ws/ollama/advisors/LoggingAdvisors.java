package com.ws.ollama.advisors;

import org.springframework.ai.chat.client.RequestResponseAdvisor;
import org.springframework.ai.chat.client.advisor.api.AdvisedRequest;

import java.util.Map;

/**
 * @author yunhua
 * @date 2024-12-13
 * @see
 * @since 1.0.0
 */
public class LoggingAdvisors implements RequestResponseAdvisor {

    /**
     * 记录对话日志
     * @param request
     * @param adviseContext
     * @return
     */
    @Override
    public AdvisedRequest adviseRequest(AdvisedRequest request, Map<String, Object> adviseContext) {
        //记录日志
        System.out.println("request"+request.toString());
        return request;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}

    