package com.ssm.dao;

import com.ssm.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author dzx
 * @data 2021/11/6 -10:45
 */
public interface BookMapper {
    int updateBook(Books books);

    int addBook(Books books);

    List<Books> selectBook();

    Books selectBookById(@Param("bookID") int id);

    int deleteBookById(int id);

    Books queryBook(String bookName);
}
