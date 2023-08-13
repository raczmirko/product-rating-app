package hu.okrim.productratingapp.entity;

import jakarta.persistence.IdClass;

@IdClass(RatingId.class)
public class RatingId {
    private Integer person;
    private Integer product;

    public RatingId() {
    }

    public Integer getPerson() {
        return person;
    }

    public void setPerson(Integer person) {
        this.person = person;
    }

    public Integer getProduct() {
        return product;
    }

    public void setProduct(Integer product) {
        this.product = product;
    }
}
