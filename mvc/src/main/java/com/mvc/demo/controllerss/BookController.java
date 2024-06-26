package com.mvc.demo.controllerss;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.mvc.demo.models.Book;
import com.mvc.demo.services.BookService;

@Controller

public class BookController{
    private final BookService bookService;
    public BookController(BookService bookService){
        this.bookService = bookService;
    }
    @PostMapping("/api/books")
    public Book create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
        Book book = new Book(title, desc, lang, numOfPages);
        return bookService.createBook(book);
    }
    @PutMapping("/api/books/{id}")
    public Book update(
    		@PathVariable("id") Long id, 
    		@RequestParam(value="title") String title, 
    		@RequestParam(value="description") String desc, 
    		@RequestParam(value="language") String lang,
    		@RequestParam(value="pages") Integer numOfPages) {
        Book book = bookService.updateBook(id, title,desc,lang,numOfPages);
        return book;
    }
    
    @DeleteMapping("/api/books/{id}")
    public void destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }
    @GetMapping(value="/books/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
    	Book b= bookService.findBook(id);
    	model.addAttribute("title",b.getTitle());
    	model.addAttribute("desc",b.getDescription());
    	model.addAttribute("number",b.getNumberOfPages());
    	model.addAttribute("lang",b.getLanguage());
    	return "show.jsp";
    }
    @GetMapping(value="/books")
    public String showBooks(Model model) {
    	List<Book> books= bookService.allBooks();
    	model.addAttribute("books", books);
    	return "index.jsp";
    }
}
