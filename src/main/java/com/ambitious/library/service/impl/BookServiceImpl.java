package com.ambitious.library.service.impl;

import com.ambitious.library.dao.BookDao;
import com.ambitious.library.entity.Book;
import com.ambitious.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;


@Service
public class BookServiceImpl implements BookService {


    @Autowired
    private BookDao bookDao;


    @Override
    public List<Book> getBookList() {
        // 返回所有的书本信息
        return bookDao.queryBook();
    }

    @Override
    public Book getBookById(int bookId) {
        return bookDao.queryBookById(bookId);
    }

    @Transactional
    @Override
    public boolean addBook(Book book) {
        // 空值判断，主要是判断areaName不为空

        if (!StringUtils.isEmpty(book.getBookName())) {
            // 设置默认值
            book.setCreateTime(new Date());
            book.setModifyTime(new Date());
            try {
                int effectedNum = bookDao.insertBook(book);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("添加书本信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("添加书本信息失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("书本信息不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean modifyBook(Book book) {
        // 空值判断，主要是areaId不为空
        if (book.getBookId() != null && book.getBookId() > 0) {
            // 设置默认值
            book.setModifyTime(new Date());
            try {
                // 更新区域信息
                int effectedNum = bookDao.updateBook(book);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新书本信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新书本信息失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("书本信息不能为空！");
        }
    }

    @Override
    public boolean deleteBook(int bookId) {
        if (bookId > 0) {
            try {
                // 删除区域信息
                int effectedNum = bookDao.deleteBook(bookId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除书本信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除书本信息失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("书本Id不能为空！");
        }
    }
}
