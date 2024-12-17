package com.ws.ollama.config;

import org.springframework.ai.autoconfigure.vectorstore.redis.RedisVectorStoreAutoConfiguration;
import org.springframework.ai.autoconfigure.vectorstore.redis.RedisVectorStoreProperties;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisConnectionDetails;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yunhua
 * @date 2024-12-14
 * @see
 * @since 1.0.0
 */
@Configuration
//禁⽤SpringAI提供的RedisStack向量数据库的⾃动配置，会和Redis的配置冲突。
@EnableAutoConfiguration(exclude = {RedisVectorStoreAutoConfiguration.class})
//读取RedisStack的配置信息
@EnableConfigurationProperties({RedisVectorStoreProperties.class})
public class RedisVectorConfig {

    /**
     * 创建RedisStack向量数据库
     * @param embeddingModel 嵌⼊模型
     * @param properties redis-stack的配置信息
     * @return vectorStore 向量数据库
     */
    /*
    @Bean
    public VectorStore vectorStore(EmbeddingModel embeddingModel, RedisVectorStoreProperties properties, RedisConnectionDetails redisConnectionDetails) {

        RedisVectorStore.RedisVectorStoreConfig config = RedisVectorStore.RedisVectorStoreConfig.builder().withIndexName(properties.getIndex()).withPrefix(properties.getPrefix()).build();
        return new RedisVectorStore(config,embeddingModel,
                        new JedisPooled(redisConnectionDetails.getStandalone().getHost(),
                                redisConnectionDetails.getStandalone().getPort(),
                                redisConnectionDetails.getUsername(),
                                redisConnectionDetails.getPassword()),properties.isInitializeSchema());

    }
    */
}

    