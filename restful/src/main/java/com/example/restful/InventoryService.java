package com.example.restful;

import java.util.List;

public interface InventoryService {
    InventoryEntity create(InventoryEntity inventory);
    List<InventoryEntity> getAll();
    String checkInventory(String id, int quantity);
}
