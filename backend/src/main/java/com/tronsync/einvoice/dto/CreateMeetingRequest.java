package com.tronsync.einvoice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CreateMeetingRequest(
        @NotNull LocalDateTime scheduledAt,
        @NotBlank String agenda
) {
}
