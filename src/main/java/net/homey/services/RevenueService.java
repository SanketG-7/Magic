package net.homey.services;

import net.homey.respositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RevenueService {

    private final OrderRepository orderRepository;

    @Autowired
    public RevenueService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public Double getAdminRevenue() {
        return orderRepository.getAdminRevenue();
    }

    public Double getProviderRevenue(Long providerId) {
        return orderRepository.getProviderRevenue(providerId);
    }
}
