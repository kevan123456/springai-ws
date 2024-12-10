package com.ws.openai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringaiOpenaiWsApplication {

    public static void main(String[] args) {
        //如果直接访问openAI，需要选择代理
        /*
        String proxyHost = "127.0.0.1";
        int port = 7890 ;
        System.setProperty("proxyType","4");
        System.setProperty("proxyPort",String.valueOf(port));
        System.setProperty("proxyHost",proxyHost);
        System.setProperty("proxySet","true");
        */
        SpringApplication.run(SpringaiOpenaiWsApplication.class, args);
    }

}
