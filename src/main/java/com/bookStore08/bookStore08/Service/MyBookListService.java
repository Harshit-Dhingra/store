package com.bookStore08.bookStore08.Service;


import com.bookStore08.bookStore08.Entity.MyBookList;
import com.bookStore08.bookStore08.Repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookListService
{
    @Autowired
    private MyBookRepository mybook;
    public void saveMyBooks(MyBookList book)
    {
        mybook.save(book);
    }
    public  List<MyBookList> getAllMyBooks()
    {
        return mybook.findAll();
    }
    public void deleteById(Integer id)
    {
        mybook.deleteById(id);
    }

}
