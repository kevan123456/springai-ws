package com.ws.ollama.tools;

/**
 * @author yunhua
 * @date 2024-12-14
 * @see
 * @since 1.0.0
 */
public class BookTools {
    public record BookDetail(String bookNumber,String bookName,String date,Integer bookingStatus,String from,String to,String bookingClass){

    }
}

    