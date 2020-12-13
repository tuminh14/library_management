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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nguye
 */
@Entity
@Table(name = "reader")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reader.findAll", query = "SELECT r FROM Reader r"),
    @NamedQuery(name = "Reader.findById", query = "SELECT r FROM Reader r WHERE r.id = :id")})
public class Reader implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "people_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private People peopleId;
    @JoinColumn(name = "reader_card_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ReaderCard readerCardId;
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ReaderType typeId;

    public Reader() {
    }

    public Reader(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public People getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(People peopleId) {
        this.peopleId = peopleId;
    }

    public ReaderCard getReaderCardId() {
        return readerCardId;
    }

    public void setReaderCardId(ReaderCard readerCardId) {
        this.readerCardId = readerCardId;
    }

    public ReaderType getTypeId() {
        return typeId;
    }

    public void setTypeId(ReaderType typeId) {
        this.typeId = typeId;
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
        if (!(object instanceof Reader)) {
            return false;
        }
        Reader other = (Reader) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thien.ourproject.pojo.Reader[ id=" + id + " ]";
    }
    
}
