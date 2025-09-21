package com.project.cine.application.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.cine.domain.models.ImageModel;
import com.project.cine.domain.repositories.ImageRepository;

@Service
public class ImageService {

    private ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public ArrayList<ImageModel> getAllImages() {
        return (ArrayList<ImageModel>) imageRepository.findAll();
    }

    public Optional<ImageModel> getImageById(Long id) {
        return imageRepository.findById(id);
    }

    public ImageModel saveImage(ImageModel image) {
        return imageRepository.save(image);
    }

    public boolean deleteImage(Long id) {
        try {
            imageRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}