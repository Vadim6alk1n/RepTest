package Lesson_4.Exercise1;

public class DuplicatedMaterialException extends Exception {
	public DuplicatedMaterialException()
	{
		super("This material already exists!");
	}
}
