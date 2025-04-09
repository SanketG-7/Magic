package net.homey.controllers;

import net.homey.services.RevenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/revenue")
public class RevenueController {

    private final RevenueService revenueService;

    @Autowired
    public RevenueController(RevenueService revenueService) {
        this.revenueService = revenueService;
    }

    /**
     * API for Admin to get total revenue
     * URL: /api/revenue/admin
     */
    @GetMapping("/admin")
    public RevenueResponse getAdminRevenue() {
        Double revenue = revenueService.getAdminRevenue();
        return new RevenueResponse(revenue);
    }

    /**
     * API for Provider to get their revenue
     * URL: /api/revenue/provider/{providerId}
     */
    @GetMapping("/provider/{providerId}")
    public RevenueResponse getProviderRevenue(@PathVariable Long providerId) {
        Double revenue = revenueService.getProviderRevenue(providerId);
        return new RevenueResponse(revenue);
    }

    // Inner class to wrap revenue nicely in JSON
    public static class RevenueResponse {
        private Double revenue;

        public RevenueResponse(Double revenue) {
            this.revenue = revenue;
        }

        public Double getRevenue() {
            return revenue;
        }

        public void setRevenue(Double revenue) {
            this.revenue = revenue;
        }
    }
}
