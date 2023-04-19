package com.example.restful.impl;

import com.example.restful.InventoryEntity;
import com.example.restful.InventoryRepository;
import com.example.restful.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;
    @Override
    public InventoryEntity create(InventoryEntity inventory) {
        InventoryEntity inventory1 = new InventoryEntity();
        inventory1.setProductId(inventory.getProductId());
        inventory1.setQuantity(inventory.getQuantity());
        return inventoryRepository.save(inventory1);
    }

    @Override
    public List<InventoryEntity> getAll() {
        return inventoryRepository.findAll();
    }

    @Override
    public String checkInventory(String id, int quantity) {
        InventoryEntity inventory = inventoryRepository.findByProductId(id);
        if (inventory != null) {
            if (inventory.getQuantity() >= quantity) {
                return "available";
            } else {
                return "not available";
            }
        }
        return "product not exist.";
    }
}
