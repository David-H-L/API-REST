package com.project.cine.presentation.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.project.cine.application.services.TicketService;
import com.project.cine.domain.models.TicketModel;

@RestController
@RequestMapping("/ticket")
public class ticketController {

    private TicketService ticketService;

    public ticketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public ArrayList<TicketModel> getAllTicket() {
        return ticketService.getAllTickets();
    }

    @PostMapping
    public TicketModel saveTicket(@RequestBody TicketModel ticket) {
        return ticketService.saveTicket(ticket);
    }

    @GetMapping(path = "/{id}")
    public Optional<TicketModel> getTicketById(@PathVariable("id") Long id) {
        return ticketService.getTicketById(id);
    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteTicket(@PathVariable("id") Long id) {
        return ticketService.deleteTicket(id);
    }
}