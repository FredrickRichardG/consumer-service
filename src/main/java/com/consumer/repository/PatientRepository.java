package com.consumer.repository;

import com.consumer.entity.PatientDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface PatientRepository extends ElasticsearchRepository<PatientDocument, String> {
    List<PatientDocument> findByFirstNameContainingOrLastNameContainingOrMedicalRecordNumberContaining(String first, String last, String mr);
}
