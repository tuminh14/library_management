/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thien.ourproject.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nguye
 */
@Entity
@Table(name = "book")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b"),
    @NamedQuery(name = "Book.findByBookId", query = "SELECT b FROM Book b WHERE b.bookId = :bookId"),
    @NamedQuery(name = "Book.findByBookTitle", query = "SELECT b FROM Book b WHERE b.bookTitle = :bookTitle"),
    @NamedQuery(name = "Book.findByCategoryId", query = "SELECT b FROM Book b WHERE b.categoryId = :categoryId"),
    @NamedQuery(name = "Book.findByAuthor", query = "SELECT b FROM Book b WHERE b.author = :author"),
    @NamedQuery(name = "Book.findByBookCopies", query = "SELECT b FROM Book b WHERE b.bookCopies = :bookCopies"),
    @NamedQuery(name = "Book.findByBookPub", query = "SELECT b FROM Book b WHERE b.bookPub = :bookPub"),
    @NamedQuery(name = "Book.findByPublisherName", query = "SELECT b FROM Book b WHERE b.publisherName = :publisherName"),
    @NamedQuery(name = "Book.findByIsbn", query = "SELECT b FROM Book b WHERE b.isbn = :isbn"),
    @NamedQuery(name = "Book.findByCopyrightYear", query = "SELECT b FROM Book b WHERE b.copyrightYear = :copyrightYear"),
    @NamedQuery(name = "Book.findByDateReceive", query = "SELECT b FROM Book b WHERE b.dateReceive = :dateReceive"),
    @NamedQuery(name = "Book.findByDateAdded", query = "SELECT b FROM Book b WHERE b.dateAdded = :dateAdded"),
    @NamedQuery(name = "Book.findByStatus", query = "SELECT b FROM Book b WHERE b.status = :status")})
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "book_id")
    private Integer bookId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "book_title")
    private String bookTitle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "category_id")
    private int categoryId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "author")
    private String author;
    @Basic(optional = false)
    @NotNull
    @Column(name = "book_copies")
    private int bookCopies;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "book_pub")
    private String bookPub;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "publisher_name")
    private String publisherName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "isbn")
    private String isbn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "copyright_year")
    private int copyrightYear;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "date_receive")
    private String dateReceive;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_added")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "status")
    private String status;

    public Book() {
    }

    public Book(Integer bookId) {
        this.bookId = bookId;
    }

    public Book(Integer bookId, String bookTitle, int categoryId, String author, int bookCopies, String bookPub, String publisherName, String isbn, int copyrightYear, String dateReceive, Date dateAdded, String status) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.categoryId = categoryId;
        this.author = author;
        this.bookCopies = bookCopies;
        this.bookPub = bookPub;
        this.publisherName = publisherName;
        this.isbn = isbn;
        this.copyrightYear = copyrightYear;
        this.dateReceive = dateReceive;
        this.dateAdded = dateAdded;
        this.status = status;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getBookCopies() {
        return bookCopies;
    }

    public void setBookCopies(int bookCopies) {
        this.bookCopies = bookCopies;
    }

    public String getBookPub() {
        return bookPub;
    }

    public void setBookPub(String bookPub) {
        this.bookPub = bookPub;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getCopyrightYear() {
        return copyrightYear;
    }

    public void setCopyrightYear(int copyrightYear) {
        this.copyrightYear = copyrightYear;
    }

    public String getDateReceive() {
        return dateReceive;
    }

    public void setDateReceive(String dateReceive) {
        this.dateReceive = dateReceive;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookId != null ? bookId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.bookId == null && other.bookId != null) || (this.bookId != null && !this.bookId.equals(other.bookId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thien.ourproject.pojo.Book[ bookId=" + bookId + " ]";
    }
    
}
