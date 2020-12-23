package com.thien.ourproject.bean;

import com.thien.ourproject.pojo.People;
import com.thien.ourproject.pojo.Reader;
import com.thien.ourproject.pojo.ReaderCard;
import com.thien.ourproject.services.ReaderCardServices;
import com.thien.ourproject.services.ReaderServices;



import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.util.Date;
import java.util.List;

@ManagedBean(name="readerBean")
@RequestScoped
public class ReaderBean {
    private int inputId;

    private int id;

    private People people;

    private String keyword;

    private List<Reader> tempReader;
    private List<Reader> tempReaderSearch;
    private Integer bookId;
    private String endDate;
    private String returnDate;

    private final static ReaderServices readerServices = new ReaderServices();
    private final static ReaderCardServices readerCardServices = new ReaderCardServices();




    public ReaderBean() {
        if (!FacesContext.getCurrentInstance().isPostback()) {

            String readerId = FacesContext.getCurrentInstance().getExternalContext()
                    .getRequestParameterMap().get("reader_id");
            if (readerId != null && !readerId.isEmpty()) {
                Reader reader = readerServices.getById(Integer.parseInt(readerId));
                this.inputId = reader.getId();
                this.people = reader.getPeopleId();
                ELContext elContext = FacesContext.getCurrentInstance().getELContext();
                PeopleBean peopleBean = (PeopleBean) elContext.getELResolver().getValue(elContext, null, "peopleBean");
                peopleBean.setPeople(people);
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }


    public int getInputId() {
        return inputId;
    }

    public void setInputId(int inputId) {
        this.inputId = inputId;
    }

    public String addReader() {

        Reader reader = null;
        ReaderCard card= null;
        if (this.inputId > 0) {
            reader = readerServices.getById(this.inputId);
            card = readerCardServices.getById(this.inputId);

        } else {
            reader = new Reader();
        }

        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        PeopleBean peopleBean = (PeopleBean) elContext.getELResolver().getValue(elContext, null, "peopleBean");

        People people = peopleBean.add();


        if(bookId != null && endDate != null ){

        }
        if (people != null) {
            reader.setPeopleId(people);
            if (readerCardServices.addOrSave(card)) {
                if (readerServices.addOrSave(reader)){
                    return "staff-collection.xhtml?faces-redirect=true";
                }

            }
        }


        return "index?faces-redirect=true";
    }

    public List<Reader> getReaders() {
        if (keyword == null) {
            if (tempReaderSearch == null) {
                tempReaderSearch = readerServices.getAll(null);
            }
            return tempReaderSearch;
        } else {
            if (tempReader == null) {
                tempReader = readerServices.getAll(this.keyword);
            }
            return tempReader;
        }
    }

    public String delete(Reader reader) throws Exception {
        if (readerServices.delete(reader)) {
            return "Successful";
        }
        throw new Exception("Something wrong");
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
