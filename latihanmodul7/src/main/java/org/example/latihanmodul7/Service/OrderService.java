package org.example.latihanmodul7.Service;

import org.example.latihanmodul7.Model.Order;
import org.example.latihanmodul7.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    // Mengambil semua data order
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }
    // Menyimpan atau memperbarui order
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }
    // Mengambil order berdasarkan ID
    public Order getOrderById(Long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        return optionalOrder.orElse(null);
    }
    // Menghapus order berdasarkan ID
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}

