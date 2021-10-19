package com.example.book.test;

import com.example.book.dao.BookDao;
import com.example.book.dao.BookDaoImpl;
import com.example.book.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author dzx
 * @data 2021/10/12 -11:07
 */
public class BookDaoTest {
    private BookDao bookDao = new BookDaoImpl();
    @Test
    public void addBook() {
        System.out.println(new Book(null, "test", "T.", new BigDecimal(215), 21, 81, null));
        bookDao.addBook(new Book(null, "test", "T.", new BigDecimal(215), 21, 81, null));
    }


    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(24);
        bookDao.deleteBookById(23);
    }

    @Test
    public void upadateBook() {
        bookDao.upadateBook(new Book(22, "test5", "T.", new BigDecimal(215), 21, 81, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(21));
    }

    @Test
    public void queryBooks() {
        bookDao.queryBooks().forEach(System.out::println);
    }

    @Test
    public void queryPageTotalCount() {
        System.out.println(bookDao.queryPageTotalCount());

    }
    @Test
    public void queryForPageItems() {
        bookDao.queryForPageItems(8,4).forEach(System.out::println);
    }
}