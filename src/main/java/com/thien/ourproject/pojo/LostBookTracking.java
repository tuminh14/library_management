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
@Table(name = "lost_book_tracking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LostBookTracking.findAll", query = "SELECT l FROM LostBookTracking l"),
    @NamedQuery(name = "LostBookTracking.findById", query = "SELECT l FROM LostBookTracking l WHERE l.id = :id"),
    @NamedQuery(name = "LostBookTracking.findByBookId", query = "SELECT l FROM LostBookTracking l WHERE l.bookId = :bookId"),
    @NamedQuery(name = "LostBookTracking.findByReaderId", query = "SELECT l FROM LostBookTracking l WHERE l.readerId = :readerId"),
    @NamedQuery(name = "LostBookTracking.findByStaffId", query = "SELECT l FROM LostBookTracking l WHERE l.staffId = :staffId"),
    @NamedQuery(name = "LostBookTracking.findByBorrowDate", query = "SELECT l FROM LostBookTracking l WHERE l.borrowDate = :borrowDate"),
    @NamedQuery(name = "LostBookTracking.findByLostDate", query = "SELECT l FROM LostBookTracking l WHERE l.lostDate = :lostDate"),
    @NamedQuery(name = "LostBookTracking.findByReason", query = "SELECT l FROM LostBookTracking l WHERE l.reason = :reason")})
public class LostBookTracking implements Serializable {

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
    @Column(name = "lost_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lostDate;
    @Size(max = 50)
    @Column(name = "reason")
    private String reason;

    public LostBookTracking() {
    }

    public LostBookTracking(Integer id) {
        this.id = id;
    }

    public LostBookTracking(Integer id, int bookId, int readerId, int staffId, Date borrowDate, Date lostDate) {
        this.id = id;
        this.bookId = bookId;
        this.readerId = readerId;
        this.staffId = staffId;
        this.borrowDate = borrowDate;
        this.lostDate = lostDate;
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

    public Date getLostDate() {
        return lostDate;
    }

    public void setLostDate(Date lostDate) {
        this.lostDate = lostDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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
        if (!(object instanceof LostBookTracking)) {
            return false;
        }
        LostBookTracking other = (LostBookTracking) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thien.ourproject.pojo.LostBookTracking[ id=" + id + " ]";
    }
    
}
