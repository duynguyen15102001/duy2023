package com.laptrinhjavaweb.api.admin;


import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.input.AssignmentCustomerAssignInput;
import com.laptrinhjavaweb.service.IAssignmentCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/assignmentcustomer")
public class AssignmnetCustomerAPI {
    @Autowired
    private IAssignmentCustomerService assignmentCustomerService;

    @PostMapping()
    public ResponseEntity<CustomerDTO> assignStaffManageBuilding(@RequestBody AssignmentCustomerAssignInput assignmentCustomerAssignInput) {

        return ResponseEntity.ok(assignmentCustomerService.customerDelivery(assignmentCustomerAssignInput));

    }
}
