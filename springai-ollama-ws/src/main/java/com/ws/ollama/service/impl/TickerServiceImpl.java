package com.ws.ollama.service.impl;

import com.ws.ollama.service.TicketService;
import com.ws.ollama.tools.BookTools;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author yunhua
 * @date 2024-12-14
 * @see
 * @since 1.0.0
 */
@Service
public class TickerServiceImpl implements TicketService {
    @Override
    public boolean cancel(String bookNo, String bookName) {
        if(StringUtils.isBlank(bookNo)||StringUtils.isBlank(bookName)){
            return false ;
        }
        //先写死模拟查数据库
        if("101".equals(bookNo)){
            return true ;
        }else {
            //不存在订单
            return false ;
        }
    }

    @Override
    public BookTools.BookDetail getBookDetail(String bookNo, String bookName) {
        BookTools.BookDetail detail = null ;
        //先写死模拟查数据库
        if("101".equals(bookNo)){
            detail = new BookTools.BookDetail(bookNo,bookName,"2024.12.14",1,"BZ","HZ","经济舱") ;
        }
        return detail;
    }
}

    