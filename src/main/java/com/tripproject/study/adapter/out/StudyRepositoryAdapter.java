package com.tripproject.study.adapter.out;

import com.tripproject.study.application.port.StudyRepositoryPort;
import com.tripproject.study.domain.Study;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StudyRepositoryAdapter implements StudyRepositoryPort {

    private final StudyRepository studyRepository;


    public Study save(Study study){
        return studyRepository.save(study);
    }
    public Optional<Study> findById(Long id){
        return studyRepository.findById(id);
    }



    public Page<Study> findByOrderByIdDesc(Pageable pageable){
        return studyRepository.findByOrderByIdDesc(pageable);
    }

    public Page<Study> findByOrderByIdAsc(Pageable pageable){
        return studyRepository.findByOrderByIdAsc(pageable);
    }



    public List<Study> findTop5ByOrderByIdDesc(){
        return studyRepository.findTop5ByOrderByIdDesc();
    }


    public Long deleteById(Long id) {
        studyRepository.deleteById(id);
        return id;
    }

    public Study findStudyById(Long studyid){

        return studyRepository.findStudyById(studyid);
    }

}
