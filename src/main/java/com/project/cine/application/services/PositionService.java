package com.project.cine.application.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.cine.domain.models.PositionModel;
import com.project.cine.domain.repositories.PositionRepository;

@Service
public class PositionService {

    private PositionRepository positionRepository;

    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public ArrayList<PositionModel> getAllPositions() {
        return (ArrayList<PositionModel>) positionRepository.findAll();
    }

    public Optional<PositionModel> getById(Long id) {
        return positionRepository.findById(id);
    }

    public PositionModel savePosition(PositionModel position) {
        return positionRepository.save(position);
    }

    public boolean deletePosition(Long id) {
        try {
            positionRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
