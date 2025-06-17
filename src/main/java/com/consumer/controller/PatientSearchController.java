package com.consumer.controller;

import com.consumer.entity.PatientDocument;
import com.consumer.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/search")
public class PatientSearchController {

    private final PatientRepository repository;

    @GetMapping
    public List<PatientDocument> search(@RequestParam String query) {
        return repository.findByFirstNameContainingOrLastNameContainingOrMedicalRecordNumberContaining(query, query, query);
    }
}