package com.consumer.service;

import com.consumer.entity.AuditPayload;
import com.consumer.entity.EntityAuditLog;
import com.consumer.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumerService {

    private final MessageRepository messageRepository;

    @KafkaListener(topics = "entity.audit", groupId =  "audit-group")
    public void listen(AuditPayload payload) {
        EntityAuditLog auditLog = new EntityAuditLog();
        auditLog.setEntityName(payload.getEntityName());
        auditLog.setEntityId(payload.getEntityId());
        auditLog.setAction(payload.getAction());
        auditLog.setOldValue(payload.getOldValue());
        auditLog.setNewValue(payload.getNewValue());
        auditLog.setChangedBy(payload.getChangedBy());
        auditLog.setTimestamp(payload.getTimestamp());
        
        messageRepository.save(auditLog);
        log.info("Message saved to MongoDB with ID: {}", auditLog.getId());
    }

    @KafkaListener(topics = "patient.audit", groupId =  "audit-group")
    public void patient_listen(AuditPayload payload) {
        EntityAuditLog auditLog = new EntityAuditLog();
        auditLog.setEntityName(payload.getEntityName());
        auditLog.setEntityId(payload.getEntityId());
        auditLog.setAction(payload.getAction());
        auditLog.setOldValue(payload.getOldValue());
        auditLog.setNewValue(payload.getNewValue());
        auditLog.setChangedBy(payload.getChangedBy());
        auditLog.setTimestamp(payload.getTimestamp());

        messageRepository.save(auditLog);
        log.info("Message saved to MongoDB with ID: {}", auditLog.getId());
    }
} 