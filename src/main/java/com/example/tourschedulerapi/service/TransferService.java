package com.example.tourschedulerapi.service;

import com.example.tourschedulerapi.entity.Transfer;
import com.example.tourschedulerapi.map.TransferMapper;
import com.example.tourschedulerapi.model.TransferModel;
import com.example.tourschedulerapi.model.TransferRequest;
import com.example.tourschedulerapi.repository.TransferRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransferService {
    private final TransferRepository transferRepository;
    private final TransferMapper transferMapper;
    private final EmailService notification;

    public TransferModel getTransfer(String email) {
        Transfer transfer = transferRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("transfer not found"));
        return transferMapper.toTransferModel(transfer);
    }

    @Transactional
    public TransferModel createTransfer(TransferRequest transferRequest) {
        Transfer transfer = transferMapper.toTransferFromRecord(transferRequest);
        transferRepository.save(transfer);
        String notificationMsg = String.format("transfer accepted from user %s airport %s data %s count people %s msg %s destination city %s "
                , transfer.getEmail(), transfer.getFromAirport(), transfer.getDate(), transfer.getPassengerCount(), transfer.getMessage(), transfer.getDestinationCity());
        notification.sendNotification(notificationMsg);
        return transferMapper.toTransferModel(transfer);
    }
}
