package com.jdhb.ip_management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdhb.ip_management.entities.IPPool;

public interface IPPoolRepository extends JpaRepository<IPPool, Long> {

}
