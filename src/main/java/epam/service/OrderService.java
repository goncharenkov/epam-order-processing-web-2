package epam.service;

import epam.dao.jpa.OrderRepository;
import epam.domain.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrderService {
    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderRepository orderRepository;

    public OrderService() {
    }

    public Order createOrder(Order order) {
        log.info("creating order - " + order.getName());
        return orderRepository.save(order);
    }

    public Order updateOrder(Order order) {
        log.info("updating order - " + order.getName());
        return orderRepository.save(order);
    }

    public Order getOrder(int id) {
        log.info("getting order by id - " + id);
        return orderRepository.findOne(id);
    }

    public void deleteOrder(int id) {
        log.info("deleting order by id - " + id);
        orderRepository.delete(id);
    }

    public ArrayList<Order> getAllOrders() {
        ArrayList pageOfOrders = orderRepository.findAll();
        return pageOfOrders;
    }
}
