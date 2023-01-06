package com.human.seoulroad.othercourse;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//create table seoul_trails as select * from csvread('C:\Users\h\Desktop\g\SeoulWalk\src\main\resources\서울 두드림길 정보.csv');


@Repository
public interface OtherCourseRepository extends JpaRepository<OtherCourse, String>{
	
	// JPA 기본 메서드 (참고 : https://frogand.tistory.com/22)
	// 따라서 쿼리문을 짜주지 않아도 findAll이란 예약어를 통해 모든 데이터를 찾아서 보내줌
//	@Query(value = "SELECT * FROM SEOUL_TRAILS", nativeQuery = true)
	List<OtherCourse> findAll();
	
	// searchGangnam이란 이름의 메서드를 정의
	// 네이티브 쿼리 - Service를 통해 받아온 파라미터 todb(강남) 과 같은 문자열을 찾음 
	@Query(value = "SELECT * FROM SEOUL_TRAILS WHERE COURSE_DIVISION LIKE %:todb%", nativeQuery = true)
	public List<OtherCourse> searchGangnam(@Param("todb")String todb);
}
