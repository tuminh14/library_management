/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thien.ourproject.bean;

import com.thien.ourproject.pojo.Book;
import com.thien.ourproject.pojo.Category;
import com.thien.ourproject.services.CategoryServices;
import com.thien.ourproject.services.BookServices;
import java.math.BigDecimal;
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

    private int id;
    private String book_title;
    private String author;
    private int book_copies;

    private final static BookServices bookServices = new BookServices();

    private String keyword;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<Book> getBooks() {

        String cateId = FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("cateId");

        if (cateId != null && !cateId.isEmpty()) {
            Category c = new CategoryServices().getCateById(cateId);

            return (List<Book>) c.getBookCollection();
        }
        return new BookServices().getBooks(this.keyword);
    }

//    public String addProduct() {
//        Product product = new Product();
//        product.setName(this.name);
//        product.setDescription(this.description);
//        product.setPrice(this.price);
//        product.setCategoryId(this.category);
//        
//        if (productServices.addOrSaveProduct(product) == true)
//            return "products-list?faces-redirect=true";
//        
//        return "index";
//    }

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

   

}
