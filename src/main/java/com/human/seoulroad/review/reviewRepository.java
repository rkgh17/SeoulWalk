package com.human.seoulroad.review;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface reviewRepository extends JpaRepository<review, Integer> {
    Page<review> findAll(Pageable pageable);
}