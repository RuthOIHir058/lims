package com.example.lims.service;

import com.example.lims.entity.MovementLog;
import com.example.lims.repository.MovementLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovementLogService {

    @Autowired
    private MovementLogRepository movementLogRepository;

    public List<MovementLog> getAllMovementLogs() {
        return movementLogRepository.findAll();
    }

    public MovementLog getMovementLogById(Long id) {
        return movementLogRepository.findById(id).orElse(null);
    }

    public MovementLog saveMovementLog(MovementLog movementLog) {
        return movementLogRepository.save(movementLog);
    }

    public void deleteMovementLog(Long id) {
        movementLogRepository.deleteById(id);
    }
}
