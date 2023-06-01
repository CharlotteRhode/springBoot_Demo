package com.itheima.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.controller.utils.Result;
import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping
    public Result getAll() {
        return new Result(true, bookService.list(), null);
    }

    @GetMapping("{id}")
    public Result getById(@PathVariable Integer id) {
        return new Result(true, bookService.getById(id), null);
    }


    @PostMapping
    public Result save(@RequestBody Book book) {
        boolean flag = bookService.save(book);
        return new Result(flag, flag ? "添加数据成功" : "添加数据失败");

    }

    @PutMapping
    public Result update(@RequestBody Book book) {
        return new Result(bookService.updateById(book));
    }

    @DeleteMapping("{id}")
    public Result deleteById(@PathVariable Integer id) {
        return new Result(bookService.removeById(id));
    }


    @GetMapping("{curr}/{size}")
    public Result getPage(@PathVariable int curr, @PathVariable int size, Book book) {
        //** Book book 这个参数，是为了按条件查询

        IPage<Book> page = bookService.getPage(curr, size, book);

        //当我执行了删除操作以后，如果现在的页面上没有数据了，那么我要直接展示最后一页有数据的页面：
        if (curr > page.getPages()){
            page = bookService.getPage((int) page.getPages(), size, book);
        }

        return new Result(page != null, page, null);
    }


}
