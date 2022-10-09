package com.jdhb.ip_management.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdhb.ip_management.entities.IPPool;

public interface IPPoolRepository extends JpaRepository<IPPool, Long> {
	
	Optional<IPPool> findById(Long id);

}
