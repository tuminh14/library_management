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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @NamedQuery(name = "Book.findById", query = "SELECT b FROM Book b WHERE b.id = :id"),
    @NamedQuery(name = "Book.findByBookTitle", query = "SELECT b FROM Book b WHERE b.bookTitle = :bookTitle"),
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
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "book_title")
    private String bookTitle;
    @Size(max = 50)
    @Column(name = "author")
    private String author;
    @Column(name = "book_copies")
    private Integer bookCopies;
    @Size(max = 100)
    @Column(name = "book_pub")
    private String bookPub;
    @Size(max = 100)
    @Column(name = "publisher_name")
    private String publisherName;
    @Size(max = 50)
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "copyright_year")
    private Integer copyrightYear;
    @Size(max = 20)
    @Column(name = "date_receive")
    private String dateReceive;
    @Column(name = "date_added")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;
    @Size(max = 30)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne
    private Category categoryId;

    public Book() {
    }

    public Book(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getBookCopies() {
        return bookCopies;
    }

    public void setBookCopies(Integer bookCopies) {
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

    public Integer getCopyrightYear() {
        return copyrightYear;
    }

    public void setCopyrightYear(Integer copyrightYear) {
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

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thien.ourproject.pojo.Book[ id=" + id + " ]";
    }
    
}
