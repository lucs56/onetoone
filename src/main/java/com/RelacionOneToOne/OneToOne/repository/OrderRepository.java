package com.RelacionOneToOne.OneToOne.repository;

import com.RelacionOneToOne.OneToOne.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
