package com.thien.ourproject.bean;

import com.thien.ourproject.model.NavigationBar;
import com.thien.ourproject.pojo.Book;
import com.thien.ourproject.pojo.Category;
import com.thien.ourproject.services.BookServices;
import com.thien.ourproject.services.CategoryServices;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@RequestScoped
@Named(value = "navigationBarBean")
public class NavigationBarBean {

    public List<NavigationBar> getNavigationBar(){
        List<NavigationBar> returnValue = new ArrayList<NavigationBar>();
        List<Category> categories = new CategoryServices().getTopCategories(5);
        for(Category cate: categories){
            List<Book> queriedBooks = (List<Book>) cate.getBookCollection();
            NavigationBar newNavigationBar = new NavigationBar();
            newNavigationBar.setCategory(cate.getName());
            newNavigationBar.setListOfBook(queriedBooks);
            returnValue.add(newNavigationBar);
        }
        return returnValue;
    }
}
