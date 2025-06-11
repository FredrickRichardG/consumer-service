package com.consumer.repository;

import com.consumer.entity.EntityAuditLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<EntityAuditLog, String> {
} 