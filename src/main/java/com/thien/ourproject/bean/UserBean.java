/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thien.ourproject.bean;

import com.thien.ourproject.pojo.Book;
import com.thien.ourproject.pojo.Category;
import com.thien.ourproject.pojo.Users;
import com.thien.ourproject.services.CategoryServices;
import com.thien.ourproject.services.BookServices;
import com.thien.ourproject.services.UserServices;
import java.math.BigDecimal;
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
@Named(value = "userBean")
public class UserBean {
    private String username;
    private String password;
    
    private static UserServices userServices = new UserServices();
    
    public String register(){
        Users user = new Users();
        user.setUsername(username);
        user.setPassword(password);
        
        if(userServices.addUser(user) == true) {
            return "login?faces-redirect=true";
        }
        
        return "register";
    }
    
    public String login() {
        Users user = userServices.login(username, password);
        
        if(user!=null) {
            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getSessionMap().put("user", user);
            return "index?faces-redirect=true"; 
        }
        
            
        return "login";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
