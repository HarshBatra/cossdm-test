package com.cdac.services;

import java.util.List;
import com.cdac.dto.TicketDTO;

public interface TicketServices {
    TicketDTO createTicket(TicketDTO ticketDTO);
    TicketDTO updateTicket(Integer id, TicketDTO ticketDTO);
    List<TicketDTO> fetchOpenTickets();
    TicketDTO fetchTicketById(Integer id);
}
