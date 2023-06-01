package com.itheima.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    public void getById(){
        System.out.println(bookService.getById(11));
    }

    @Test
    public void save(){
        Book book = new Book();
        book.setId(2);
        book.setName("带你下厨房");
        book.setType("生活");
        book.setDescription("手把手带你做100道菜");

        bookService.save(book);
    }


    @Test
    public void delete(){
        bookService.removeById(16);
    }

    @Test
    public void getAll(){
        bookService.list();
    }



    @Test
    public void getPage(){
        IPage<Book> page = new Page<>(2,3);
        bookService.page(page);
    }








}
