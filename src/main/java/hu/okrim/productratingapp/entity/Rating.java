package hu.okrim.productratingapp.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Rating {
    private int person;
    private int product;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date date;
    private int taste;
    private int smell;
    private String remark;

    public int getPerson() {
        return person;
    }

    public void setPerson(int person) {
        this.person = person;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTaste() {
        return taste;
    }

    public void setTaste(int taste) {
        this.taste = taste;
    }

    public int getSmell() {
        return smell;
    }

    public void setSmell(int smell) {
        this.smell = smell;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
