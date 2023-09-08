package hu.okrim.productratingapp.entity;

import jakarta.persistence.IdClass;
@IdClass(RatingId.class)
public class RatingId {
    private Person person;
    private Product product;

    public RatingId() {
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
}
