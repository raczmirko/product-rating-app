package hu.okrim.productratingapp.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.IdClass;

@Entity
public class ProductFlavour {
    @EmbeddedId
    private ProductFlavourId id;

    public ProductFlavour() {
    }

    public ProductFlavourId getId() {
        return id;
    }

    public void setId(ProductFlavourId id) {
        this.id = id;
    }
}
