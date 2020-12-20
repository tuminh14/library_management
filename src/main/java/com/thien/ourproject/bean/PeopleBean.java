/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thien.ourproject.bean;

import com.thien.ourproject.pojo.Book;
import com.thien.ourproject.pojo.People;
import com.thien.ourproject.pojo.Staff;
import com.thien.ourproject.pojo.StaffType;
import com.thien.ourproject.services.PeopleServices;
import com.thien.ourproject.services.StaffServices;

import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@ManagedBean
@RequestScoped
@Named(value = "peopleBean")
public class PeopleBean {

    private int id;
    private String firstname;
    private String lastname;
    private String gender;
    private String address;
    private String contact;
    private People people;

    private final static PeopleServices peopleServices = new PeopleServices();


    public PeopleBean() {
        if (!FacesContext.getCurrentInstance().isPostback()) {

            String staffId = FacesContext.getCurrentInstance().getExternalContext()
                    .getRequestParameterMap().get("staff_id");
            if (staffId != null && !staffId.isEmpty()) {
                Staff staff = new StaffServices().getById(Integer.parseInt(staffId));
                this.setPeople(staff.getPeople());
            }
        }
    }



    public People add() {
        People people = new People();

        people.setFirstname(this.firstname);
        people.setLastname(this.lastname);
        people.setAddress(this.address);
        people.setGender(this.gender);
        people.setContact(this.contact);

        People result =  peopleServices.addOrSave(people);

        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
        this.firstname = people.getFirstname();
        this.lastname = people.getLastname();
        this.contact = people.getContact();
        this.address = people.getAddress();
        this.gender = people.getGender();
        this.id = people.getId();
    }
}
