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

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author nguye
 */
@ManagedBean
@Named(value = "homeBean")
//@Dependent
@RequestScoped
public class HomeBean {

    private String kw;
    /**
     * @return the kw
     */
    public String getKw() {
        return kw;
    }

    /**
     * @param kw the kw to set
     */
    public void setKw(String kw) {
        this.kw = kw;
    }

    

    /**
     * Creates a new instance of HomeBean
     */
    public HomeBean() {
    }

    public List<Category> getCategories() {
        return new CategoryServices().getCates();
    }

    public List<Product> getProducts() {

        String cateId = FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("cateId");

        if (cateId != null && !cateId.isEmpty()) {
            Category c = new CategoryServices().getCateById(cateId);

            return (List<Product>) c.getProductCollection();
        }
        return new ProductServices().getProducts(this.kw);
    }

}
