package com.ambitious.library.controller;


import com.ambitious.library.entity.Book;
import com.ambitious.library.service.BookService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;


    /**
     * 获取所有的书本信息
     *
     * @return
     */
    @RequestMapping(value = "/listBook", method = RequestMethod.GET)
    private Map<String, Object> listBook() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Book> list = new ArrayList<Book>();
        // 获取区域列表
        list = bookService.getBookList();
        modelMap.put("BookList", list);
        return modelMap;
    }

    /**
     * 通过区域Id获取区域信息
     *
     * @return
     */
    @RequestMapping(value = "/getBookbyid", method = RequestMethod.GET)
    private Map<String, Object> getBookById(Integer BookId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 获取区域信息
        Book Book = bookService.getBookById(BookId);
        modelMap.put("Book", Book);
        return modelMap;
    }

    /**
     * 添加区域信息
     * @return
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    private Map<String, Object> addBook(@RequestBody Book Book)
            throws JsonParseException, JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 添加区域信息
        modelMap.put("success", bookService.addBook(Book));
        return modelMap;
    }

    /**
     * 修改区域信息，主要修改名字
     * @return
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    @RequestMapping(value = "/modifyBook", method = RequestMethod.POST)
    private Map<String, Object> modifyBook(@RequestBody Book Book)
            throws JsonParseException, JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 修改区域信息
        modelMap.put("success", bookService.modifyBook(Book));
        return modelMap;
    }

    @RequestMapping(value = "/removeBook", method = RequestMethod.GET)
    private Map<String, Object> removeBook(Integer BookId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 修改区域信息
        modelMap.put("success", bookService.deleteBook(BookId));
        return modelMap;
    }
}
