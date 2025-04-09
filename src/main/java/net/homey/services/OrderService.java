package net.homey.services;

import net.homey.models.Order;
import net.homey.respositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order placeOrder(Order order) {
        order.setStatus("Placed");
        return orderRepository.save(order);
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<Order> getOrderHistory() {
        return orderRepository.findByStatus("Completed");
    }

    public Order updateOrder(Long id, Order updatedOrder) {
        return orderRepository.findById(id).map(order -> {
            order.setFoodItem(updatedOrder.getFoodItem());
            order.setQuantity(updatedOrder.getQuantity());
            return orderRepository.save(order);
        }).orElse(null);
    }

    public boolean cancelOrder(Long id) {
        return orderRepository.findById(id).map(order -> {
            orderRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}
