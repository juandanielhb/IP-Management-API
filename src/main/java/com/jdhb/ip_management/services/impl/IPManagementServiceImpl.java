package com.jdhb.ip_management.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdhb.ip_management.entities.IPAddress;
import com.jdhb.ip_management.entities.IPPool;
import com.jdhb.ip_management.repositories.IPAddressRepository;
import com.jdhb.ip_management.repositories.IPPoolRepository;
import com.jdhb.ip_management.services.IPManagementService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class IPManagementServiceImpl implements IPManagementService{
	
	private static final Logger	log = LoggerFactory.getLogger(IPManagementServiceImpl.class);
	
    private final int MAX_IP_SEG = 255;
    private final int TOTAL_FIRST_SEGMENT = 256;

	@Autowired
	private IPAddressRepository iPAddressRepository;
	
	@Autowired
	private IPPoolRepository iPPoolRepository;

	@Override
	public Optional<IPPool> findIPPool(Long iPPoolId) {
		return iPPoolRepository.findById(iPPoolId);
	}
	
	@Override
	@Transactional
	public List<IPAddress> generateIPAddresses(IPPool iPPool, int amount){	
		List<IPAddress> iPAddresses = createPool(iPPool, amount);
		int newUsedCapacity = iPPool.getUsedCapacity() + amount;
		iPPool.setUsedCapacity(newUsedCapacity);		
		iPPoolRepository.save(iPPool);
		return iPAddressRepository.saveAll(iPAddresses);
	}

	private List<IPAddress> createPool(IPPool iPPool, int amount) {
		List<IPAddress> pool = new ArrayList<>();		

		int [] initialAddress = initialAddress(iPPool);
		int [] nextAddress = initialAddress;
		
		for(int i = 0; i < amount; i++) {
			nextAddress[3] = nextAddress[3] + 1;
			if (nextAddress[3] > MAX_IP_SEG) {
				nextAddress[2] = nextAddress[2] + 1;
				nextAddress[3] = 0;
			}
			pool.add(new IPAddress(iPPool, IPAddress.iPArrayToString(nextAddress)));
		}
		
		return pool;
		
	}
	
	private int[] initialAddress(IPPool iPPool) {		
		
		int[] segLowerBound = Arrays.stream(iPPool.getLowerBound().split("\\."))
				.mapToInt(Integer::parseInt)
				.toArray();
		
		int[] initialAddress = segLowerBound;
		
		int div = iPPool.getUsedCapacity() / TOTAL_FIRST_SEGMENT;
		int diff = iPPool.getUsedCapacity() - (div * TOTAL_FIRST_SEGMENT);
		
		if (div > 0) {
			initialAddress[2] = initialAddress[2] + div;
		}
		
		if (diff > 0) {
			initialAddress[3] = initialAddress[3] + diff;
		}
		
		return initialAddress;
	}
	
	
}
