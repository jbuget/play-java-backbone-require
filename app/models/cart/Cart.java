package models.cart;

import models.catalog.Product;
import play.db.jpa.JPA;

import javax.persistence.EntityManager;
import java.util.List;

public class Cart {

    public List<Item> getItems() {
        return JPA.em()
                .createQuery("FROM Item", Item.class)
                .getResultList();
    }

    public Item addItem(Product product) {
        Item item = new Item();
        item.setProduct(product);

        EntityManager em =  JPA.em();
        em.persist(item);
        return item;
    }

    public void removeItem(Integer itemId) {
        Item item = getItem(itemId);
        if (item != null) {
            JPA.em().remove(item);
        }
    }

    private Item getItem(Integer itemId) {
        return JPA.em()
                .createQuery("FROM Item WHERE id = :itemId", Item.class)
                .setParameter("itemId", itemId)
                .getSingleResult();
    }

}
