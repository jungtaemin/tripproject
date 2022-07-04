package com.tripproject.study.application.port;


import com.tripproject.article.domain.Article;
import com.tripproject.study.domain.Study;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface StudyRepositoryPort {



    public Study save(Study study);

    public Optional<Study> findById(Long id);
    public Page<Study> findByOrderByIdDesc(Pageable pageable);

    public Page<Study> findByOrderByIdAsc(Pageable pageable);

    public List<Study> findTop5ByOrderByIdDesc();


    public Long deleteById(Long id);
    public Study findStudyById(Long id);

    public  Page<Study> findAllByKeywordOrderById(Pageable pageable, String keyword);
}
