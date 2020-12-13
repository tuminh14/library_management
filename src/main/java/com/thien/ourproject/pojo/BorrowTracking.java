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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nguye
 */
@Entity
@Table(name = "borrow_tracking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BorrowTracking.findAll", query = "SELECT b FROM BorrowTracking b"),
    @NamedQuery(name = "BorrowTracking.findById", query = "SELECT b FROM BorrowTracking b WHERE b.id = :id"),
    @NamedQuery(name = "BorrowTracking.findByBookId", query = "SELECT b FROM BorrowTracking b WHERE b.bookId = :bookId"),
    @NamedQuery(name = "BorrowTracking.findByReaderId", query = "SELECT b FROM BorrowTracking b WHERE b.readerId = :readerId"),
    @NamedQuery(name = "BorrowTracking.findByStaffId", query = "SELECT b FROM BorrowTracking b WHERE b.staffId = :staffId"),
    @NamedQuery(name = "BorrowTracking.findByBorrowDate", query = "SELECT b FROM BorrowTracking b WHERE b.borrowDate = :borrowDate"),
    @NamedQuery(name = "BorrowTracking.findByReturnDate", query = "SELECT b FROM BorrowTracking b WHERE b.returnDate = :returnDate"),
    @NamedQuery(name = "BorrowTracking.findByIsReturned", query = "SELECT b FROM BorrowTracking b WHERE b.isReturned = :isReturned")})
public class BorrowTracking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "book_id")
    private int bookId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reader_id")
    private int readerId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "staff_id")
    private int staffId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "borrow_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date borrowDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "return_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date returnDate;
    @Column(name = "is_returned")
    private Boolean isReturned;

    public BorrowTracking() {
    }

    public BorrowTracking(Integer id) {
        this.id = id;
    }

    public BorrowTracking(Integer id, int bookId, int readerId, int staffId, Date borrowDate, Date returnDate) {
        this.id = id;
        this.bookId = bookId;
        this.readerId = readerId;
        this.staffId = staffId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
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

    public Boolean getIsReturned() {
        return isReturned;
    }

    public void setIsReturned(Boolean isReturned) {
        this.isReturned = isReturned;
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
        if (!(object instanceof BorrowTracking)) {
            return false;
        }
        BorrowTracking other = (BorrowTracking) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thien.ourproject.pojo.BorrowTracking[ id=" + id + " ]";
    }
    
}
