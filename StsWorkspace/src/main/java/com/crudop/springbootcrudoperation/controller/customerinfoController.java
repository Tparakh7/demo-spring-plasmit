package com.crudop.springbootcrudoperation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudop.springbootcrudoperation.exception.ResourceNotFoundException;
import com.crudop.springbootcrudoperation.model.CustomerInfo;
import com.crudop.springbootcrudoperation.repository.CustomerInfoRepository;

@RestController
@RequestMapping("/api/v1") // To append portions to the request
public class customerinfoController {
    @Autowired
    private CustomerInfoRepository CustomerInfoRepository;

    @GetMapping("/onlinecart") // route url
    public List<CustomerInfo> getAllEmployees() {
        return CustomerInfoRepository.findAll();
    }

    @GetMapping("/onlinecart/{id}") // {id} is dynamic value coming from outside
    public ResponseEntity<CustomerInfo> getEmployeeById(@PathVariable(value = "id") Long employeeId)
        throws ResourceNotFoundException {
        CustomerInfo CustomerInfo = CustomerInfoRepository.findById(employeeId)
          .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
        return ResponseEntity.ok().body(CustomerInfo);
    }
    
    @GetMapping("/onlinecart/name/{name}") // {id} is dynamic value coming from outside
    public ResponseEntity<CustomerInfo> getEmployeeByName(@PathVariable(value = "name") String name)
        throws ResourceNotFoundException {
        CustomerInfo CustomerInfo = CustomerInfoRepository.findByCustomerName(name)
           .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this email :: " + name));
        return ResponseEntity.ok().body(CustomerInfo);
    }
    
    @GetMapping("/onlinecart/contact/{number}") // {id} is dynamic value coming from outside
    public ResponseEntity<CustomerInfo> getEmployeeByNumber(@PathVariable(value = "number") long number)
        throws ResourceNotFoundException {
        CustomerInfo CustomerInfo = CustomerInfoRepository.findByContactNumber(number)
           .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this contact :: " + number));
        return ResponseEntity.ok().body(CustomerInfo);
    }
    
    @PostMapping("/onlinecart")
    public CustomerInfo createEmployee(@Valid @RequestBody CustomerInfo employee) {
        return CustomerInfoRepository.save(employee);
    }

    @PutMapping("/onlinecart/{id}")
    public ResponseEntity<CustomerInfo> updateEmployee(@PathVariable(value = "id") Long employeeId,
         @Valid @RequestBody CustomerInfo employeeDetails) throws ResourceNotFoundException {
        CustomerInfo CustomerInfo = CustomerInfoRepository.findById(employeeId)
        .orElseThrow(() -> new ResourceNotFoundException("CustomerInfo not found for this id :: " + employeeId));

        CustomerInfo.setCustomerName(employeeDetails.getCustomerName());
        CustomerInfo.setCustomerLocation(employeeDetails.getCustomerLocation());
        CustomerInfo.setContactNumber(employeeDetails.getContactNumber());
        CustomerInfo.setPurchasedItem(employeeDetails.getPurchasedItem());
        CustomerInfo.setDeliveryAddress(employeeDetails.getDeliveryAddress());
        final CustomerInfo updatedEmployee = CustomerInfoRepository.save(CustomerInfo);
        
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/onlinecart/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
         throws ResourceNotFoundException {
        CustomerInfo employee = CustomerInfoRepository.findById(employeeId)
       .orElseThrow(() -> new ResourceNotFoundException("CustomerInfo not found for this id :: " + employeeId));

        CustomerInfoRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
