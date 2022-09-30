package com.dtag.bm.usage.management.service.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dtag.bm.usage.management.service.model.Usage;

@Repository
public interface UsageManagementDAO extends MongoRepository<Usage, String> {
	
}