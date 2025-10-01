package com.project.cine.presentation.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.project.cine.application.services.ImageService;
import com.project.cine.domain.models.ImageModel;

@RestController
@RequestMapping("/image")
public class ImageController {

    private ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping
    public ArrayList<ImageModel> getAllImages() {
        return imageService.getAllImages();
    }

    @PostMapping
    public ImageModel saveImage(@RequestBody ImageModel imageModel) {
        return imageService.saveImage(imageModel);
    }

    @GetMapping(path = "/{id}")
    public Optional<ImageModel> getImageById(@PathVariable("id") Long id) {
        return imageService.getImageById(id);
    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteImage(@PathVariable("id") Long id) {
        return imageService.deleteImage(id);
    }
}