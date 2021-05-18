package Homework3;

public class Book extends Materials {
    private Integer pages;

    public Book(String name,String year,String author, Integer pagescount) {

        super(name,year,author);

        this.pages = pagescount;
    }

    public void print(){

        System.out.printf("Book Name: %s \t Year: %s \t Book Author: %s \t Pages Count: %d \n", super.getName(),super.getYear(),super.getAuthor(), pages);
    }
}
