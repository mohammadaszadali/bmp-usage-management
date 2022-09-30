package com.dtag.bm.usage.management.service.service;

import java.util.List;

import com.dtag.bm.usage.management.service.model.Usage;

public interface UsageManagementService {

	public Usage createUsage(Usage usage);

	public List<Usage> getUsages();

	public Usage getUsageById(String Id);

	public String deleteUsgeById(String Id);
	
	public Usage updateUsge(String Id, Usage usage);

}
