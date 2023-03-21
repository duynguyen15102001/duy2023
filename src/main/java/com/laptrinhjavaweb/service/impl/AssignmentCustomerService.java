package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.CustomerConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.input.AssignmentCustomerAssignInput;
import com.laptrinhjavaweb.repository.CustomerRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.IAssignmentCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AssignmentCustomerService implements IAssignmentCustomerService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomerConverter customerConverter;

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    @Transactional
    public CustomerDTO customerDelivery(AssignmentCustomerAssignInput assignmentCustomerAssignInput) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(assignmentCustomerAssignInput.getCustomerId());

        List<Long> inputStaff = assignmentCustomerAssignInput.getStaffId();

        List<UserEntity> userEntity = userRepository.findAllById(inputStaff);

        customerEntity.setUsers(userEntity);

        return customerConverter.convertToDto(customerRepository.save(customerEntity));
    }
}
