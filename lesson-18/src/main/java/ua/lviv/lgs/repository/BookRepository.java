package ua.lviv.lgs.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import ua.lviv.lgs.models.Book;

@Repository
public class BookRepository {
	private List<Book> books;

	@PostConstruct
	public void init() {
		books = new ArrayList<>();

		Book book1 = new Book();
		book1.setAuthor("Ivan Gosh");
		book1.setBookName("Hooligan");
		book1.setId(1);
	
		Book book2 = new Book();
		book2.setAuthor("Ivan Gosh 2");
		book2.setBookName("Hooligan 2");
		book2.setId(2);


		Book book3 = new Book();
		book3.setAuthor("Ivan Gosh 3");
		book3.setBookName("Hooligan 3");
		book3.setId(3);


		books.add(book1);
		books.add(book2);
		books.add(book3);
	}

	public List<Book> findAllBooks() {
		return books;
	}

	public void deleteBook(long id) {
		Iterator<Book> iter = books.iterator();
		while (iter.hasNext()) {
			Book book = iter.next();
			if(book.getId() == id) {
				iter.remove();
			}
		}
	}

	public Book findOne(long id) {
		return books.stream().filter(book->book.getId() == id).reduce((a, b) -> {
            throw new IllegalStateException("Multiple elements: " + a + ", " + b);
        }).get();
	}
	
	public void save(Book book) {
		books.add(book);
	}
	
	
}
