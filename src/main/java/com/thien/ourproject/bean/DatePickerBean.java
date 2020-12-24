package com.thien.ourproject.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

@ManagedBean
@RequestScoped
@Named(value = "datePickerBean")
public class DatePickerBean {
    private boolean showIcon = true;
    private boolean showDate = true;
    private boolean showTime = true;
    private boolean useCurrent = true;


    public boolean isShowIcon() {
        return showIcon;
    }

    public void setShowIcon(boolean changeMonth) {
        this.showIcon = changeMonth;
    }

    public boolean isShowDate() {
        return showDate;
    }

    public void setShowDate(boolean showDate) {
        this.showDate = showDate;
    }


    public boolean isUseCurrent() {
        return useCurrent;
    }

    public void setUseCurrent(boolean useCurrent) {
        this.useCurrent = useCurrent;
    }

    public boolean isShowTime() {
        return showTime;
    }

    public void setShowTime(boolean showTime) {
        this.showTime = showTime;
    }
}
