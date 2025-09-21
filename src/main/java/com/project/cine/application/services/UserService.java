package com.project.cine.application.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.cine.application.dto.UserDto;
import com.project.cine.domain.models.UserModel;
import com.project.cine.domain.repositories.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ArrayList<UserDto> getAllUsers() {

        ArrayList<UserModel> AllUsers = (ArrayList<UserModel>) userRepository.findAll();
        ArrayList<UserDto> userDtos = new ArrayList<>();

        for (UserModel user : AllUsers) {
            userDtos.add(new UserDto(user.getName(), user.getAge(), user.getEmail()));
        }

        return userDtos;
    }

    public UserModel saveUser(UserModel user) {
        return userRepository.save(user);
    }

    public UserDto getUserById(Long id) {
        Optional<UserModel> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new EntityNotFoundException("User not found with id: " + id);
        }
        UserModel userDB = user.get();
        return new UserDto(userDB.getName(), userDB.getAge(), userDB.getEmail());
    }

    public boolean deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
