package com.dtag.bm.usage.management.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtag.bm.usage.management.service.dao.UsageSpecificationDAO;
import com.dtag.bm.usage.management.service.model.UsageSpecificationReq;

@Service
public class UsageSpecificationServiceImpl implements UsageSpecificationService {

	@Autowired
	private UsageSpecificationDAO dao;

	@Override
	public UsageSpecificationReq createUsageSpecification(UsageSpecificationReq usageSpecReq) {
		return dao.insert(usageSpecReq);
	}

	@Override
	public UsageSpecificationReq getUsageSpecificationById(String Id) {
		return dao.findOne(Id);
	}

	@Override
	public void deleteUsgespecById(String Id) {
		dao.delete(Id);
	}

}
