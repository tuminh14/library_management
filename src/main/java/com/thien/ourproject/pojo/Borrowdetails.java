/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thien.ourproject.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nguye
 */
@Entity
@Table(name = "borrowdetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Borrowdetails.findAll", query = "SELECT b FROM Borrowdetails b"),
    @NamedQuery(name = "Borrowdetails.findByBorrowDetailsId", query = "SELECT b FROM Borrowdetails b WHERE b.borrowDetailsId = :borrowDetailsId"),
    @NamedQuery(name = "Borrowdetails.findByBookId", query = "SELECT b FROM Borrowdetails b WHERE b.bookId = :bookId"),
    @NamedQuery(name = "Borrowdetails.findByBorrowId", query = "SELECT b FROM Borrowdetails b WHERE b.borrowId = :borrowId"),
    @NamedQuery(name = "Borrowdetails.findByBorrowStatus", query = "SELECT b FROM Borrowdetails b WHERE b.borrowStatus = :borrowStatus"),
    @NamedQuery(name = "Borrowdetails.findByDateReturn", query = "SELECT b FROM Borrowdetails b WHERE b.dateReturn = :dateReturn")})
public class Borrowdetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "borrow_details_id")
    private Integer borrowDetailsId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "book_id")
    private int bookId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "borrow_id")
    private int borrowId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "borrow_status")
    private String borrowStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "date_return")
    private String dateReturn;

    public Borrowdetails() {
    }

    public Borrowdetails(Integer borrowDetailsId) {
        this.borrowDetailsId = borrowDetailsId;
    }

    public Borrowdetails(Integer borrowDetailsId, int bookId, int borrowId, String borrowStatus, String dateReturn) {
        this.borrowDetailsId = borrowDetailsId;
        this.bookId = bookId;
        this.borrowId = borrowId;
        this.borrowStatus = borrowStatus;
        this.dateReturn = dateReturn;
    }

    public Integer getBorrowDetailsId() {
        return borrowDetailsId;
    }

    public void setBorrowDetailsId(Integer borrowDetailsId) {
        this.borrowDetailsId = borrowDetailsId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(int borrowId) {
        this.borrowId = borrowId;
    }

    public String getBorrowStatus() {
        return borrowStatus;
    }

    public void setBorrowStatus(String borrowStatus) {
        this.borrowStatus = borrowStatus;
    }

    public String getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(String dateReturn) {
        this.dateReturn = dateReturn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (borrowDetailsId != null ? borrowDetailsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Borrowdetails)) {
            return false;
        }
        Borrowdetails other = (Borrowdetails) object;
        if ((this.borrowDetailsId == null && other.borrowDetailsId != null) || (this.borrowDetailsId != null && !this.borrowDetailsId.equals(other.borrowDetailsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thien.ourproject.pojo.Borrowdetails[ borrowDetailsId=" + borrowDetailsId + " ]";
    }
    
}
