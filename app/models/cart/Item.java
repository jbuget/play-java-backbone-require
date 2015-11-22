package models.cart;

import models.PersistentEntity;
import models.catalog.Product;

import javax.persistence.*;

@Entity
public class Item extends PersistentEntity {

    @ManyToOne
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
