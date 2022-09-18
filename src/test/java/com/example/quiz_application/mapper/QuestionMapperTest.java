package com.example.quiz_application.mapper;


import com.example.quiz_application.dto.QuestionDto;
import com.example.quiz_application.dto.ResponseDto;
import com.example.quiz_application.entity.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SpringBootTest
public class QuestionMapperTest {

    @Spy
    private QuestionMapper questionMapper = Mappers.getMapper(QuestionMapper.class);


    @Test
    public void SCENARIO_CONVERT_ACTIVITY() {

        QuestionDto questionDto1 = QuestionDto.builder()
                .questionId(1L)
                .content("This is my question")
                .difficultyLevel("MEDIUM")
                .topic("PHYSICS")
                .responses(Arrays.asList(
                        ResponseDto.builder()
                                .correct(true)
                                .text("This is my answer")
                        .build(),
                        ResponseDto.builder()
                                .correct(false)
                                .text("The real answer")
                                .build()
                ))
                .build();

        List<QuestionDto> questionDtoList = new ArrayList<>();
        questionDtoList.add(questionDto1);

        List<Question> questionList=questionMapper.questionDtoToQuestion( questionDtoList);
        Assertions.assertNotNull(questionList);
        Assertions.assertEquals(questionList.get(0).getContent(),"This is my question");

    }
}