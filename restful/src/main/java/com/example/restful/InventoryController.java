package com.example.restful;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("")
@CrossOrigin("*")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @GetMapping("")
    public String checkInventory(
            @ModelAttribute InventoryEntity inventory) {
        return inventoryService.checkInventory(inventory.getProductId(), inventory.getQuantity());
    }

    @PostMapping("/addProduct")
    public InventoryEntity create(
            @RequestBody InventoryEntity inventory
    ) {
        return inventoryService.create(inventory);
    }

    @GetMapping("/getAll")
    public List<InventoryEntity> getAll() {
        return inventoryService.getAll();
    }

}
