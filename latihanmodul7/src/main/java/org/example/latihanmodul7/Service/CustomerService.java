package org.example.latihanmodul7.Service;

import org.example.latihanmodul7.Model.Customer;
import org.example.latihanmodul7.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    // Mengambil semua data customer
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    // Menyimpan atau memperbarui customer
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    // Mengambil customer berdasarkan ID
    public Customer getCustomerById(Long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        return optionalCustomer.orElse(null);
    }
    // Menghapus customer berdasarkan ID
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}


