package com.book.entities;

public class Book {
	public int bookId;;
	public String bookName;
	public String authorName;
    public int page;
	public int price;
	
	
	public Book() {
		
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", authorName=" + authorName + ", page=" + page
				+ ", price=" + price + "]";
	}
	public Book(int bookId, String bookName, String authorName, int page, int price) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.page = page;
		this.price = price;
	}
	
	
	
}
