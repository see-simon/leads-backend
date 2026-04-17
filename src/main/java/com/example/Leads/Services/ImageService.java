package com.example.Leads.Services;

import com.example.Leads.Entities.Image;
import com.example.Leads.Repository.ImageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    private  final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Image save(Image image) {
        return imageRepository.save(image);
    }

    public List<Image> getAll() {
        return imageRepository.findAll();
    }
}
