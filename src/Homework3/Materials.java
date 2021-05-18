package Homework3;

public abstract class Materials {
    private String name;
    private String year;
    private String author;


    public String getName() { return name; }
    public String getYear() { return year; }
    public String getAuthor() { return author; }
    public Materials(String name, String year, String author){

        this.name=name;
        this.year=year;
        this.author=author;
    }

    public abstract void print();
}
