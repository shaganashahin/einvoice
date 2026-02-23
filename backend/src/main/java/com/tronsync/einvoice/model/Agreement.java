package com.tronsync.einvoice.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "agreements")
public class Agreement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private AgreementType type;

    @Enumerated(EnumType.STRING)
    private AgreementStatus status;

    @Column(unique = true)
    private String signingToken;

    @Column(unique = true)
    private String signingLink;

    private LocalDateTime sentAt;
    private LocalDateTime signedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public AgreementType getType() { return type; }
    public void setType(AgreementType type) { this.type = type; }
    public AgreementStatus getStatus() { return status; }
    public void setStatus(AgreementStatus status) { this.status = status; }
    public String getSigningToken() { return signingToken; }
    public void setSigningToken(String signingToken) { this.signingToken = signingToken; }
    public String getSigningLink() { return signingLink; }
    public void setSigningLink(String signingLink) { this.signingLink = signingLink; }
    public LocalDateTime getSentAt() { return sentAt; }
    public void setSentAt(LocalDateTime sentAt) { this.sentAt = sentAt; }
    public LocalDateTime getSignedAt() { return signedAt; }
    public void setSignedAt(LocalDateTime signedAt) { this.signedAt = signedAt; }
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
}
