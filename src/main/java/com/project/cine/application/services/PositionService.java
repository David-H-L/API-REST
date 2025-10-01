package com.project.cine.application.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.cine.application.dto.PositionDto;
import com.project.cine.domain.models.PositionModel;
import com.project.cine.domain.repositories.PositionRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PositionService {

    private PositionRepository positionRepository;

    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public ArrayList<PositionDto> getAllPositions() {
        ArrayList<PositionModel> AllPositions = (ArrayList<PositionModel>) positionRepository.findAll();
        ArrayList<PositionDto> positionDto = new ArrayList<>();
        for (PositionModel position : AllPositions) {
            positionDto.add(new PositionDto(position.getIdPosition(), position.getName(), position.getDescription()));
        }
        return positionDto;
    }

    public PositionDto getPositionById(Long id) {
        Optional<PositionModel> position = positionRepository.findById(id);
        if (position.isEmpty()) {
            throw new EntityNotFoundException("Position not found with id: " + id);
        }

        PositionModel positionDto = position.get();
        return new PositionDto(positionDto.getIdPosition(), positionDto.getName(), positionDto.getDescription());

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
