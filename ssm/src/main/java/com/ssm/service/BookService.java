package com.ssm.service;

import com.ssm.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author dzx
 * @data 2021/11/6 -11:02
 */
public interface BookService {
    int updateBook(Books books);

    int addBook(Books books);

    List<Books> selectBook();

    Books selectBookById(int id);

    int deleteBookById(int id);
    Books queryBook(String bookName);

}
