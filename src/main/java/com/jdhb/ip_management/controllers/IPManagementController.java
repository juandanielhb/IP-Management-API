package com.jdhb.ip_management.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdhb.ip_management.entities.IPAddress;
import com.jdhb.ip_management.entities.IPPool;
import com.jdhb.ip_management.services.IPManagementService;

@RestController
@RequestMapping()
public class IPManagementController {

	private static final Logger	log = LoggerFactory.getLogger(IPManagementController.class);
	
	@Autowired
	private IPManagementService iPManagementService;
	
	@PostMapping("/ip-pools/{id}/ip-address")
	public ResponseEntity<List<IPAddress>> generateIPAddresses(
			@PathVariable("id") Long iPPoolId, 
			@RequestParam(value = "amount", required = true) int amount
			){
		
		log.info("generateIPAddresses: IPPoolId: " + iPPoolId + ", amount: " + amount);
		
		Optional<IPPool> iPPoolOpt = iPManagementService.findIPPool(iPPoolId);
		if (!iPPoolOpt.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		IPPool iPPool = iPPoolOpt.get();
		int capacityAvailable = iPPool.getTotalCapacity() - iPPool.getUsedCapacity();
		
		if (amount <= 1 || capacityAvailable < amount) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(
				iPManagementService.generateIPAddresses(iPPool, amount), 
				HttpStatus.OK);
	}
	
	@GetMapping("/ip-pools")
	public ResponseEntity<IPPool> getIPPool(@RequestParam("id") Long iPPoolId){
		log.info("Ip pool id = " + iPPoolId);
		return new ResponseEntity<IPPool>(iPManagementService.findIPPool(iPPoolId).get(), HttpStatus.OK);
	}
}
