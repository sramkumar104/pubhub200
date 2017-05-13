package rambookapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rambookapp.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
