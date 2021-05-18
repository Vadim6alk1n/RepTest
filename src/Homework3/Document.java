package Homework3;

public class Document extends Materials {
    private String approve;

    public Document(String name,String year,String author, String approveler) {

        super(name,year,author);

        this.approve = approveler;
    }

    public void print(){

        System.out.printf("Document Name: %s \t Year: %s \t Document Author: %s \t Document approved by: %s \n", super.getName(),super.getYear(),super.getAuthor(), approve);
    }
}
