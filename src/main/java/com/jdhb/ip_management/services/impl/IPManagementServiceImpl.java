package com.jdhb.ip_management.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdhb.ip_management.entities.IPPool;
import com.jdhb.ip_management.repositories.IPAddressRepository;
import com.jdhb.ip_management.repositories.IPPoolRepository;
import com.jdhb.ip_management.services.IPManagementService;

import java.util.Optional;

import org.apache.commons.net.util.SubnetUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class IPManagementServiceImpl implements IPManagementService{
	
	private static final Logger	log = LoggerFactory.getLogger(IPManagementServiceImpl.class);

	@Autowired
	private IPAddressRepository iPAddressRepository;
	
	@Autowired
	private IPPoolRepository iPPoolRepository;

	@Override
	public Optional<IPPool> findIPPool(Long iPPoolId) {
		return iPPoolRepository.findById(iPPoolId);
	}
	
	
	
}
