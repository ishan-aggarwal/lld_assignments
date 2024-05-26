package com.scaler.parking_lot.respositories;

import com.scaler.parking_lot.models.Ticket;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class TicketRepositoryImpl implements TicketRepository {
    // Do not modify the method signature, feel free to add new methods

    private Map<Long, Ticket> hm = new HashMap<>();

    public Ticket save(Ticket ticket) {
        return hm.put(ticket.getId(), ticket);
    }

    public Optional<Ticket> getTicketById(long ticketId) {

        return Optional.ofNullable(hm.get(ticketId));

    }

}
