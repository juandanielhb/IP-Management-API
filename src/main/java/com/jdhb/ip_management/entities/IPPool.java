package com.jdhb.ip_management.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "IP_POOL")
public class IPPool {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String description;
	private int totalCapacity;
	private int usedCapacity;
	private String lowerBound;
	private String upperBound;	
	
	public IPPool(Long id, String description, int totalCapacity, int usedCapacity, String lowerBound,
			String upperBound) {
		super();
		this.id = id;
		this.description = description;
		this.totalCapacity = totalCapacity;
		this.usedCapacity = usedCapacity;
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}
	

}
