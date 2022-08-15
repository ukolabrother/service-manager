package ru.babin.servicemanager.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.babin.servicemanager.model.Order;
import ru.babin.servicemanager.repository.OrderRepository;

import java.util.Collection;

@AllArgsConstructor
@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public Collection<Order> getAllOrder() {
        return orderRepository.findAll();

    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }
}
