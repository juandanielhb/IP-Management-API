package com.jdhb.ip_management.entities;

import java.util.Objects;

import javax.persistence.Column;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "ipPoolId", referencedColumnName = "id")	
	private IPPool ipPool;
	
	private String ipValue;

	@Override
	public int hashCode() {
		return Objects.hash(id, ipPool, ipValue);
	}

}
