package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.cart.Cart;
import models.cart.Item;
import models.catalog.Catalog;
import models.catalog.Product;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;

public class CartController extends Controller {

    @Inject
    Cart cart;

    @Inject
    Catalog store;

    public Result goToCart() {
        return ok(views.html.cart.cart.render("My Cart"));
    }

    @Transactional(readOnly=true)
    public Result getItems() {
        List<Item> items = cart.getItems();
        return ok(Json.toJson(items));
    }

    @Transactional
    @BodyParser.Of(BodyParser.Json.class)
    public Result addItem() {
        JsonNode json = request().body().asJson();

        Integer productId = json.findPath("productId").intValue();

        Product product = store.getProduct(productId);

        Item item = cart.addItem(product);

        return ok(Json.toJson(item));
    }

    @Transactional
    public Result removeItem(Integer id) {
        JsonNode json = request().body().asJson();

        Integer itemId = json.get("itemId").asInt();

        cart.removeItem(itemId);

        return noContent();
    }

}
