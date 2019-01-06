package com.ambitious.library.dao;

import com.ambitious.library.entity.Book;

import java.util.List;

public interface BookDao {


    /**
     * 列出书本列表
     *
     * @return areaList
     */
    List<Book> queryBook();

    /**
     * 根据Id列出具体书信息
     *
     * @return area
     */
    Book queryBookById(int areaId);

    /**
     * 插入书本信息
     *
     * @param book
     * @return
     */
    int insertBook(Book book);

    /**
     * 更新书本信息
     *
     * @param book
     * @return
     */
    int updateBook(Book book);

    /**
     * 删除书本信息
     *
     * @param bookId
     * @return
     */
    int deleteBook(int bookId);
}
