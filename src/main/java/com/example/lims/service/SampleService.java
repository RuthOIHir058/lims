package com.example.lims.service;

import com.example.lims.entity.Sample;
import com.example.lims.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SampleService {

    @Autowired
    private SampleRepository sampleRepository;

    public List<Sample> getAllSamples() {
        return sampleRepository.findAll();
    }

    public Sample getSampleById(Long id) {
        return sampleRepository.findById(id).orElse(null);
    }

    public Sample saveSample(Sample sample) {
        return sampleRepository.save(sample);
    }

    public void deleteSample(Long id) {
        sampleRepository.deleteById(id);
    }
}
