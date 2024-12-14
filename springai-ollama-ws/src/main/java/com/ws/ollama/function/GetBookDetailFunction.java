package com.ws.ollama.function;

import com.ws.ollama.service.TicketService;
import com.ws.ollama.tools.BookTools;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;
import java.util.function.Function;

/**
 * @author yunhua
 * @date 2024-12-14
 * @see
 * @since 1.0.0
 */
public class GetBookDetailFunction implements Function<GetBookDetailFunction.Request, BookTools.BookDetail> {

    @Autowired
    private TicketService ticketService ;

    @Override
    public BookTools.BookDetail apply(Request request) {
        String bookNo = request.bookNo() ;
        String bookName = request.bookName() ;
        BookTools.BookDetail detail = ticketService.getBookDetail(bookNo,bookName) ;
        if(Objects.isNull(detail)){
            return new BookTools.BookDetail(bookNo,bookName,null,null,null,null,null) ;
        }
        return detail ;
    }

    public record Request(String bookNo, String bookName){

    }





}

    