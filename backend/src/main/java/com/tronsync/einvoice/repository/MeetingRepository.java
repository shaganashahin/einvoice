package com.tronsync.einvoice.repository;

import com.tronsync.einvoice.model.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {
}
