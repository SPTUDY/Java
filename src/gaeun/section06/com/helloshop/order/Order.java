package gaeun.section06.com.helloshop.order;

import gaeun.section06.com.helloshop.product.Product;
import gaeun.section06.com.helloshop.user.User;

public class Order {
    User user;
    Product product;

    public Order(User user, Product product) {
        this.user = user;
        this.product = product;
    }
}
