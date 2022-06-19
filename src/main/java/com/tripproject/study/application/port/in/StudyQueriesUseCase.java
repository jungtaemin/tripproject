package com.tripproject.study.application.port.in;


import com.tripproject.study.application.StudyDtoCardBox;
import com.tripproject.study.application.StudyResponseForDetail;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudyQueriesUseCase {


    public Page<StudyDtoCardBox> findByOrderByIdDesc(Integer page);
    public Page<StudyDtoCardBox> findByOrderByIdAsc(Integer page);
    public StudyResponseForDetail findById(Long id);
    public List<StudyDtoCardBox> findTop5ByOrderByIdDesc();

    StudyDtoCardBox getStudyEdit(Long studyId);

    void findId(Long studyId, StudyDtoCardBox studyDtoCardBox);

}
