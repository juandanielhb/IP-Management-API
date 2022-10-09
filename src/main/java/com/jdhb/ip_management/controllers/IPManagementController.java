package com.jdhb.ip_management.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdhb.ip_management.entities.IPPool;
import com.jdhb.ip_management.services.IPManagementService;

@RestController
@RequestMapping()
public class IPManagementController {

	private static final Logger	log = LoggerFactory.getLogger(IPManagementController.class);
	
	@Autowired
	private IPManagementService iPManagementService;
	
	@GetMapping("/ip-pools")
	public ResponseEntity<IPPool> getIPPool(@RequestParam("id") Long iPPoolId){
		log.info("Ip pool id = " + iPPoolId);
		return new ResponseEntity<IPPool>(iPManagementService.findIPPool(iPPoolId).get(), HttpStatus.OK);
	}
}
