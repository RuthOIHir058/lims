package com.example.lims.repository;

import com.example.lims.entity.MovementLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementLogRepository extends JpaRepository<MovementLog, Long> {
}
