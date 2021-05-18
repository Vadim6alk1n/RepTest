package Lesson_4.Exercise1;

import java.util.Date;

public class Book extends material {
	private final int PageCount;
	public Book(String Author, String title, Date RDate, Integer PageCount) throws EmptyFieldException {
		super(Author,title,RDate);
		if (PageCount == null) {
			throw new EmptyFieldException("Page Count is empty.");
		}
		this.PageCount = PageCount;
	}

	public void Write() {
		System.out.println("\"" + getTitle() + "\" - a " + PageCount + " page book written by " + getAuthor() + " in " + getRDate());
	}
}
