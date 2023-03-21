package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.input.AssignmentCustomerAssignInput;

public interface IAssignmentCustomerService {
    CustomerDTO customerDelivery(AssignmentCustomerAssignInput assignmentCustomerAssignInput);
}
