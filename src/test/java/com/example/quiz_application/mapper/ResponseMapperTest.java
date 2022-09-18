//package com.example.quiz_application.mapper;
//
//import com.example.quiz_application.dto.ResponseDto;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mapstruct.factory.Mappers;
//import org.mockito.Spy;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class ResponseMapperTest {
//
//    @Spy
//    private ResponseMapper responseMapper = Mappers.getMapper(ResponseMapper.class);
//
//    @BeforeEach
//    void setUp () {
//        ResponseDto responseDto = ResponseDto.builder()
//                .question()
//                .build();
//    }
//
//    @Test
//    public void SCENARIO_CONVERT_ACTIVITY() {
//        Assertions.assertNotNull(questionList);
//       Assertions.assertEquals(questionList.get(0),questionDtoList.get(0) );
//    }
//}