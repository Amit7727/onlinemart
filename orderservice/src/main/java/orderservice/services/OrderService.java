package orderservice.services;


import orderservice.entity.Order;
import orderservice.repo.OrderRepository;
import org.springframework.stereotype.Service;

import common.client.ProductClient;
import common.client.UserClient;
import common.dto.ProductDto;
import common.dto.UserDto;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

	private final OrderRepository repo;
	  private final UserClient userClient;
	  private final ProductClient productClient;

	  public OrderService(OrderRepository repo, UserClient userClient, ProductClient productClient) {
	    this.repo = repo; this.userClient = userClient; this.productClient = productClient;
	  }

	  public Order create(Order o) {
		System.out.println(o.getProductId());
	    UserDto user = userClient.getById(o.getUserId()); // throws if 404
	    System.out.println(user);
	    ProductDto product = productClient.getById(o.getProductId());
	    if (o.getQuantity() == null || o.getQuantity() <= 0) throw new IllegalArgumentException("Quantity must be > 0");
	    double total = product.getPrice() * o.getQuantity();
	    o.setTotal(total);
	    return repo.save(o);
	  }

  public List<Order> getAllOrders() {
    return repo.findAll();
  }

  public Optional<Order> getOrderById(String id) {
    return repo.findById(id);
  }

  public Order createOrder(Order order) {
    return repo.save(order);
  }

  public Optional<Order> updateOrder(String id, Order updatedOrder) {
    return repo.findById(id).map(existingOrder -> {
      existingOrder.setQuantity(updatedOrder.getQuantity());
      return repo.save(existingOrder);
    });
  }

  public boolean deleteOrder(String id) {
    if (!repo.existsById(id)) {
      return false;
    }
    repo.deleteById(id);
    return true;
  }
}

