package com.ssm.controller;

import com.ssm.pojo.Books;
import com.ssm.service.BookService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dzx
 * @data 2021/11/6 -14:59
 */
@Controller
@RequestMapping("/book")
public class BookController {
    @Resource
    private BookService bookService;
//    查询全部书籍
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> books = bookService.selectBook();
        model.addAttribute("booksList", books);
        return "allBook";
    }
    //        跳转增加书籍
    @RequestMapping("/toAddBook")
    public String toAddBook(Model model){
        return "addBook";
    }
//添加书籍请求
    @RequestMapping("/addBook")
    public String addBook(Books books){
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }
//    跳转修改书籍
    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(int id,Model model){
        Books books = bookService.selectBookById(id);
        model.addAttribute("Books", books);
        return "updateBook";
    }
    //    修改书籍
    @RequestMapping("/updateBook")
    public String toUpdateBook(Books books){
        System.out.println("update---"+books);
        bookService.updateBook(books);
        return "redirect:/book/allBook";
    }
    //    跳转修改书籍
    @RequestMapping("/deleteBook")
    public String deleteBook(int id){
        System.out.println("deleteId"+id);
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }
//    查询书籍
    @RequestMapping("/queryBook")
    public String queryBook(String bookName,Model model){
        Books books=bookService.queryBook(bookName);
        System.out.println(books);
        List<Books> booksList = new ArrayList<>();
        booksList.add(books);
        model.addAttribute("booksList", booksList);
        return "allBook";
    }
}
