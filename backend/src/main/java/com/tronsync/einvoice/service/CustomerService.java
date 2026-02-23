package com.tronsync.einvoice.service;

import com.tronsync.einvoice.dto.CreateAgreementRequest;
import com.tronsync.einvoice.dto.CreateMeetingRequest;
import com.tronsync.einvoice.model.*;
import com.tronsync.einvoice.repository.AgreementRepository;
import com.tronsync.einvoice.repository.CustomerRepository;
import com.tronsync.einvoice.repository.MeetingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final MeetingRepository meetingRepository;
    private final AgreementRepository agreementRepository;

    public CustomerService(CustomerRepository customerRepository,
                           MeetingRepository meetingRepository,
                           AgreementRepository agreementRepository) {
        this.customerRepository = customerRepository;
        this.meetingRepository = meetingRepository;
        this.agreementRepository = agreementRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Transactional
    public Meeting scheduleMeeting(Long customerId, CreateMeetingRequest request) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));

        Meeting meeting = new Meeting();
        meeting.setCustomer(customer);
        meeting.setScheduledAt(request.scheduledAt());
        meeting.setAgenda(request.agenda());
        return meetingRepository.save(meeting);
    }

    @Transactional
    public Agreement sendAgreement(Long customerId, CreateAgreementRequest request, String appBaseUrl) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));

        String token = UUID.randomUUID().toString();
        Agreement agreement = new Agreement();
        agreement.setCustomer(customer);
        agreement.setType(request.type());
        agreement.setStatus(AgreementStatus.PENDING_SIGNATURE);
        agreement.setSigningToken(token);
        agreement.setSigningLink(appBaseUrl + "/sign/" + token);
        agreement.setSentAt(LocalDateTime.now());
        return agreementRepository.save(agreement);
    }

    @Transactional
    public Agreement signAgreement(String token) {
        Agreement agreement = agreementRepository.findBySigningToken(token)
                .orElseThrow(() -> new IllegalArgumentException("Agreement token not found"));
        agreement.setStatus(AgreementStatus.SIGNED);
        agreement.setSignedAt(LocalDateTime.now());
        return agreementRepository.save(agreement);
    }
}
