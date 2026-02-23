package com.tronsync.einvoice.dto;

import com.tronsync.einvoice.model.AgreementType;
import jakarta.validation.constraints.NotNull;

public record CreateAgreementRequest(
        @NotNull AgreementType type
) {
}
