/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thien.ourproject.bean;

import com.thien.ourproject.pojo.*;
import com.thien.ourproject.services.BookServices;
import com.thien.ourproject.services.CategoryServices;
import com.thien.ourproject.services.StaffServices;
import com.thien.ourproject.services.StaffTypeServices;

import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.util.List;

@ManagedBean(name="staffBean")
@RequestScoped
public class StaffBean {

    private int inputId;

    private int id;
    private double salary;
    private People people;
    private StaffType staffType;

    private String keyword;

    private List<Staff> tempStaff;
    private List<Staff> tempStaffSearch;

    private final static StaffServices staffServices = new StaffServices();



    public StaffBean() {
        if (!FacesContext.getCurrentInstance().isPostback()) {

            String staffId = FacesContext.getCurrentInstance().getExternalContext()
                    .getRequestParameterMap().get("staff_id");
            if (staffId != null && !staffId.isEmpty()) {
                Staff staff = staffServices.getById(Integer.parseInt(staffId));
                this.inputId = staff.getId();
                this.salary = staff.getSalary();
                this.people = staff.getPeople();
                ELContext elContext = FacesContext.getCurrentInstance().getELContext();
                PeopleBean peopleBean = (PeopleBean) elContext.getELResolver().getValue(elContext, null, "peopleBean");
                peopleBean.setPeople(people);
                this.staffType = staff.getTypeId();
                
            }
        }
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
                return "staff-collection.xhtml?faces-redirect=true";
            }
        }


        return "index?faces-redirect=true";
    }

    public List<Staff> getStaffs() {
        String staffType = FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("staffTypeId");

        if ( staffType != null && ! staffType.isEmpty()) {
            StaffType c = new StaffTypeServices().getById( staffType);

            if (tempStaff == null) {
                tempStaff = (List<Staff>) c.getStaffCollection();
            }
            return tempStaff;
        }
        if (keyword == null) {
            if (tempStaffSearch == null) {
                tempStaffSearch = staffServices.getAll(null);
            }
            return tempStaffSearch;
        } else {
            if (tempStaff == null) {
                tempStaff = staffServices.getAll(this.keyword);
            }
            return tempStaff;
        }
    }

    public String delete(Staff staff) throws Exception {
        if (staffServices.delete(staff)) {
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
