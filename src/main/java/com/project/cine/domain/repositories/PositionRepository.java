package com.project.cine.domain.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.cine.domain.models.PositionModel;

@Repository
public interface PositionRepository extends CrudRepository<PositionModel, Long> {
}
