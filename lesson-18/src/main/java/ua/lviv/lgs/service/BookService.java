package ua.lviv.lgs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.BookRepo;
import ua.lviv.lgs.domain.Book;

@Service
public class BookService {
	
	@Autowired
	private BookRepo bookRepo;
	
	public List<Book> findAllBooks() {
		return bookRepo.findAllBooks();
	}

	public Book findOne(int id) {
		return bookRepo.findOne(id);
	}

	public void save(Book book) {
		bookRepo.save(book);
	}

	public void delete(int id) {
		bookRepo.delete(id);
	}
}
