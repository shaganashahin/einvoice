package com.tronsync.einvoice.controller;

import com.tronsync.einvoice.dto.CreateAgreementRequest;
import com.tronsync.einvoice.dto.CreateMeetingRequest;
import com.tronsync.einvoice.model.Agreement;
import com.tronsync.einvoice.model.Customer;
import com.tronsync.einvoice.model.Meeting;
import com.tronsync.einvoice.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Value("${app.base-url:http://localhost:5173}")
    private String appBaseUrl;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping
    public Customer createCustomer(@Valid @RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @PostMapping("/{customerId}/meetings")
    public Meeting scheduleMeeting(@PathVariable Long customerId, @Valid @RequestBody CreateMeetingRequest request) {
        return customerService.scheduleMeeting(customerId, request);
    }

    @PostMapping("/{customerId}/agreements")
    public Agreement sendAgreement(@PathVariable Long customerId, @Valid @RequestBody CreateAgreementRequest request) {
        return customerService.sendAgreement(customerId, request, appBaseUrl);
    }
}
