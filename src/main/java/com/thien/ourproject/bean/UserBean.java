/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thien.ourproject.bean;

import com.thien.ourproject.configs.Constants;
import com.thien.ourproject.pojo.Book;
import com.thien.ourproject.pojo.Category;
import com.thien.ourproject.pojo.Users;
import com.thien.ourproject.services.CategoryServices;
import com.thien.ourproject.services.BookServices;
import com.thien.ourproject.services.UserServices;
import java.math.BigDecimal;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
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

    public String register() {
        Users user = new Users();
        user.setUsername(username);
        user.setPassword(password);

        if (userServices.addUser(user) == true) {
            return "login?faces-redirect=true";
        }

        return "register";
    }

    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
    

    public String login() {
        Users user = userServices.login(username, password);

        if (user != null) {
            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getSessionMap().put("user", user);
            return "index?faces-redirect=true";
        } else {
            this.setError(Constants.ERROR_MESSAGE.LOGIN_FAILD);
            return null;
        }

    }

    public String checkLogin() {
        if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user") != null) {
            return "index?faces-redirect=true";
        }
        return null;
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("user");
        return "login?faces-redirect=true";
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
