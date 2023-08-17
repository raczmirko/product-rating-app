package hu.okrim.productratingapp.entity;
import jakarta.persistence.IdClass;
import java.io.Serializable;
@IdClass(ProductFlavourId.class)
public class ProductFlavourId implements Serializable {
    private Integer product;
    private Integer flavour;

    public ProductFlavourId() {
    }
    public Integer getProduct() {
        return product;
    }

    public void setProduct(Integer product) {
        this.product = product;
    }

    public Integer getFlavour() {
        return flavour;
    }

    public void setFlavour(Integer flavour) {
        this.flavour = flavour;
    }
}