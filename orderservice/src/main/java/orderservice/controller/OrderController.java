package orderservice.controller;

import orderservice.entity.Order;
import orderservice.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

  private final OrderService service;

  public OrderController(OrderService service) {
    this.service = service;
  }

  @GetMapping("/all")
  public List<Order> getAll() {
    return service.getAllOrders();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Order> getById(@PathVariable("id") String id) {
    Optional<Order> orderOpt = service.getOrderById(id);
    return orderOpt.map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Order> create(@RequestBody Order order) {
    Order savedOrder = service.createOrder(order);
    URI location = URI.create("/api/orders/" + savedOrder.getId());
    return ResponseEntity.created(location).body(savedOrder);
  }

  // Upd order
  @PutMapping("/{id}")
  public ResponseEntity<Order> update(@PathVariable("id") String id, @RequestBody Order order) {
    Optional<Order> updatedOrder = service.updateOrder(id, order);
    return updatedOrder.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
  }


  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") String id) {
    boolean deleted = service.deleteOrder(id);
    if (!deleted) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.noContent().build();
  }
}
