package com.example.lims.controller;

import com.example.lims.entity.MovementLog;
import com.example.lims.service.MovementLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/movementlogs")
public class MovementLogController {

    @Autowired
    private MovementLogService movementLogService;

    @GetMapping
    public String getAllMovementLogs(Model model) {
        List<MovementLog> movementLogs = movementLogService.getAllMovementLogs();
        model.addAttribute("movementLogs", movementLogs);
        return "movementlogs/list";
    }

    @GetMapping("/add")
    public String addMovementLogForm(Model model) {
        model.addAttribute("movementLog", new MovementLog());
        return "movementlogs/add";
    }

    @PostMapping
    public String saveMovementLog(@ModelAttribute MovementLog movementLog) {
        movementLogService.saveMovementLog(movementLog);
        return "redirect:/movementlogs";
    }

    @GetMapping("/edit/{id}")
    public String editMovementLogForm(@PathVariable Long id, Model model) {
        MovementLog movementLog = movementLogService.getMovementLogById(id);
        model.addAttribute("movementLog", movementLog);
        return "movementlogs/edit";
    }

    @PostMapping("/{id}")
    public String updateMovementLog(@PathVariable Long id, @ModelAttribute MovementLog movementLog) {
        movementLog.setLogId(id);
        movementLogService.saveMovementLog(movementLog);
        return "redirect:/movementlogs";
    }

    @GetMapping("/delete/{id}")
    public String deleteMovementLog(@PathVariable Long id) {
        movementLogService.deleteMovementLog(id);
        return "redirect:/movementlogs";
    }
}
