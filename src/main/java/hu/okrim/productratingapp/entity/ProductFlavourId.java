package hu.okrim.productratingapp.entity;
import jakarta.persistence.IdClass;
import java.io.Serializable;
@IdClass(ProductFlavourId.class)
public class ProductFlavourId implements Serializable {
    private Product product;
    private Flavour flavour;

    public ProductFlavourId() {
    }

    public ProductFlavourId(Product product,Flavour flavour){
        this.setProduct(product);
        this.setFlavour(flavour);
    }
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Flavour getFlavour() {
        return flavour;
    }

    public void setFlavour(Flavour flavour) {
        this.flavour = flavour;
    }
}