package com.dtag.bm.usage.management.service.service;

import com.dtag.bm.usage.management.service.model.UsageSpecificationReq;

public interface UsageSpecificationService {
	
	public UsageSpecificationReq createUsageSpecification(UsageSpecificationReq usageSpecReq);

	public UsageSpecificationReq getUsageSpecificationById(String Id);

	public void deleteUsgespecById(String Id);
}
