package com.itheima.dao;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.*;

@SpringBootTest
public class BookDaoTest {

    @Autowired
    private BookDao bookDao;


    //cha
    @Test
    public void getById(){
        bookDao.selectById(5);
    }

    @Test
    public void getAll(){
        bookDao.selectList(null);
    }

    //zeng
    @Test
    public void save(){
        Book book = new Book();
        book.setName("hailey's book");
        book.setType("computer science");
        book.setDescription("this is a good book.");

        bookDao.insert(book);
    }

    //gai
    @Test
    public void updateById(){
        Book book = new Book();
        book.setId(14);
        book.setName("hailey hillary rhode");

        bookDao.updateById(book);
    }

    //shan
    @Test
    public void deleteById(){
        bookDao.deleteById(-142540799);
    }

    //分页查询 -> 需要添加拦截器：
    @Test
    public void selectByPage(){
        IPage<Book> page = new Page<>(2,5);
        bookDao.selectPage(page,null);

        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }

    //按照各种条件查询 query wrapper:
    @Test
    public void getBy(){
        String name = "spring";
        LambdaQueryWrapper<Book> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(name!=null, Book::getName, name);

        bookDao.selectList(wrapper);
    }






}
