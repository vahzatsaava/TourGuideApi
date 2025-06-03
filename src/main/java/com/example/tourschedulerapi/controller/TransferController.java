package com.example.tourschedulerapi.controller;

import com.example.tourschedulerapi.model.TransferModel;
import com.example.tourschedulerapi.model.TransferRequest;
import com.example.tourschedulerapi.service.TransferService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/transfers")
public class TransferController {
    private final TransferService transferService;

    @PostMapping
    public TransferModel createTransfer(@Valid @RequestBody TransferRequest transferRequest) {
        return transferService.createTransfer(transferRequest);
    }

    @GetMapping("/{email}")
    public TransferModel getTransfer(@PathVariable String email) {
        return transferService.getTransfer(email);
    }
}
