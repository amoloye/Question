package com.example.quiz_application.repository;

import com.example.quiz_application.entity.DifficultyLevel;
import com.example.quiz_application.entity.Question;
import com.example.quiz_application.entity.Response;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@RequiredArgsConstructor
class QuestionRepositoryTest {
    private final QuestionRepository questionRepository;

    private final TestEntityManager entityManager;



    @BeforeEach
    void setUp () {
        Response response1 = Response.builder()
                .text("H2SO4 + 2NACL=2HCL + NA2So4")
                .correct(true)
                .build();

        //add responses to list
        List<Response> responses = new ArrayList<>();

        responses.add(response1);
        Question question1 = Question.builder()
                .topic("Chemistry")
                .difficultyLevel(DifficultyLevel.valueOf("MEDIUM"))
                .content("H2SO4 + NACL?")
                .responses(responses)
                .build();

        entityManager.persist(question1);

    }

    @Test
    public void whenFindByTopic_ThenReturnQuestion () {
        Question question = questionRepository.findByTopicIgnoreCase("Chemistry").get();
        assertEquals(question.getContent(),"H2SO4 + NACL?");
    }
}
