package com.ws.ollama.service;


import com.ws.ollama.tools.BookTools;

/**
 * @author yunhua
 * @date 2024-12-14
 * @see
 * @since 1.0.0
 */
public interface TicketService {

    boolean cancel(String bookNo,String bookName);

    BookTools.BookDetail getBookDetail(String bookNo,String bookName) ;
}

    