package Lesson_4.Exercise1;

import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;

public class L4E1_ArchiveExceptions {
	public static void append(Object[] arr, Object add) {
		arr = Arrays.copyOf(arr, arr.length + 1);
		arr[arr.length - 1] = add;
	}
	public static class Archive {
		private material[] Materials = new material[] {};
		public void append(material NewMaterial) throws DuplicatedMaterialException {
			for (material m : Materials) {
				if (m.equals(NewMaterial)) {
					throw new DuplicatedMaterialException();
				}
			}
			this.Materials = Arrays.copyOf(this.Materials, this.Materials.length + 1);
			this.Materials[this.Materials.length - 1] = NewMaterial;
		}
		public void view() {
			for (material Material: this.Materials) {
				Material.Write();
			}
		}
		public void add(material NewMaterial) {
			try {
				this.append(NewMaterial);
			} catch (Exception e) {
				System.out.println("Sorry an error has occured.\n\nDebug info:");
				System.out.println(e.getMessage()+" material:"+NewMaterial);
			}
		}
	}
	public static void main(String[] args) {
		//System.out.println("bruh");
		Archive archive = new Archive();
		GregorianCalendar calendar = new GregorianCalendar(1984, GregorianCalendar.JUNE, 8);
		Date date = calendar.getTime();
		try {
			Book book = new Book("George Orwell","1984", date, 328);
			archive.add(book);
		} catch (Exception e) {
			System.out.println("Book couldn't be created.\n\n"+e.getMessage());
		}
		
		calendar.set(1977, GregorianCalendar.MAY, 25);
		date = calendar.getTime();
		try {
			Film film = new Film("George Lucas", "Star Wars", date, 121);
			archive.add(film);
			archive.add(film);
		} catch (Exception e) {
			System.out.println("Book couldn't be created.\n\n"+e.getMessage());
		}
		archive.view();
		try {
			Film film = new Film("George Lucas", "Star Wars", date, null);
			archive.add(film);
		} catch (Exception e) {
			System.out.println("Book couldn't be created.\n\n"+e.getMessage());
			return;
		}
	}
}
