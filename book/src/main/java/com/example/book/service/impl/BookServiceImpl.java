package com.example.book.service.impl;

import com.example.book.dao.BaseDao;
import com.example.book.dao.BookDao;
import com.example.book.dao.BookDaoImpl;
import com.example.book.pojo.Book;
import com.example.book.pojo.Page;
import com.example.book.service.BookService;

import java.util.List;

/**
 * @author dzx
 * @data 2021/10/12 -11:26
 */
public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();
    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void upadateBook(Book book) {
        bookDao.upadateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {

        Integer pageTotalCount=bookDao.queryPageTotalCount();
        //        总页码
        Integer pageTotal=(pageTotalCount+pageSize-1)/pageSize;

        Page<Book> page = new Page<>();
        page.setPageSize(pageSize);
        page.setPageTotalCount(pageTotalCount);
        page.setPageTotal(pageTotal);
        page.setPageNo(pageNo);

        int begin = (page.getPageNo() - 1) * pageSize;
        List<Book> items=bookDao.queryForPageItems(begin,pageSize);
        page.setItems(items);
        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Integer pageTotalCount=bookDao.queryPageTotalCountByprice(min,max);
        //        总页码
        Integer pageTotal=(pageTotalCount+pageSize-1)/pageSize;

        Page<Book> page = new Page<>();
        page.setPageSize(pageSize);
        page.setPageTotalCount(pageTotalCount);
        page.setPageTotal(pageTotal);
        page.setPageNo(pageNo);

        int begin = (page.getPageNo() - 1) * pageSize;
        List<Book> items=bookDao.queryForPageItemsByprice(begin,pageSize,min,max);
        page.setItems(items);
        return page;
    }

}
