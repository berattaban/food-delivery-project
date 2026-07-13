package com.springboot.customerservice.controller;

import com.springboot.customerservice.dto.request.CustomerRequest;
import com.springboot.customerservice.dto.response.CustomerResponse;
import com.springboot.customerservice.service.impl.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerServiceImpl customerService;

    @PostMapping("/save")
    public ResponseEntity<CustomerResponse> createCustomer(@RequestBody CustomerRequest request){
        return ResponseEntity.ok(customerService.createCustomer(request));
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<CustomerResponse>> getAllCustomers(){
        return ResponseEntity.ok(customerService.getAllCustomers());
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
        return ResponseEntity.ok("Müşteri başarıyla silindi!");
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<CustomerResponse> getCustomer(@PathVariable Long id){
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }
}
