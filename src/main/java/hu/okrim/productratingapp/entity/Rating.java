package hu.okrim.productratingapp.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Entity
public class Rating {
    @EmbeddedId
    private RatingId id;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date date;
    private byte taste;
    private byte smell;
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
