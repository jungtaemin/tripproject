package com.tripproject.study.application;



import com.tripproject.study.application.port.StudyRepositoryPort;
import com.tripproject.study.application.port.in.StudyQueriesUseCase;
import com.tripproject.study.domain.Study;
import com.tripproject.user.application.NotFoundUserExcepton;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Component
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StudyQueriesService implements StudyQueriesUseCase {

    private final StudyRepositoryPort studyRepositoryPort;
    private final StudyDtoMapper studyDtoMapper;


    public Page<StudyDtoCardBox> findByOrderByIdDesc(Integer page){
        return   studyRepositoryPort.findByOrderByIdDesc(PageRequest.of(pageResolve(page),5))
                .map(studyDtoMapper::cardBox);
    }



    private int pageResolve(Integer rawPage) {
        if (rawPage == null || rawPage == 1) {
            return 0;
        } else return rawPage - 1;
    }



    public StudyResponseForDetail findById(Long id){
        Study Study = studyRepositoryPort.findById(id).orElseThrow(NotFoundUserExcepton::new);
        StudyResponseForDetail simple = studyDtoMapper.simple(Study);
        return simple;

    }


    public Page<StudyDtoCardBox> findByOrderByIdAsc(Integer page){
        return   studyRepositoryPort.findByOrderByIdAsc(PageRequest.of(pageResolve(page),10))
                .map(studyDtoMapper::cardBox);
    }


    public List<StudyDtoCardBox> findTop5ByOrderByIdDesc(){
        return studyRepositoryPort.findTop5ByOrderByIdDesc()
                .stream().map(studyDtoMapper::cardBox)
                .collect(Collectors.toList());

    }


    public StudyDtoCardBox getStudyEdit(Long studyId) {
        Study studybyId = studyRepositoryPort.findStudyById(studyId);
        StudyDtoCardBox studyDtoCardBox = studyDtoMapper.cardBox(studybyId);
        return studyDtoCardBox;
    }


    @Transactional
    public void findId(Long studyId, StudyDtoCardBox studyDtoCardBox) {
        Study study = studyRepositoryPort.findById(studyId).orElseThrow();
        study.edit(studyDtoCardBox.getContent(),studyDtoCardBox.getTitle());

    }

    @Override
    public Page<StudyDtoCardBox> getStuedySearchByKeyword(Pageable pageable, String keyword) {
        return studyRepositoryPort.findAllByKeywordOrderById(pageable,keyword)
                .map(studyDtoMapper::cardBox);
    }
}
