package com.example.lims.service;

import com.example.lims.entity.StorageLocation;
import com.example.lims.repository.StorageLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageLocationService {

    @Autowired
    private StorageLocationRepository storageLocationRepository;

    public List<StorageLocation> getAllStorageLocations() {
        return storageLocationRepository.findAll();
    }

    public StorageLocation getStorageLocationById(Long id) {
        return storageLocationRepository.findById(id).orElse(null);
    }

    public StorageLocation saveStorageLocation(StorageLocation storageLocation) {
        return storageLocationRepository.save(storageLocation);
    }

    public void deleteStorageLocation(Long id) {
        storageLocationRepository.deleteById(id);
    }
}
