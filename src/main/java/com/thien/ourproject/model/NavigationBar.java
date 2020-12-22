package com.thien.ourproject.model;

import com.thien.ourproject.pojo.Book;

import java.util.List;

public class NavigationBar {
    private String category;
    private List<Book> listOfBook;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Book> getListOfBook() {
        return listOfBook;
    }

    public void setListOfBook(List<Book> listOfBook) {
        this.listOfBook = listOfBook;
    }
}
