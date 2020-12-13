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
@Named(value = "productBean")
public class ProductBean {

    private String name;
    private String description;
    private Long price;
    private Category category;

    private final static ProductServices productServices = new ProductServices();

    private String keyword;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
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
        return new ProductServices().getProducts(this.keyword);
    }

    public String addProduct() {
        Product product = new Product();
        product.setName(this.name);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setCategoryId(this.category);
        
        if (productServices.addOrSaveProduct(product) == true)
            return "products-list?faces-redirect=true";
        
        return "index";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
