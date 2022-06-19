package com.tripproject.study.application;


import com.tripproject.study.domain.Study;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface StudyDtoMapper {

    @Mappings({
            @Mapping(source = "study.user.userName", target = "userName"),
    })
    StudyDtoCardBox cardBox(Study study);


    @Mappings({
            @Mapping(source = "study.user.id", target = "memberId"),
    })
    StudyResponseForDetail simple(Study study);

}
