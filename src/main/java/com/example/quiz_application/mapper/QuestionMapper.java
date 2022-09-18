package com.example.quiz_application.mapper;

import com.example.quiz_application.dto.QuestionDto;
import com.example.quiz_application.entity.Question;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface QuestionMapper {

    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    List<Question> questionDtoToQuestion (List<QuestionDto> questionDtoList);

    List<Question> questionDtoToQuestion
            (List<QuestionDto> questionDtoList, @MappingTarget List<Question> questionList);

    List<QuestionDto> questionToQuestionDto (List<Question> questionList);

}
