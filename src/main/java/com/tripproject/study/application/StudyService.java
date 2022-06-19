package com.tripproject.study.application;

import com.tripproject.study.adapter.in.StudyCreateCommand;
import com.tripproject.study.application.port.in.StudyUseCase;
import com.tripproject.study.application.port.StudyRepositoryPort;
import com.tripproject.study.domain.Study;
import com.tripproject.study.domain.Study;
import com.tripproject.study.adapter.in.StudyCreateCommand;
import com.tripproject.study.application.port.StudyRepositoryPort;
import com.tripproject.user.application.port.in.UserQueriesUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class StudyService implements StudyUseCase {

    private final StudyRepositoryPort studyRepositoryPort;
    private final UserQueriesUseCase userQueriesUseCase;



    public Long write(StudyCreateCommand studyCreateCommand){

            var user = userQueriesUseCase.findId(studyCreateCommand.getId());
            log.info(user.toString());

            var study = new Study(studyCreateCommand.getTitle(), studyCreateCommand.getContent(),user);

            studyRepositoryPort.save(study);

            return study.getId();


    }


    public Long delete(Long id){

        studyRepositoryPort.deleteById(id);
        return id;

    }

    public Long edit(StudyDtoCardBox studyDtoCardBox){

        Study build = Study.builder()
                .title(studyDtoCardBox.getTitle())
                .content(studyDtoCardBox.getContent())
                .user(studyDtoCardBox.getUser())
                .build();
        studyRepositoryPort.save(build);
        return build.getId();
    }
}
