package Homework3;

public class Film extends Materials {
    private Integer min;

    public Film(String name,String year,String author, Integer mincount) {

        super(name,year,author);

        this.min = mincount;
    }
    public void print(){

        System.out.printf("Film Name: %s \t Year: %s \t Film Author: %s \t Minuts Count: %d \n", super.getName(),super.getYear(),super.getAuthor(), min);
    }

}
