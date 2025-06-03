package com.example.tourschedulerapi.map;

import com.example.tourschedulerapi.entity.Transfer;
import com.example.tourschedulerapi.model.TransferModel;
import com.example.tourschedulerapi.model.TransferRequest;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransferMapper {

    TransferModel toTransferModel(Transfer transfer);

    @InheritInverseConfiguration
    Transfer toTransfer(TransferModel transferModel);

    Transfer toTransferFromRecord(TransferRequest transferRequest);
}
