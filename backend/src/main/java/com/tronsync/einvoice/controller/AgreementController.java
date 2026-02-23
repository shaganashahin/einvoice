package com.tronsync.einvoice.controller;

import com.tronsync.einvoice.model.Agreement;
import com.tronsync.einvoice.service.CustomerService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/agreements")
public class AgreementController {

    private final CustomerService customerService;

    public AgreementController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/sign/{token}")
    public Agreement signAgreement(@PathVariable String token) {
        return customerService.signAgreement(token);
    }
}
