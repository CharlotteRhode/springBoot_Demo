package com.itheima.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements BookService {

    @Autowired
    private BookDao bookDao;



    @Override
    public IPage<Book> getPage(int current, int size, Book book) {
        LambdaQueryWrapper<Book> wrapper = new LambdaQueryWrapper<>();

        wrapper.like(Strings.isNotEmpty(book.getType()),Book::getType, book.getType() );
        wrapper.like(Strings.isNotEmpty(book.getName()), Book::getName, book.getName());
        wrapper.like(Strings.isNotEmpty(book.getDescription()), Book::getDescription, book.getDescription());

        IPage<Book> page = new Page<>(current, size);
        return bookDao.selectPage(page, wrapper);

    }





}
