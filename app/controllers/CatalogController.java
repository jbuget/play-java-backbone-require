package controllers;

import models.catalog.Product;
import models.catalog.Catalog;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static java.math.BigDecimal.valueOf;

public class CatalogController extends Controller {

    @Inject
    Catalog store;

    public Result goToCatalog() {
        return ok(views.html.catalog.catalog.render("Super store"));
    }

    @Transactional(readOnly = true)
    public Result getProducts() {
        List<Product> products = store.getProducts();
        return ok(Json.toJson(products));
    }

    @Transactional(readOnly = true)
    public Result getProduct(Integer id) {
        Product product = store.getProduct(id);
        return ok(Json.toJson(product));
    }

    @Transactional
    public Result addSomeProducts() {
        Product p1 = newProduct(valueOf(25), "Lorem ipsum", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        Product p2 = newProduct(valueOf(35), "De Finibus Bonorum et Malorum", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt.");
        Product p3 = newProduct(valueOf(50), "Neque porro quisquam est", "Qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?");
        Product p4 = newProduct(valueOf(85), "At vero eos", "Et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio.");
        Product p5 = newProduct(valueOf(120), "Nam libero", "Tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat.");

        store.addProducts(Arrays.asList(p1, p2, p3, p4, p5));

        List<Product> products = store.getProducts();
        return ok(Json.toJson(products));
    }

    private Product newProduct(BigDecimal price, String name, String description) {
        Product product = new Product();
        product.setPrice(price);
        product.setName(name);
        product.setDescription(description);
        return product;
    }

}
