package com.example.book.test;

import com.example.book.service.BookService;
import com.example.book.service.impl.BookServiceImpl;
import org.junit.Test;

/**
 * @author dzx
 * @data 2021/10/12 -11:28
 */
public class BookServiceImplTest {
    BookService bookService = new BookServiceImpl();
    @Test
    public void addBook() {

    }

    @Test
    public void deleteBookById() {
    }

    @Test
    public void upadateBook() {
    }

    @Test
    public void queryBookById() {
    }

    @Test
    public void queryBooks() {
        System.out.println(bookService.page(1,4));
    }

}