package com.scaler.parking_lot.controllers;

import com.scaler.parking_lot.dtos.GenerateTicketRequestDto;
import com.scaler.parking_lot.dtos.GenerateTicketResponseDto;
import com.scaler.parking_lot.dtos.ResponseStatus;
import com.scaler.parking_lot.models.Ticket;
import com.scaler.parking_lot.services.TicketService;

import java.util.ArrayList;

public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto requestDto) {
        GenerateTicketResponseDto responseDto = new GenerateTicketResponseDto();
        try {
            Ticket ticket = ticketService.generateTicket(requestDto.getGateId(), requestDto.getRegistrationNumber(), requestDto.getVehicleType(), new ArrayList<>());
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
            responseDto.setTicket(ticket);
        } catch (Exception e) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }
}
