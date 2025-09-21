package com.project.cine.application.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.cine.domain.models.TicketModel;
import com.project.cine.domain.repositories.TicketRepository;

@Service
public class TicketService {

    private TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public ArrayList<TicketModel> getAllTickets() {
        return (ArrayList<TicketModel>) ticketRepository.findAll();
    }

    public Optional<TicketModel> getTicketById(Long id) {
        return ticketRepository.findById(id);
    }

    public TicketModel saveTicket(TicketModel ticket) {
        return ticketRepository.save(ticket);
    }

    public boolean deleteTicket(Long id) {
        try {
            ticketRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}