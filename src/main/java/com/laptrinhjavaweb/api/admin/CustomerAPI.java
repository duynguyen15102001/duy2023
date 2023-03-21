package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.response.ResponseDTO;
import com.laptrinhjavaweb.response.StaffReponse;
import com.laptrinhjavaweb.service.impl.CustomerService;
import com.laptrinhjavaweb.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerAPI {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<CustomerDTO> createBuilding(@RequestBody CustomerDTO newCustomer) {
        return ResponseEntity.ok(customerService.save(newCustomer));

    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateBuilding(@PathVariable("id") long id, @RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerService.save(customerDTO));
    }

    @DeleteMapping
    public ResponseEntity<List<Long>> removeBuildings(@RequestBody List<Long> customerIds) {
        customerService.delete(customerIds);
        ResponseEntity<List<Long>> response = ResponseEntity.ok(customerIds);

        return response;
    }

    @GetMapping("/{customerId}/staffs")
    public ResponseDTO loadStaff(@PathVariable("customerId") Long customerId) {
        ResponseDTO results = new ResponseDTO();
        Long id = customerId;
        List<StaffReponse> staffs = userService.findAllCustomerManagementStaff(customerId);
        results.setMessage("success");
        results.setData(staffs);
        return results;
    }


}
