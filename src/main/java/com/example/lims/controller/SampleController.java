package com.example.lims.controller;

import com.example.lims.entity.Sample;
import com.example.lims.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/samples")
public class SampleController {

    @Autowired
    private SampleService sampleService;

    @GetMapping
    public String getAllSamples(Model model) {
        List<Sample> samples = sampleService.getAllSamples();
        model.addAttribute("samples", samples);
        return "samples/list";
    }

    @GetMapping("/add")
    public String addSampleForm(Model model) {
        model.addAttribute("sample", new Sample());
        return "samples/add";
    }

    @PostMapping
    public String saveSample(@ModelAttribute Sample sample) {
        sampleService.saveSample(sample);
        return "redirect:/samples";
    }

    @GetMapping("/edit/{id}")
    public String editSampleForm(@PathVariable Long id, Model model) {
        Sample sample = sampleService.getSampleById(id);
        model.addAttribute("sample", sample);
        return "samples/edit";
    }

    @PostMapping("/{id}")
    public String updateSample(@PathVariable Long id, @ModelAttribute Sample sample) {
        sample.setSampleId(id);
        sampleService.saveSample(sample);
        return "redirect:/samples";
    }

    @GetMapping("/delete/{id}")
    public String deleteSample(@PathVariable Long id) {
        sampleService.deleteSample(id);
        return "redirect:/samples";
    }
}
