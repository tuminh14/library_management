/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thien.ourproject.bean;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author nguye
 */
@ManagedBean
@Named(value = "ajaxBean")
@RequestScoped
public class AjaxBean {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String goAjax(){
        return "index?faces-redirect=true";
    }
    /**
     * Creates a new instance of AjaxBean
     */
    public AjaxBean() {
    }
    
    public String getMessage(){
        return "Welcome" + this.name;
    }
}
