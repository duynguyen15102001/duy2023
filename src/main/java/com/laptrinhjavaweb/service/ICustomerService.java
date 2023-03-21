package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.CustomerDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    List<CustomerDTO> getCustomer(CustomerDTO customerDTO, Pageable pageable);
    int getTotalItems(CustomerDTO customerDTO);
    CustomerDTO findCustomerById(Long id);
    CustomerDTO save(CustomerDTO customerDTO);
    void delete(List<Long> customerIds);
}
