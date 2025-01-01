package com.cdac.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dto.TicketDTO;
import com.cdac.entity.Ticket;
import com.cdac.entity.Ticket.Status;
import com.cdac.repositories.TicketRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketServicesImpl implements TicketServices {

    @Autowired
    private TicketRepository ticketRepo;

    @Override
    public TicketDTO createTicket(TicketDTO ticketDTO) {
        Ticket ticket = new Ticket();
        ticket.setPhoneNumber(ticketDTO.getPhoneNumber());
        ticket.setCategory(ticketDTO.getCategory());
        ticket.setIssueDetails(ticketDTO.getIssueDetails());
        ticket.setStatus(Status.OPEN);
        ticket.setCreateDateTime(LocalDateTime.now());

        Ticket savedTicket = ticketRepo.save(ticket);
        return mapToDTO(savedTicket);
    }

    @Override
    public TicketDTO updateTicket(Integer id, TicketDTO ticketDTO) {
        Ticket ticket = ticketRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found with ID: " + id));

        ticket.setStatus(ticketDTO.getStatus());
        ticket.setResolutionDetails(ticketDTO.getResolutionDetails());
        ticket.setResolutionDateTime(ticketDTO.getResolutionDateTime());

        Ticket updatedTicket = ticketRepo.save(ticket);
        return mapToDTO(updatedTicket);
    }

    @Override
    public List<TicketDTO> fetchOpenTickets() {
        List<Ticket> openTickets = ticketRepo.findByStatus(Status.OPEN);
        return openTickets.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public TicketDTO fetchTicketById(Integer id) {
        Ticket ticket = ticketRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found with ID: " + id));
        return mapToDTO(ticket);
    }

    private TicketDTO mapToDTO(Ticket ticket) {
        TicketDTO dto = new TicketDTO();
        dto.setId(ticket.getId());
        dto.setPhoneNumber(ticket.getPhoneNumber());
        dto.setCategory(ticket.getCategory());
        dto.setIssueDetails(ticket.getIssueDetails());
        dto.setResolutionDetails(ticket.getResolutionDetails());
        dto.setStatus(ticket.getStatus());
        dto.setCreateDateTime(ticket.getCreateDateTime());
        dto.setResolutionDateTime(ticket.getResolutionDateTime());
        return dto;
    }
}
