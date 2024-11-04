package org.example.restApi;

import org.example.restApi.model.Customer;
import org.example.restApi.model.Orders;
import org.example.restApi.model.Product;
import org.example.restApi.repository.CustomerRepository;
import org.example.restApi.repository.OrderRepository;
import org.example.restApi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import java.util.Arrays;

@SpringBootApplication
public class SpringMvcApplication implements CommandLineRunner {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Product product1 = new Product("Laptop", 1200);
        Product product2 = new Product("Phone", 800);
        productRepository.saveAll(Arrays.asList(product1, product2));

        Customer customer1 = new Customer("John Doe", "john@example.com");
        Customer customer2 = new Customer("Jane Smith", "jane@example.com");
        customerRepository.saveAll(Arrays.asList(customer1, customer2));

        Orders order1 = new Orders(2, customer1, product1);
        Orders order2 = new Orders(1, customer2, product2);
        orderRepository.saveAll(Arrays.asList(order1, order2));
    }

    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }
}



