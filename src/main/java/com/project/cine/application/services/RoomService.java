package com.project.cine.application.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.cine.domain.models.RoomModel;
import com.project.cine.domain.repositories.RoomRepository;

@Service
public class RoomService {

    private RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public ArrayList<RoomModel> getAllMovies() {
        return (ArrayList<RoomModel>) roomRepository.findAll();
    }

    public Optional<RoomModel> getRoomById(Long id) {
        return roomRepository.findById(id);
    }

    public RoomModel saveRoom(RoomModel room) {
        return roomRepository.save(room);
    }

    public boolean deleteRoom(Long id) {
        try {
            roomRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}