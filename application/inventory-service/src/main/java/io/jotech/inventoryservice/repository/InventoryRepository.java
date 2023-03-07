package io.jotech.inventoryservice.repository;

import java.math.BigInteger;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.jotech.inventoryservice.model.Inventory;
@Repository
public interface InventoryRepository extends JpaRepository<Inventory, BigInteger> {

    List<Inventory> findBySkuCodeIn(List<String> skuCodes);
}