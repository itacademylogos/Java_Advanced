package ua.lviv.lgs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ua.lviv.lgs.models.Book;
import ua.lviv.lgs.repository.BookRepository;

@RestController
public class MainRestController {

	@Autowired
	private BookRepository bookRepository;
	
	
	@GetMapping(value="/findAllBooks")
	public List<Book> findAllBooks() {
		return bookRepository.findAllBooks();
	}	
}
