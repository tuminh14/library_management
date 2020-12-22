/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thien.ourproject.bean;

import com.thien.ourproject.model.AuthorBook;
import com.thien.ourproject.pojo.Book;
import com.thien.ourproject.pojo.Category;
import com.thien.ourproject.services.CategoryServices;
import com.thien.ourproject.services.BookServices;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author nguye
 */
@ManagedBean
@RequestScoped
@Named(value = "bookBean")
public class BookBean {
    
    private int tempBookId;

    public int getTempBookId() {
        return tempBookId;
    }

    public void setTempBookId(int tempBookId) {
        this.tempBookId = tempBookId;
    }
    


    private int id;
    private String book_title;
    private String author;
    private int book_copies;

    private Category category;

    private final static BookServices bookServices = new BookServices();

    private String keyword;

    private List<Book> tempBook;
    private List<Book> tempBookSearch;

    public BookBean() {
        if (!FacesContext.getCurrentInstance().isPostback()) {

            String bookId = FacesContext.getCurrentInstance().getExternalContext()
                    .getRequestParameterMap().get("book_id");
            if (bookId != null && !bookId.isEmpty()) {
                Book book = bookServices.getBookById(Integer.parseInt(bookId));
                this.tempBookId = book.getId();
                this.book_title = book.getBookTitle();
                this.author = book.getAuthor();
                this.book_copies = book.getBookCopies();
                this.category = book.getCategoryId();
            }
        }
    }


    public String addBook() {
       
        Book book;
        if (this.tempBookId > 0) {
            book = bookServices.getBookById(this.tempBookId);
        } else {
            book = new Book();
        }

        book.setBookTitle(this.book_title);
        book.setAuthor(this.author);
        book.setBookCopies(this.book_copies);
        book.setCategoryId(this.category);

        if (bookServices.addOrSaveBook(book) == true) {
            return "library-collection.xhtml?faces-redirect=true";
        }

        return "index?faces-redirect=true";
    }
    


    public List<Book> getBooks() {
        String cateId = FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("cateId");

        if (cateId != null && !cateId.isEmpty()) {
            Category c = new CategoryServices().getCateById(cateId);

            if (tempBook == null) {
                tempBook = (List<Book>) c.getBookCollection();
            }
            return tempBook;
        }
        if (keyword == null) {
            if (tempBookSearch == null) {
                tempBookSearch = new BookServices().getBooks(null);
            }
            return tempBookSearch;
        } else {
            if (tempBook == null) {
                tempBook = new BookServices().getBooks(this.keyword);
            }
            return tempBook;
        }

    }
    public List<Book> getTopBooks(){
        return new BookServices().getTopBook(6);
    }
    public ArrayList<AuthorBook> getAuthors(){
        return new BookServices().getAuthors();
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {

        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getBook_copies() {
        return book_copies;
    }

    public void setBook_copies(int book_copies) {
        this.book_copies = book_copies;
    }

    public String deleteBook(Book book) throws Exception {
        if (bookServices.deleteBook(book)) {
            return "Successful";
        }
        throw new Exception("Something wrong");
    }



}
