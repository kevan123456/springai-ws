package com.ws.ollama.function;

import com.ws.ollama.service.TicketService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Function;

/**
 * @author yunhua
 * @date 2024-12-14
 * @see
 * @since 1.0.0
 */
public class CancelBookFunction implements Function<CancelBookFunction.Request,CancelBookFunction.Response> {

    @Autowired
    private TicketService ticketService ;

    @Override
    public Response apply(Request request) {
        String bookNo = request.bookNo() ;
        String bookName = request.bookName() ;
        if(StringUtils.isBlank(bookNo)||StringUtils.isBlank(bookName)){
            return null ;
        }
        boolean flag = ticketService.cancel(bookNo,bookName) ;
        if(flag){
            return new Response("取消成功");
        }else {
            return new Response(null);
        }

    }

    public record Request(String bookNo, String bookName){

    }

    public record Response(String message){

    }




}

    