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

    public Rating(Person person, Product product, Date date, Byte taste, Byte smell, String remark) {
        this.setPerson(person);
        this.setProduct(product);
        this.setDate(date);
        this.setTaste(taste);
        this.setSmell(smell);
        this.setRemark(remark);
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
    public Byte getSmell() {
        return smell;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public void setTaste(Byte taste) {
        this.taste = taste;
    }
    public void setSmell(Byte smell) {
        this.smell = smell;
    }
}
