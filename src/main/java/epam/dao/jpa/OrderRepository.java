package epam.dao.jpa;

import epam.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    ArrayList findAll();
}
