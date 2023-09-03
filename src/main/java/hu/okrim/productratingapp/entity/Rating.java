package hu.okrim.productratingapp.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Entity
@IdClass(RatingId.class)
public class Rating {
    @Id
    @ManyToOne
    @JoinColumn(name = "person")
    private Person person;
    @Id
    @ManyToOne
    @JoinColumn(name = "product")
    Product product;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date date;
    private Byte taste;
    private Byte smell;
    private String remark;

    public Rating() {
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Byte getTaste() {
        return taste;
    }

    public void setTaste(byte taste) {
        this.taste = taste;
    }

    public Byte getSmell() {
        return smell;
    }

    public void setSmell(byte smell) {
        this.smell = smell;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
