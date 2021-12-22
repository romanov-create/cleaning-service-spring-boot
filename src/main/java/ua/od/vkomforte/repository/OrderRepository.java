package ua.od.vkomforte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.od.vkomforte.domain.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByName(String Name);
}
