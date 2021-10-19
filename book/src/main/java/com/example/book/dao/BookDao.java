package com.example.book.dao;

import com.example.book.pojo.Book;

import java.util.List;

/**
 * @author dzx
 * @data 2021/10/12 -10:44
 */
public interface BookDao {
    int addBook(Book book);

    int deleteBookById(Integer id);

    int upadateBook(Book book);

    Book queryBookById(Integer id);

    List<Book> queryBooks();

    Integer queryPageTotalCount();

    List<Book> queryForPageItems(int i, int pageSize);


    Integer queryPageTotalCountByprice(int min, int max);

    List<Book> queryForPageItemsByprice(int begin, int pageSize, int min, int max);
}
