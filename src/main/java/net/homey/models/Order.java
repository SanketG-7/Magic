package net.homey.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    @Column(name = "food_item")
    private String foodItem;

    private int quantity;

    private String status;

    private Double totalPrice;

    private Long providerId;

    public Order() {}

    public Order(String foodItem, int quantity, String status, Double totalPrice, Long providerId) {
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.status = status;
        this.totalPrice = totalPrice;
        this.providerId = providerId;
    }
}
