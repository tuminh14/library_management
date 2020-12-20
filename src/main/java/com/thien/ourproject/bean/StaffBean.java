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
import com.thien.ourproject.services.StaffServices;

import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@ManagedBean(name="staffBean")
@RequestScoped
public class StaffBean {

    private int inputId;

    private int id;
    private double salary;
    private People people;
    private StaffType staffType;

    private final static StaffServices staffServices = new StaffServices();



    public StaffBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public StaffType getStaffType() {
        return staffType;
    }

    public void setStaffType(StaffType staffType) {
        this.staffType = staffType;
    }

    public int getInputId() {
        return inputId;
    }

    public void setInputId(int inputId) {
        this.inputId = inputId;
    }

    public String addStaff() {

        Staff staff;
        if (this.inputId > 0) {
            staff = staffServices.getById(this.inputId);
        } else {
            staff = new Staff();
        }
        staff.setSalary(this.salary);
        staff.setTypeId(this.staffType);

        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        PeopleBean peopleBean = (PeopleBean) elContext.getELResolver().getValue(elContext, null, "peopleBean");

        People people = peopleBean.add();
        if (people != null) {
            staff.setPeople(people);
            if (staffServices.addOrSave(staff)) {
                return "library-collection.xhtml?faces-redirect=true";
            }
        }


        return "index?faces-redirect=true";
    }
}
