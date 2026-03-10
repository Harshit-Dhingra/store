package com.bookStore08.bookStore08.Controller;

import com.bookStore08.bookStore08.Service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class MyBookListController
{

    @Autowired
    private MyBookListService service;
    @RequestMapping("/deleteMyList/{id}")
    public String deleteMyList(@PathVariable("id") Integer id)
    {
        service.deleteById(id);
        return "redirect:/my_books";
    }

}
