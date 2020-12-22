package com.thien.ourproject.model;

public class AuthorBook implements Comparable<AuthorBook>{
    private String  name;
    private Integer numOfBook;

    public AuthorBook(String name, Integer numOfBook){
        this.name = name;
        this.numOfBook = numOfBook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumOfBook() {
        return numOfBook;
    }

    public void setNumOfBook(Integer numOfBook) {
        this.numOfBook = numOfBook;
    }

    @Override
    public int compareTo(AuthorBook d) {
        return d.getNumOfBook() - this.numOfBook;
    }
}
