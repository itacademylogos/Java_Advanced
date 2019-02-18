package ua.lviv.lgs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.lviv.lgs.domain.Book;
import ua.lviv.lgs.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/")
	public String init(HttpServletRequest req) {
		req.setAttribute("books", bookService.findAllBooks());
		req.setAttribute("mode", "BOOK_VIEW");
		return "index";
	}

	@GetMapping("/new")
	public String newBook(HttpServletRequest req) {
		req.setAttribute("mode", "BOOK_CREATE");
		return "index";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute Book book, HttpServletRequest req) {
		bookService.save(book);
		req.setAttribute("books", bookService.findAllBooks());
		req.setAttribute("mode", "BOOK_VIEW");
		return "index";
	}

	@GetMapping("/update")
	public String update(@RequestParam int id, HttpServletRequest req) {
		req.setAttribute("book", bookService.findOne(id));
		req.setAttribute("mode", "BOOK_EDIT");
		return "index";
	}

	@GetMapping("/delete")
	public String deleteBook(@RequestParam int id, HttpServletRequest req) {
		bookService.delete(id);
		req.setAttribute("books", bookService.findAllBooks());
		req.setAttribute("mode", "BOOK_VIEW");
		return "index";
	}
}
