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
@Table(name = "lost_book")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LostBook.findAll", query = "SELECT l FROM LostBook l"),
    @NamedQuery(name = "LostBook.findByBookID", query = "SELECT l FROM LostBook l WHERE l.bookID = :bookID"),
    @NamedQuery(name = "LostBook.findByIsbn", query = "SELECT l FROM LostBook l WHERE l.isbn = :isbn"),
    @NamedQuery(name = "LostBook.findByMemberNo", query = "SELECT l FROM LostBook l WHERE l.memberNo = :memberNo"),
    @NamedQuery(name = "LostBook.findByDateLost", query = "SELECT l FROM LostBook l WHERE l.dateLost = :dateLost")})
public class LostBook implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Book_ID")
    private Integer bookID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISBN")
    private int isbn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Member_No")
    private String memberNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date Lost")
    @Temporal(TemporalType.DATE)
    private Date dateLost;

    public LostBook() {
    }

    public LostBook(Integer bookID) {
        this.bookID = bookID;
    }

    public LostBook(Integer bookID, int isbn, String memberNo, Date dateLost) {
        this.bookID = bookID;
        this.isbn = isbn;
        this.memberNo = memberNo;
        this.dateLost = dateLost;
    }

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public Date getDateLost() {
        return dateLost;
    }

    public void setDateLost(Date dateLost) {
        this.dateLost = dateLost;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookID != null ? bookID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LostBook)) {
            return false;
        }
        LostBook other = (LostBook) object;
        if ((this.bookID == null && other.bookID != null) || (this.bookID != null && !this.bookID.equals(other.bookID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thien.ourproject.pojo.LostBook[ bookID=" + bookID + " ]";
    }
    
}
