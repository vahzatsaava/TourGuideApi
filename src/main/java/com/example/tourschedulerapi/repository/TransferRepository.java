package com.example.tourschedulerapi.repository;

import com.example.tourschedulerapi.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransferRepository extends JpaRepository<Transfer, Long> {

    Optional<Transfer> findByEmail(String email);
}
