package com.example.restful;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
@Entity
@Table(name = "inventory")
public class InventoryEntity {

    @Id
    @Column(name = "product_id")
    private String productId;
    private int quantity;
}
