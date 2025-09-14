package com.project.cine.domain.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.cine.domain.models.TicketModel;

@Repository
public interface TicketRepository extends CrudRepository<TicketModel, Long> {
}