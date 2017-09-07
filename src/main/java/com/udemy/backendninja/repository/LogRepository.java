package com.udemy.backendninja.repository;

import java.io.Serializable;

import com.udemy.backendninja.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * The Interface LogRepository.
 */
@Repository("logRepository")
public interface LogRepository extends JpaRepository<Log, Serializable> {

	
	
}
