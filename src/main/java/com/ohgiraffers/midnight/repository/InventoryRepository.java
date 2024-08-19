package com.ohgiraffers.midnight.model.repository;

import com.ohgiraffers.midnight.model.embedded.InventoryId;
import com.ohgiraffers.midnight.model.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, InventoryId> {
}
