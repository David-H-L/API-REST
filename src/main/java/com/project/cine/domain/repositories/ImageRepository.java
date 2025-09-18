package com.project.cine.domain.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.cine.domain.models.ImageModel;

@Repository
public interface ImageRepository extends CrudRepository<ImageModel, Long> {
}
