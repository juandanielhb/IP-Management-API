package com.jdhb.ip_management.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jdhb.ip_management.entities.IPPool;

@Service
public interface IPManagementService {
	
	public Optional<IPPool> findIPPool(Long iPPoolId);

	

}
