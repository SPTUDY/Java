package gaeun.section06.com.helloshop.order;

import gaeun.section06.com.helloshop.product.Product;
import gaeun.section06.com.helloshop.user.User;

public class OrderService {
    public void order() {
        User user = new User();
        Product product = new Product();
        Order order = new Order(user, product);
    }
}
