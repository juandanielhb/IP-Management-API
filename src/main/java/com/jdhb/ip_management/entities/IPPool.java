package com.jdhb.ip_management.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "IP_POOL")
public class IPPool {
	
	@Id
	private Long id;	
	private String description;
	private int totalCapacity;
	private int usedCapacity;
	private String lowerBound;
	private String upperBound;	
	
	public IPPool() {}
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTotalCapacity() {
		return totalCapacity;
	}

	public void setTotalCapacity(int totalCapacity) {
		this.totalCapacity = totalCapacity;
	}

	public int getUsedCapacity() {
		return usedCapacity;
	}

	public void setUsedCapacity(int usedCapacity) {
		this.usedCapacity = usedCapacity;
	}

	public String getLowerBound() {
		return lowerBound;
	}

	public void setLowerBound(String lowerBound) {
		this.lowerBound = lowerBound;
	}

	public String getUpperBound() {
		return upperBound;
	}

	public void setUpperBound(String upperBound) {
		this.upperBound = upperBound;
	}
	
}
