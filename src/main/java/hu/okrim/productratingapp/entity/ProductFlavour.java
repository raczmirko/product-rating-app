package hu.okrim.productratingapp.entity;

import jakarta.persistence.*;

@Entity
@IdClass(ProductFlavourId.class)
public class ProductFlavour {
    @Id
    @ManyToOne
    @JoinColumn(name = "product")
    private Product product;
    @Id
    @ManyToOne
    @JoinColumn(name = "flavour")
    private Flavour flavour;
    public ProductFlavour() {
    }

    public ProductFlavour(Product product, Flavour flavour){
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