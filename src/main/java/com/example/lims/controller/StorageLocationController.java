package com.example.lims.controller;

import com.example.lims.entity.StorageLocation;
import com.example.lims.service.StorageLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/storagelocations")
public class StorageLocationController {

    @Autowired
    private StorageLocationService storageLocationService;

    @GetMapping
    public String getAllStorageLocations(Model model) {
        List<StorageLocation> storageLocations = storageLocationService.getAllStorageLocations();
        model.addAttribute("storageLocations", storageLocations);
        return "storagelocations/list";
    }

    @GetMapping("/add")
    public String addStorageLocationForm(Model model) {
        model.addAttribute("storageLocation", new StorageLocation());
        return "storagelocations/add";
    }

    @PostMapping
    public String saveStorageLocation(@ModelAttribute StorageLocation storageLocation) {
        storageLocationService.saveStorageLocation(storageLocation);
        return "redirect:/storagelocations";
    }

    @GetMapping("/edit/{id}")
    public String editStorageLocationForm(@PathVariable Long id, Model model) {
        StorageLocation storageLocation = storageLocationService.getStorageLocationById(id);
        model.addAttribute("storageLocation", storageLocation);
        return "storagelocations/edit";
    }

    @PostMapping("/{id}")
    public String updateStorageLocation(@PathVariable Long id, @ModelAttribute StorageLocation storageLocation) {
        storageLocation.setStorageLocationId(id);
        storageLocationService.saveStorageLocation(storageLocation);
        return "redirect:/storagelocations";
    }

    @GetMapping("/delete/{id}")
    public String deleteStorageLocation(@PathVariable Long id) {
        storageLocationService.deleteStorageLocation(id);
        return "redirect:/storagelocations";
    }
}
