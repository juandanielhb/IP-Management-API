package com.jdhb.ip_management.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jdhb.ip_management.entities.IPAddress;
import com.jdhb.ip_management.entities.IPPool;

@Service
public interface IPManagementService {
	
	public Optional<IPPool> findIPPool(Long iPPoolId);
	
	public List<IPAddress> generateIPAddresses(IPPool iPPool, int amount);

}
