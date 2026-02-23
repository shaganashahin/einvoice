package com.tronsync.einvoice.repository;

import com.tronsync.einvoice.model.Agreement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AgreementRepository extends JpaRepository<Agreement, Long> {
    Optional<Agreement> findBySigningToken(String signingToken);
}
