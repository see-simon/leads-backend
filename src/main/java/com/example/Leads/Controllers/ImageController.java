package com.example.Leads.Controllers;
import com.example.Leads.Entities.Image;
import com.example.Leads.Services.ImageService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ImageController {
    private final ImageService service;

    public ImageController(ImageService service) {
        this.service = service;
    }

//    @PostMapping("/upload")
//    public String upload(@RequestParam("file") MultipartFile file) {
//        try {
//            Image image = new Image();
//            image.setName(file.getOriginalFilename());
//            image.setType(file.getContentType());
//            image.setData(file.getBytes());
//            service.save(image);
//            return "File uploaded successfully: " + file.getOriginalFilename();
//        } catch (Exception e) {
//            return "Failed to upload file: " + e.getMessage();
//        }
//    }

    @GetMapping("/images/getAll")
    public List<Image> getAll() {
        return service.getAll();
    }

}
