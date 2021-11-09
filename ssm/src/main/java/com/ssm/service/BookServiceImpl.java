package com.ssm.service;

import com.ssm.dao.BookMapper;
import com.ssm.pojo.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dzx
 * @data 2021/11/6 -11:03
 */
//@Service
public class BookServiceImpl implements BookService{
    @Resource
    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    @Override
    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    @Override
    public List<Books> selectBook() {
        return bookMapper.selectBook();
    }

    @Override
    public Books selectBookById(int id) {
        return bookMapper.selectBookById(id);
    }

    @Override
    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    @Override
    public Books queryBook(String bookName) {
        return bookMapper.queryBook(bookName);
    }
}
