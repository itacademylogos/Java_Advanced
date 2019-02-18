package ua.lviv.lgs.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Book {

	private long id;
	private String bookName;
	private String author;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookNAme) {
		this.bookName = bookNAme;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", author=" + author + ", purchaseDate=" + "]";
	}
}
