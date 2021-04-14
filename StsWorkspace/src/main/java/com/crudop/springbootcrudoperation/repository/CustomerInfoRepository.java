package com.crudop.springbootcrudoperation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudop.springbootcrudoperation.model.CustomerInfo;

@Repository
public interface CustomerInfoRepository extends JpaRepository<CustomerInfo, Long>{
	Optional<CustomerInfo> findByCustomerName(String customerName);
	Optional<CustomerInfo> findByContactNumber(long contactNumber);
}
