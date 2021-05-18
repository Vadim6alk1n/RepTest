package Lesson_4.Exercise1;

import java.util.Date;

public abstract class material {
	private final String Author;
	private final String title;
	private final Date RDate;

	public String getAuthor() {
		return Author;
	}

	public String getTitle() {
		return title;
	}

	public Date getRDate() {
		return RDate;
	}

	public material(String Author, String title, Date RDate) throws EmptyFieldException {
		if (Author.isEmpty()) {
			throw new EmptyFieldException("Author is empty.");            
		}
		this.Author = Author;
		if (title.isEmpty()) {
			throw new EmptyFieldException("Title is empty.");            
		}
		this.title = title;
		if (RDate == null) {
			throw new EmptyFieldException("Release date is empty.");            
		}
		this.RDate = RDate;
	}
	abstract public void Write();
//    public String toString() {
//        return "Invalid call";
//    }
}