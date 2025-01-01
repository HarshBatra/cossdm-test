package com.cdac.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cdac.dto.TicketDTO;
import com.cdac.services.TicketServices;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    TicketServices ticketServices;

    @PostMapping("/createTicket")
    public ResponseEntity<TicketDTO> createTicket(@RequestBody TicketDTO ticketDTO) {
        TicketDTO createdTicket = ticketServices.createTicket(ticketDTO);
        return ResponseEntity.status(201).body(createdTicket);
    }

    @PutMapping("updateTicket/{id}")
    public ResponseEntity<TicketDTO> updateTicket(@PathVariable Integer id, @RequestBody TicketDTO ticketDTO) {
        TicketDTO updatedTicket = ticketServices.updateTicket(id, ticketDTO);
        return ResponseEntity.ok(updatedTicket);
    }

    @GetMapping("/fetchOpenTickets")
    public ResponseEntity<List<TicketDTO>> fetchOpenTickets() {
        List<TicketDTO> openTickets = ticketServices.fetchOpenTickets();
        return ResponseEntity.ok(openTickets);
    }

    @GetMapping("/fetchTicketById/{id}")
    public ResponseEntity<TicketDTO> fetchTicketById(@PathVariable Integer id) {
        TicketDTO ticket = ticketServices.fetchTicketById(id);
        return ResponseEntity.ok(ticket);
    }
}
