package com.human.seoulroad.course;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Course1Repository extends JpaRepository<Course1, BigDecimal>{
	
	@Query(value = "SELECT * FROM COURSE1", nativeQuery = true)
	List<Object[]> selectAll();
}
