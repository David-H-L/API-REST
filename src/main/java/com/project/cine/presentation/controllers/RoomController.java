package com.project.cine.presentation.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.project.cine.application.services.RoomService;
import com.project.cine.domain.models.RoomModel;

@RestController
@RequestMapping("room")
public class RoomController {

    private RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public ArrayList<RoomModel> getAllRoom() {
        return roomService.getAllRoom();
    }

    @PostMapping
    public RoomModel saveRoom(@RequestBody RoomModel room) {
        return roomService.saveRoom(room);
    }

    @GetMapping(path = "/{id}")
    public Optional<RoomModel> getRoomById(@PathVariable("id") Long id) {
        return roomService.getRoomById(id);
    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteRoom(@PathVariable("id") Long id) {
        return roomService.deleteRoom(id);
    }
}