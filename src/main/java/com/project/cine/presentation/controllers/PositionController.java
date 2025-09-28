package com.project.cine.presentation.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.project.cine.application.services.PositionService;
import com.project.cine.domain.models.PositionModel;

@RestController
@RequestMapping("/position")
public class PositionController {

    private PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping
    public ArrayList<PositionModel> getAllPosition() {
        return positionService.getAllPositions();
    }

    @PostMapping
    public PositionModel savePosition(@RequestBody PositionModel position) {
        return positionService.savePosition(position);
    }

    @GetMapping(path = "/{id}")
    public Optional<PositionModel> getPositionById(@PathVariable("id") Long id) {
        return positionService.getPositionById(id);
    }

    @DeleteMapping(path = "/{id}")
    public boolean deletePosition(@PathVariable("id") Long id) {
        return positionService.deletePosition(id);
    }
}
