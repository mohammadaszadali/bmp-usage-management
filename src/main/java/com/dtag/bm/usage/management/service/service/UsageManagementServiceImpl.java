package com.dtag.bm.usage.management.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtag.bm.usage.management.service.dao.UsageManagementDAO;
import com.dtag.bm.usage.management.service.model.Usage;

@Service
public class UsageManagementServiceImpl implements UsageManagementService {

	@Autowired
	UsageManagementDAO dao;

	@Override
	public Usage createUsage(Usage usage) {
		return dao.insert(usage);
	}

	@Override
	public List<Usage> getUsages() {
		return dao.findAll();

	}

	@Override
	public Usage getUsageById(String Id) {
		return dao.findOne(Id);
	}

	@Override
	public String deleteUsgeById(String Id) {
		dao.delete(Id);
		return Id;
	}

	@Override
	public Usage updateUsge(String Id, Usage usage) {
		Usage usageNew = new Usage();
		Usage usageDB = dao.findOne(Id);
		//usage.setId(usageDB.getId());
		if (usageDB != null) {
			usageNew = dao.save(usage);
		}
		return usageNew;
	}

}