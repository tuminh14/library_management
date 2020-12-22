/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thien.ourproject.bean;

import com.thien.ourproject.pojo.Category;
import com.thien.ourproject.services.CategoryServices;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author nguye
 */
@ManagedBean
@Named(value = "categoryBean")
@RequestScoped
public class CategoryBean {

    /**
     * Creates a new instance of CategoryBean
     */
    public CategoryBean() {
    }
    
    public List<Category> getCategories() {
        return new CategoryServices().getCates();
    }

    public String getTest(){
        return "testCate";
    }
}
