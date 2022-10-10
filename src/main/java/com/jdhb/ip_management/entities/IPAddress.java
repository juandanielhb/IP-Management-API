package com.jdhb.ip_management.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "IP_ADDRESS")
public class IPAddress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	@OneToOne
	@JoinColumn(name = "ipPoolId", referencedColumnName = "id")	
	private IPPool ipPool;	
	private String ipValue;

	public IPAddress(IPPool ipPool, String ipValue) {
		super();
		this.ipPool = ipPool;
		this.ipValue = ipValue;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public IPPool getIpPool() {
		return ipPool;
	}

	public void setIpPool(IPPool ipPool) {
		this.ipPool = ipPool;
	}

	public String getIpValue() {
		return ipValue;
	}

	public void setIpValue(String ipValue) {
		this.ipValue = ipValue;
	}
	
	public static String iPArrayToString(int[] iPArray) {
		StringBuilder iPString = new StringBuilder();
		
		iPString.append(iPArray[0]).append(".")				
				.append(iPArray[1]).append(".")
				.append(iPArray[2]).append(".")
				.append(iPArray[3]);
				

		return iPString.toString();
	}

}
