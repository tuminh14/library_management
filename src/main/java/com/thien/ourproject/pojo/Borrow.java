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
@Table(name = "borrow")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Borrow.findAll", query = "SELECT b FROM Borrow b"),
    @NamedQuery(name = "Borrow.findByBorrowId", query = "SELECT b FROM Borrow b WHERE b.borrowId = :borrowId"),
    @NamedQuery(name = "Borrow.findByMemberId", query = "SELECT b FROM Borrow b WHERE b.memberId = :memberId"),
    @NamedQuery(name = "Borrow.findByDateBorrow", query = "SELECT b FROM Borrow b WHERE b.dateBorrow = :dateBorrow"),
    @NamedQuery(name = "Borrow.findByDueDate", query = "SELECT b FROM Borrow b WHERE b.dueDate = :dueDate")})
public class Borrow implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "borrow_id")
    private Integer borrowId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "member_id")
    private long memberId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "date_borrow")
    private String dateBorrow;
    @Size(max = 100)
    @Column(name = "due_date")
    private String dueDate;

    public Borrow() {
    }

    public Borrow(Integer borrowId) {
        this.borrowId = borrowId;
    }

    public Borrow(Integer borrowId, long memberId, String dateBorrow) {
        this.borrowId = borrowId;
        this.memberId = memberId;
        this.dateBorrow = dateBorrow;
    }

    public Integer getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Integer borrowId) {
        this.borrowId = borrowId;
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public String getDateBorrow() {
        return dateBorrow;
    }

    public void setDateBorrow(String dateBorrow) {
        this.dateBorrow = dateBorrow;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (borrowId != null ? borrowId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Borrow)) {
            return false;
        }
        Borrow other = (Borrow) object;
        if ((this.borrowId == null && other.borrowId != null) || (this.borrowId != null && !this.borrowId.equals(other.borrowId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thien.ourproject.pojo.Borrow[ borrowId=" + borrowId + " ]";
    }
    
}
