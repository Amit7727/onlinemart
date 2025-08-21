package orderservice.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import orderservice.entity.Order;
public interface OrderRepository extends JpaRepository<Order, String> {}
