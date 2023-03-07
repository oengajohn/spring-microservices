package io.jotech.productservice.repository;

import java.math.BigInteger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.jotech.productservice.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, BigInteger> {
}