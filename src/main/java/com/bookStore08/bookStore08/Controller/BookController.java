package com.bookStore08.bookStore08.Controller;


import com.bookStore08.bookStore08.Entity.Book;
import com.bookStore08.bookStore08.Entity.MyBookList;
import com.bookStore08.bookStore08.Service.BookService;
import com.bookStore08.bookStore08.Service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class BookController
{
    @Autowired
    private BookService service;
    @Autowired
    private MyBookListService myBookService;
    @GetMapping("/")
    public String home()
    {
        System.out.println("home 2");
        return "home";
    }
    @GetMapping("/book_register")
    public String book_register()
    {
        return "book_register";
    }
    @GetMapping("/available_books")
    public ModelAndView getAllBook()
    {
        List<Book> list=service.getAllBooks();
        return new ModelAndView("bookList","bookList",list);

    }
  @PostMapping("/save")
  public String addBook(@ModelAttribute Book b)
  {
      service.save(b);
      return "redirect:/available_books";
  }
@GetMapping("/my_books")
    public String getMyBooks(Model model)
{
    List<MyBookList>list=myBookService.getAllMyBooks();
            model.addAttribute("book",list);
    return "my_Books";
}
@RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable Integer id)
{
    Book b=service.getBookById(id);
    MyBookList mb=new MyBookList(b.getName(),b.getAuthor(),b.getPrice());
    myBookService.saveMyBooks(mb);
    return "redirect:/my_books";
}
@RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable int id, Model model)
{
    Book b=service.getBookById(id);
    model.addAttribute("book",b);
    return "bookEdit";
}
@RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id)
{
    service.deleteBookById(id);
    return "redirect:/available_books";
}

}
