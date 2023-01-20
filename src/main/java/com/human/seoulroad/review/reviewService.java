package com.human.seoulroad.review;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class reviewService {

    private final reviewRepository reviewRepository;

    public Page<review> getList(int page) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));
        Pageable pageable = PageRequest.of(page, 5, Sort.by(sorts));
        return this.reviewRepository.findAll(pageable);
    }
    
    public void create(String reviewStar, String id, String reviewContents) {
        review r = new review();
        r.setReviewStar(reviewStar);
        r.setId(id);
        r.setReviewContents(reviewContents);
        r.setCreateDate(LocalDateTime.now());
        this.reviewRepository.save(r);
    }
}
