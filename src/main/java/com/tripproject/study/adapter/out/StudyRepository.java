package com.tripproject.study.adapter.out;
import com.tripproject.study.domain.Study;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudyRepository extends JpaRepository<Study ,Long> {

    //최신순 글 정렬
    Page<Study>findByOrderByIdDesc(Pageable pageable);


    //과거순 글 정렬
    Page<Study>findByOrderByIdAsc(Pageable pageable);

    List<Study> findTop5ByOrderByIdDesc();

    public void deleteById(Long id);

    Study findStudyById(Long studyId);
}
