package com.tripproject.study.adapter.in;

import com.tripproject.study.domain.Study;
import com.tripproject.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;


@Getter
@AllArgsConstructor
public class StudyCreateCommand {


    private String title;


    private String content;



    private Long id;


    public static StudyCreateCommand form(StudyForm studyForm, Long id) {
        return new StudyCreateCommand(studyForm.getTitle(),studyForm.getContent(),id);
    }
}
