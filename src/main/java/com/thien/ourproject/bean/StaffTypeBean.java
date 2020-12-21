/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thien.ourproject.bean;

import com.thien.ourproject.pojo.Category;
import com.thien.ourproject.pojo.StaffType;
import com.thien.ourproject.services.CategoryServices;
import com.thien.ourproject.services.StaffTypeServices;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import java.util.List;

/**
 *
 * @author nguye
 */
@ManagedBean
@Named(value = "typeStaffBean")
@RequestScoped
public class StaffTypeBean {

    /**
     * Creates a new instance of CategoryBean
     */

    private final static StaffTypeServices staffTypeServices = new StaffTypeServices();

    public StaffTypeBean() {
    }
    
    public List<StaffType> getTypes() {
        return staffTypeServices.getAll();
    }
}
