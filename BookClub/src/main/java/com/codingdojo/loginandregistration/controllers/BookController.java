package com.codingdojo.loginandregistration.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.loginandregistration.models.Book;
import com.codingdojo.loginandregistration.models.User;
import com.codingdojo.loginandregistration.services.BookService;
import com.codingdojo.loginandregistration.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	@Autowired
	private UserService userServ;

	@GetMapping("/books")
	public String allBooks(HttpSession session, Model model) {
		List<Book> books = bookService.findAllBooks();

		if (session.getAttribute("userid") == null) {
			return "redirect:/";
		}
		model.addAttribute("books", books);
		return "welcome.jsp";
	}

	@GetMapping("/books/new")
	public String createBooks(@ModelAttribute("book") Book book, HttpSession session) {

		if (session.getAttribute("userid") == null) {
			return "redirect:/";
		}
		return "create.jsp";
	}

	@PostMapping("/createbook")
	public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session) {

		if (result.hasErrors()) {
			return "create.jsp";
		}
		User user = userServ.findByID((Long) session.getAttribute("userid"));
		book.setUser(user);
		bookService.create(book);
		return "redirect:/books";
	}

	@GetMapping("/books/{id}")
	public String showBook(@ModelAttribute("book") Book book, @PathVariable Long id, Model model, HttpSession session) {
		Book showBook = bookService.findBookById(id);
		model.addAttribute("book", showBook);

		if (showBook.getUser().getId() == session.getAttribute("userid")) {
			boolean flag = true;
			model.addAttribute("flag", flag);
		} else {
			boolean flag = false;
			model.addAttribute("flag", flag);
		}
		return "book.jsp";
	}

	@DeleteMapping(value = "/books/{bookid}")
	public String destroy(@PathVariable("bookid") Long bookId) {
		Book book = bookService.findBookById(bookId);
		bookService.deleteBook(book);
		return "redirect:/books";
	}

	@GetMapping("/books/{bookid}/edit")
	public String editBook(@PathVariable("bookid") Long bookId, Model model) {
		Book book = bookService.findBookById(bookId);
		model.addAttribute("book", book);
		return "edit.jsp";
	}

	@RequestMapping(value="/editBook/{bookid}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model,
			HttpSession session) {
		if (result.hasErrors()) {
			model.addAttribute("book", book);
			return "edit.jsp";
		} else {
			User user = userServ.findByID((Long) session.getAttribute("userid"));
			book.setUser(user);
			bookService.updateBook(book);
			return "redirect:/books";
		}

	}
}
