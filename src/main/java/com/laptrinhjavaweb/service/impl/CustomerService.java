package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.builder.CustomerSearchBuilder;
import com.laptrinhjavaweb.converter.CustomerConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.exception.NotFoundException;
import com.laptrinhjavaweb.repository.CustomerRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.security.utils.SecurityUtils;
import com.laptrinhjavaweb.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomerConverter customerConverter;

    @Override
    public List<CustomerDTO> getCustomer(CustomerDTO customerDTO, Pageable pageable) {
        List<CustomerDTO> results = new ArrayList<>();
        Long staffId = null;
        if(SecurityUtils.getAuthorities().contains("ROLE_STAFF")){
            staffId = SecurityUtils.getPrincipal().getId();
        }
        customerDTO.setStaffId(staffId);
        CustomerSearchBuilder customerSearchBuilder = convertToBuildingSearchBuilder(customerDTO);
        List<CustomerEntity> customerEntities = customerRepository.findCustomer(customerSearchBuilder, pageable);
        CustomerDTO customerDTO1 = new CustomerDTO();
        for (CustomerEntity item : customerEntities) {
            customerDTO1 = customerConverter.convertToDto(item);
            List<UserEntity> userEntities = userRepository.findByCustomers_Id(item.getId());
            String staffNames = userEntities.stream().map(UserEntity::getFullName).collect(Collectors.joining(","));
            customerDTO1.setStaffNames(staffNames);
            results.add(customerDTO1);
        }
        return results;
    }

    @Override
    public int getTotalItems(CustomerDTO customerDTO) {
        int totalItem = 0;
        CustomerSearchBuilder buildingSearchBuilder = convertToBuildingSearchBuilder(customerDTO);
        totalItem = (int) customerRepository.countTotalItem(buildingSearchBuilder);
        return totalItem;
    }

    @Override
    public CustomerDTO findCustomerById(Long id) {
        CustomerEntity entity = customerRepository.findById(id).get();
        CustomerDTO customerDTO = customerConverter.convertToDto(entity);
        return customerDTO;
    }

    private CustomerSearchBuilder convertToBuildingSearchBuilder(CustomerDTO customerDTO) {
        CustomerSearchBuilder result = new CustomerSearchBuilder.Builder()
                .setFullName(customerDTO.getFullName())
                .setPhone(customerDTO.getPhone())
                .setEmail(customerDTO.getEmail())
                .setStaffId(customerDTO.getStaffId())
                .build();
        return result;
    }

    @Override
    @Transactional
    public CustomerDTO save(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = customerConverter.convertToEntity(customerDTO);
        return customerConverter.convertToDto(customerRepository.save(customerEntity));
    }

    @Override
    @Transactional
    public void delete(List<Long> customerIds) {
        if (!customerIds.isEmpty()) {
            Long count = customerRepository.countByIdIn(customerIds);

            if (count != customerIds.size()) {
                try {
                    throw new NotFoundException("Customer not found!");
                } catch (NotFoundException e) {
                    e.printStackTrace();
                }
            }
            // remove buildings

            customerRepository.deleteByIdIn(customerIds);
        }
    }

}
