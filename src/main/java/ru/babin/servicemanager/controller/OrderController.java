package ru.babin.servicemanager.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.babin.servicemanager.model.Order;
import ru.babin.servicemanager.service.OrderService;

@Controller
@RequestMapping("/services/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public String getAllOrders(Model model) {
        model.addAttribute("orders", orderService.getAllOrder());
        return "orders";
    }

    @GetMapping("/new")
    public String createNewOrderForm(Model model) {
        Order order = new Order();
        model.addAttribute("order", order);
        return "new_order";
    }

    @PostMapping
    public String saveOrder(@ModelAttribute("order") Order order) {
        orderService.saveOrder(order);
        return "redirect:/services/orders";
    }
}
