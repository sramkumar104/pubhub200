package rambookapp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rambookapp.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	public List<Order> findByUserIdOrderByIdDesc(Long userId);
	
public List<Order> findByOrderByIdDesc();



}
