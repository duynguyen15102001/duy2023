package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.entity.CustomerEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter {
    @Autowired
    private ModelMapper modelMapper;
    public CustomerDTO convertToDto(CustomerEntity customerEntity) {
        CustomerDTO result = modelMapper.map(customerEntity, CustomerDTO.class);
        if(customerEntity.getCreatedBy() == null && customerEntity.getCreatedDate() == null){
            result.setCreatedBy(customerEntity.getModifiedBy());
            result.setCreatedDate(customerEntity.getModifiedDate());
        }
        return result;
    }

    public CustomerEntity convertToEntity(CustomerDTO dto) {
        /*String type = String.join(",", dto.getType());*/

        CustomerEntity result = modelMapper.map(dto, CustomerEntity.class);


        return result;
    }
}
