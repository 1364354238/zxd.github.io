package com.example.book.service;

import com.example.book.pojo.Book;
import com.example.book.pojo.Page;

import java.util.List;

/**
 * @author dzx
 * @data 2021/10/12 -11:24
 */
public interface BookService {
    void addBook(Book book);

    void deleteBookById(Integer id);

    void upadateBook(Book book);

    Book queryBookById(Integer id);

    List<Book> queryBooks();


    Page<Book> page(int pageNo, int pageSize);


    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
