package com.example.book.dao;

import com.example.book.pojo.Book;


import java.util.List;

/**
 * @author dzx
 * @data 2021/10/12 -10:47
 */
public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public int addBook(Book book) {
        String sql = "INSERT INTO t_book(`name` , `author` , `price` ,`sales` , `stock` , `img_path`) VALUES(?,?,?,?,?,?)";
        return updata(sql, book.getName(), book.getAuthor(), book.getPrice(),book.getSales(), book.getStock(), book.getImg_path());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id=?";
        return updata(sql, id);
    }

    @Override
    public int upadateBook(Book book) {
        String sql = "update t_book set `name`=?, `author`=? , `price`=? , `sales`=? , `stock`=? , `img_path`=? where id=?";
        return updata(sql, book.getName(), book.getAuthor(), book.getPrice(),book.getSales(), book.getStock(), book.getImg_path(),book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select id,`name` , `author` , `price` , `sales` , `stock` , `img_path` from t_book where id=?";
        return queryForOne(Book.class, sql,id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select id,`name` , `author` , `price` , `sales` , `stock` , `img_path` from t_book ";
        return queryForList(Book.class, sql);
    }

    @Override
    public Integer queryPageTotalCount() {
        String sql = "select count(*) from t_book";
        Number count = (Number) queryForclu(sql);
        return count.intValue();
    }

    @Override
    public List<Book> queryForPageItems(int begin, int pageSize) {
        String sql = "select id,`name` , `author` , `price` , `sales` , `stock` , `img_path` from t_book limit ?,?";
        return queryForList(Book.class, sql, begin, pageSize);
    }

    @Override
    public Integer queryPageTotalCountByprice(int min, int max) {
        String sql = "select count(*) from t_book where price between ? and ?";
        Number count = (Number) queryForclu(sql,min,max);
        return count.intValue();
    }

    @Override
    public List<Book> queryForPageItemsByprice(int begin, int pageSize, int min, int max) {
        String sql = "select id,`name` , `author` , `price` , `sales` , `stock` , `img_path` from t_book where price between ? and ? order by price limit ?,?";
        return queryForList(Book.class, sql, min,max,begin, pageSize);
    }
}
