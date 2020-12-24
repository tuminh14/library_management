package com.thien.ourproject.bean;

import com.thien.ourproject.pojo.*;
import com.thien.ourproject.services.BookBorrowedServices;
import com.thien.ourproject.services.BookServices;
import com.thien.ourproject.services.ReaderCardServices;
import com.thien.ourproject.services.ReaderServices;



import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    private int bookId;
    private Date endDate;
    private Date returnDate;

    private final static ReaderServices readerServices = new ReaderServices();
    private final static ReaderCardServices readerCardServices = new ReaderCardServices();
    private final static BookBorrowedServices bookBorrowedServices = new BookBorrowedServices();
    private final static BookServices bookServices = new BookServices();




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

    public String addReader() throws ParseException {

        Reader reader = null;
        ReaderCard card= null;
        BookBorrowed bookBorrow = null;
        if (this.inputId > 0) {
            reader = readerServices.getById(this.inputId);
            card = readerCardServices.getById(this.inputId);
        } else {
            reader = new Reader();
            card = new ReaderCard();
            bookBorrow = new BookBorrowed();
        }

        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        PeopleBean peopleBean = (PeopleBean) elContext.getELResolver().getValue(elContext, null, "peopleBean");
        Book book = new BookServices().getBookById(bookId);
        People people = peopleBean.add();
        if(returnDate != null && bookBorrow !=null && book != null){
            bookBorrow.setBookTitle(book);
            bookBorrow.setReturnDate(returnDate);
            bookBorrow.setBorrowDate(new Date());
        }
        if (people != null) {
            reader.setPeopleId(people);
            if(bookBorrowedServices.addOrSave(bookBorrow)){
                card.setEndDate(endDate);
                if (readerCardServices.addOrSave(card)) {
                    bookBorrow.setReaderCardId(card);
                    bookBorrowedServices.addOrSave(bookBorrow);
                    reader.setReaderCardId(card);
                    if (readerServices.addOrSave(reader)){
                        book.setBookCopies(book.getBookCopies() -1);
                        bookServices.addOrSaveBook(book);
                        return "reader-collection.xhtml?faces-redirect=true";
                    }

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

    public List<Book> getBooks(){
        return new BookServices().getBooks(null);
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }


    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
