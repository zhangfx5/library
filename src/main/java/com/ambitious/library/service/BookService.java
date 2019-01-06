package com.ambitious.library.service;

import com.ambitious.library.entity.Book;

import java.util.List;

public interface BookService {


    /**
     * 获取书本列表
     *
     * @return
     */
    List<Book> getBookList();

    /**
     * 通过区域Id获取书本信息
     *
     * @param BookId
     * @return
     */
    Book getBookById(int BookId);

    /**
     * 增加书本信息
     *
     * @param Book
     * @return
     */
    boolean addBook(Book Book);

    /**
     * 修改书本信息
     *
     * @param book
     * @return
     */
    boolean modifyBook(Book book);

    /**
     * 删除书本信息
     *
     * @param bookId
     * @return
     */
    boolean deleteBook(int bookId);
}
