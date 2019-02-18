package ua.lviv.lgs.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.lviv.lgs.models.Book;
import ua.lviv.lgs.repository.BookRepository;

@Controller
public class MainController {

	@Autowired
	private BookRepository bookRepository;

	@GetMapping("/")
	public String init(HttpServletRequest req) {
		req.setAttribute("books", bookRepository.findAllBooks());
		req.setAttribute("mode", "BOOK_VIEW");
		return "index";
	}

	@GetMapping("/updateBook")
	public String update(@RequestParam long id, HttpServletRequest req) {
		req.setAttribute("book", bookRepository.findOne(id));
		req.setAttribute("mode", "BOOK_EDIT");
		return "index";
	}


	@PostMapping("/save")
	public String save(@ModelAttribute Book book, HttpServletRequest req) {
		bookRepository.save(book);
		req.setAttribute("books", bookRepository.findAllBooks());
		req.setAttribute("mode", "BOOK_VIEW");
		return "index";
	}

	@GetMapping("/newBook")
	public String newBook(HttpServletRequest req) {
		req.setAttribute("mode", "BOOK_CREATE");
		return "index";
	}
	
	@GetMapping("/delete")
	public String deleteBook(@RequestParam long id, HttpServletRequest req) {
		bookRepository.deleteBook(id);
		req.setAttribute("books", bookRepository.findAllBooks());
		req.setAttribute("mode", "BOOK_VIEW");
		return "index";
	}
}
