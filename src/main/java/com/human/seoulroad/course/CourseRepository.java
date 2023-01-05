package com.human.seoulroad.course;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//CREATE TABLE IF NOT EXISTS COURSE1 AS SELECT * FROM CSVREAD('classpath:course1.csv');

@Repository
public interface CourseRepository extends JpaRepository<Course1, BigDecimal>{
	
	@Query(value = "SELECT lat, lng FROM COURSE1", nativeQuery = true)
	List<String> selectAll1();
	
	@Query(value = "SELECT lat, lng FROM COURSE2", nativeQuery = true)
	List<String> selectAll2();
	
	@Query(value = "SELECT lat, lng FROM COURSE3", nativeQuery = true)
	List<String> selectAll3();
	
	@Query(value = "SELECT lat, lng FROM COURSE4", nativeQuery = true)
	List<String> selectAll4();

	@Query(value = "SELECT lat, lng FROM COURSE5", nativeQuery = true)
	List<String> selectAll5();
	
	@Query(value = "SELECT lat, lng FROM COURSE6", nativeQuery = true)
	List<String> selectAll6();
	
	@Query(value = "SELECT lat, lng FROM COURSE7", nativeQuery = true)
	List<String> selectAll7();
	
	@Query(value = "SELECT lat, lng FROM COURSE8", nativeQuery = true)
	List<String> selectAll8();
}
