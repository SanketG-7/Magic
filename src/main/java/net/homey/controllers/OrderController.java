package net.homey.controllers;



import net.homey.models.Order;
import net.homey.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

    @RestController
    @RequestMapping("/api/orders")
    public class OrderController {
        @Autowired
        private OrderService orderService;

        @PostMapping("/place")
        public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
            Order newOrder = orderService.placeOrder(order);
            return ResponseEntity.ok(newOrder);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Order> getOrder(@PathVariable Long id) {
            Optional<Order> order = orderService.getOrderById(id);
            return order.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }

        @GetMapping("/all")
        public ResponseEntity<List<Order>> getAllOrders() {
            return ResponseEntity.ok(orderService.getAllOrders());
        }

        // @GetMapping("/history")
        // public ResponseEntity<List<Order>> getOrderHistory() {
        //     return ResponseEntity.ok(orderService.getOrderHistory());
        // }
        
@GetMapping("/user/{userId}/active")
public List<Order> getUserActiveOrders(@PathVariable Long userId) {
    return orderService.getUserActiveOrders(userId);
}

// Full order history
@GetMapping("/user/{userId}/history")
public List<Order> getUserOrderHistory(@PathVariable Long userId) {
    return orderService.getUserOrderHistory(userId);
}


        @PutMapping("/update/{id}")
        public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order updatedOrder) {
            Order order = orderService.updateOrder(id, updatedOrder);
            return order != null ? ResponseEntity.ok(order) : ResponseEntity.notFound().build();
        }

        @DeleteMapping("/cancel/{id}")
        public ResponseEntity<String> cancelOrder(@PathVariable Long id) {
            boolean deleted = orderService.cancelOrder(id);
            return deleted ? ResponseEntity.ok("Order canceled successfully") : ResponseEntity.notFound().build();
        }
    }


