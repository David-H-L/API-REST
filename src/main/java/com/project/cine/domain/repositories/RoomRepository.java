package com.project.cine.domain.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.cine.domain.models.RoomModel;

@Repository
public interface RoomRepository extends CrudRepository<RoomModel, Long> {
}
