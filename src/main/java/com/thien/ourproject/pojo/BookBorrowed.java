/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thien.ourproject.pojo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author nguye
 */
@Entity
@Table(name = "book_borrowed")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookBorrowed.findAll", query = "SELECT b FROM BookBorrowed b"),
    @NamedQuery(name = "BookBorrowed.findById", query = "SELECT b FROM BookBorrowed b WHERE b.id = :id"),
    @NamedQuery(name = "BookBorrowed.findByBookTitle", query = "SELECT b FROM BookBorrowed b WHERE b.bookTitle = :bookTitle"),
    @NamedQuery(name = "BookBorrowed.findByBorrowDate", query = "SELECT b FROM BookBorrowed b WHERE b.borrowDate = :borrowDate"),
    @NamedQuery(name = "BookBorrowed.findByReturnDate", query = "SELECT b FROM BookBorrowed b WHERE b.returnDate = :returnDate")})
public class BookBorrowed implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "borrow_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date borrowDate;
    @Basic(optional = false)
    @Column(name = "return_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date returnDate;
    @JoinColumn(name = "reader_card_id", referencedColumnName = "id")
    @OneToOne
    private ReaderCard readerCardId;
    @JoinColumn(name = "book_title", referencedColumnName = "book_title")
    @ManyToOne
    private Book bookTitle;


    
    public BookBorrowed() {
    }

    public BookBorrowed(Integer id) {
        this.id = id;
    }

    public BookBorrowed(Integer id, Book bookId, Date borrowDate, Date returnDate) {
        this.id = id;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.bookTitle = bookTitle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public ReaderCard getReaderCardId() {
        return readerCardId;
    }

    public void setReaderCardId(ReaderCard readerCardId) {
        this.readerCardId = readerCardId;
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
        if (!(object instanceof BookBorrowed)) {
            return false;
        }
        BookBorrowed other = (BookBorrowed) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thien.ourproject.pojo.BookBorrowed[ id=" + id + " ]";
    }

    public Book getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(Book bookTitle) {
        this.bookTitle = bookTitle;
    }
}
