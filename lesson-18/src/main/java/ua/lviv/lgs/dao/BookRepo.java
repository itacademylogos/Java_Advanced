package ua.lviv.lgs.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import ua.lviv.lgs.domain.Book;

@Repository
public class BookRepo {

	private List<Book> books = new ArrayList<>();

	@PostConstruct
	public void init() {
		Book book1 = new Book();
		book1.setAuthor("Ivan Gosh");
		book1.setName("Hooligan");
		book1.setId(1);

		Book book2 = new Book();
		book2.setAuthor("Ivan Gosh 2");
		book2.setName("Hooligan 2");
		book2.setId(2);

		Book book3 = new Book();
		book3.setAuthor("Ivan Gosh 3");
		book3.setName("Hooligan 3");
		book3.setId(3);

		books.add(book1);
		books.add(book2);
		books.add(book3);
	}

	public List<Book> findAllBooks() {
		return books;
	}

	public Book findOne(int id) {
		return books.stream().filter(book -> book.getId() == id).findFirst().orElse(null);
	}

	public void save(Book book) {
		Book bookToUpdate = null;

		if (book.getId() != null) {
			bookToUpdate = findOne(book.getId());
			int bookIndex = books.indexOf(bookToUpdate);
			bookToUpdate.setName(book.getName());
			bookToUpdate.setAuthor(book.getAuthor());
			books.set(bookIndex, bookToUpdate);
		} else {
			// save
			book.setId(books.size()+1);
			books.add(book);
		}
	}

	public void delete(int id) {
		Iterator<Book> iter = books.iterator();
		while (iter.hasNext()) {
			if (iter.next().getId() == id) {
				iter.remove();
			}
		}
	}

}
