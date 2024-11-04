package org.example.restApi.controller;

import org.example.restApi.model.Customer;
import org.example.restApi.model.Orders;
import org.example.restApi.repository.CustomerRepository;
import org.example.restApi.repository.OrderRepository;
import org.example.restApi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/orders")
    public String listOrders(Model model) {
        List<Orders> orders = orderRepository.findAll();
        model.addAttribute("orders", orders);
        return "order_list";
    }

    @GetMapping("/order/new")
    public String showOrderForm(Model model) {
        model.addAttribute("order", new Orders());
        model.addAttribute("customers", customerRepository.findAll());
        model.addAttribute("products", productRepository.findAll());
        return "order_form";
    }

    @PostMapping("/order/save")
    public String saveOrder(@ModelAttribute Orders order) {
        orderRepository.save(order);
        return "redirect:/orders";
    }
    @PutMapping("/order/update/{id}")
    public String updateOrder(@PathVariable("id") Long id, @ModelAttribute Orders updatedOrder) {
        Optional<Orders> orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()) {
            Orders existingOrder = orderOptional.get();
            existingOrder.setCustomer(updatedOrder.getCustomer());
            existingOrder.setProduct(updatedOrder.getProduct());
            existingOrder.setQuantity(updatedOrder.getQuantity());
            orderRepository.save(existingOrder);
        }
        return "redirect:/orders";
    }

    @DeleteMapping("/order/delete/{id}")
    public String deleteOrder(@PathVariable("id") Long id) {
        orderRepository.deleteById(id);
        return "redirect:/orders";
    }
}
