/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thien.ourproject.bean;

import com.thien.ourproject.pojo.Category;
import com.thien.ourproject.pojo.Product;
import com.thien.ourproject.services.CategoryServices;
import com.thien.ourproject.services.ProductServices;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author nguye
 */
@ManagedBean
@RequestScoped
@Named(value = "categoryBean")
public class CategoryBean implements Serializable{
    private final static CategoryServices categoryServices = new CategoryServices();
    
    public CategoryBean() {
        
    }
    
    public List<Category> getCategories(){
        return categoryServices.getCates();
    }
}
