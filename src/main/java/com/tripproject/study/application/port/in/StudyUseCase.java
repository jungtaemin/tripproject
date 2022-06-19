package com.tripproject.study.application.port.in;

import com.tripproject.study.adapter.in.StudyCreateCommand;

public interface StudyUseCase {
    public Long write(StudyCreateCommand studyCreateCommand);
    public Long delete(Long id);
}
