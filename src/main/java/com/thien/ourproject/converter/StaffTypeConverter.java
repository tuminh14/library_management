/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thien.ourproject.converter;

import com.thien.ourproject.services.CategoryServices;
import com.thien.ourproject.services.StaffTypeServices;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author nguye
 */
@FacesConverter("StaffTypeConverter")
public class StaffTypeConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        return new StaffTypeServices().getById(Integer.parseInt(value));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        return value.toString(); 
    }

   

 
    
}
