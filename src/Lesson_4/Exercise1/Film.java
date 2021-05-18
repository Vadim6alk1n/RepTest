package Lesson_4.Exercise1;

import java.util.Date;

public class Film extends material {
	private final int Length;//in minutes
	public Film(String Author, String title, Date RDate, Integer Length) throws EmptyFieldException {
		super(Author,title,RDate);
		if(Length == null) {
			throw new EmptyFieldException("Length is emtpy");
		}
		this.Length = Length;
	}

	public String toString() {
		return "\"" + getTitle() + "\" - a " + Length + " long film directed by " + getTitle() + " in " + getRDate();
	}
	public void Write() {
		System.out.println("\"" + getTitle() + "\" - a " + Length + " minute long film directed by " + getAuthor() + " in " + getRDate());
	}
}
