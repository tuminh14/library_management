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
@Table(name = "reader_card")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReaderCard.findAll", query = "SELECT r FROM ReaderCard r"),
    @NamedQuery(name = "ReaderCard.findById", query = "SELECT r FROM ReaderCard r WHERE r.id = :id"),
    @NamedQuery(name = "ReaderCard.findByEndDate", query = "SELECT r FROM ReaderCard r WHERE r.endDate = :endDate")})
public class ReaderCard implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "readerCardId")
    private Reader reader;
    @OneToOne(mappedBy = "readerCardId")
    private BookBorrowed bookBorrowed;

    public ReaderCard() {
    }

    public ReaderCard(Integer id) {
        this.id = id;
    }

    public ReaderCard(Integer id, Date endDate) {
        this.id = id;
        this.endDate = endDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @XmlTransient



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReaderCard)) {
            return false;
        }
        ReaderCard other = (ReaderCard) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thien.ourproject.pojo.ReaderCard[ id=" + id + " ]";
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public BookBorrowed getBookBorrowed() {
        return bookBorrowed;
    }

    public void setBookBorrowed(BookBorrowed bookBorrowed) {
        this.bookBorrowed = bookBorrowed;
    }
}
