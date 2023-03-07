package io.jotech.orderservice.repository;

import java.math.BigInteger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.jotech.orderservice.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, BigInteger> {
}