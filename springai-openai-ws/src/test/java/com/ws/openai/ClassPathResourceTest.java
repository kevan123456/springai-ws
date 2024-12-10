package com.ws.openai;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

/**
 * @author yunhua
 * @date 2024-12-10
 * @see
 * @since 1.0.0
 */
public class ClassPathResourceTest extends TestCase {

    @Test
    public void test() throws Exception{
        ClassPathResource classPathResource = new ClassPathResource("") ;
        String path = classPathResource.getFile().getPath() ;
        System.out.println(path);
    }
}

    