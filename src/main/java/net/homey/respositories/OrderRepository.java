package net.homey.respositories;

import net.homey.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByStatus(String status);

    // Admin Revenue (Sum of all completed orders)
    @Query("SELECT COALESCE(SUM(o.totalPrice), 0) FROM Order o WHERE o.status = 'COMPLETED'")
    Double getAdminRevenue();

    // Provider Revenue (Sum of completed orders for a specific provider)
    @Query("SELECT COALESCE(SUM(o.totalPrice), 0) FROM Order o WHERE o.status = 'COMPLETED' AND o.providerId = :providerId")
    Double getProviderRevenue(@Param("providerId") Long providerId);

}
