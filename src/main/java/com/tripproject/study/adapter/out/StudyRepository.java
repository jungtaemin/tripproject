package com.tripproject.study.adapter.out;
import com.tripproject.article.domain.Article;
import com.tripproject.study.domain.Study;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudyRepository extends JpaRepository<Study ,Long> {

    //최신순 글 정렬
    Page<Study>findByOrderByIdDesc(Pageable pageable);


    //과거순 글 정렬
    Page<Study>findByOrderByIdAsc(Pageable pageable);

    List<Study> findTop5ByOrderByIdDesc();

    public void deleteById(Long id);

    Study findStudyById(Long studyId);

    @Query("select a from Study a where a.title like %:keyword% or a.content like %:keyword% order by a.id desc")
    Page<Study> findAllByKeywordOrderById(Pageable pageable, @Param("keyword") String keyword);
}
