package models.catalog;

import play.db.jpa.JPA;

import javax.persistence.EntityManager;
import java.util.List;

public class Catalog {

    public Product addProduct(Product product) {
        EntityManager em =  JPA.em();
        em.persist(product);
        return product;
    }

    public List<Product> addProducts(List<Product> products) {
        EntityManager em =  JPA.em();
        products.forEach(em::persist);
        return products;
    }

    public List<Product> getProducts() {
        return JPA.em()
                .createQuery("FROM Product", Product.class)
                .getResultList();
    }

    public Product getProduct(Integer productId) {
        return JPA.em()
                .createQuery("FROM Product WHERE id = :productId", Product.class)
                .setParameter("productId", productId)
                .getSingleResult();
    }

}
