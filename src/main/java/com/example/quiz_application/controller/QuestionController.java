package com.example.quiz_application.controller;

import com.example.quiz_application.dto.QuestionDto;
import com.example.quiz_application.entity.Question;
import com.example.quiz_application.exception.QuestionNotFoundException;
import com.example.quiz_application.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class QuestionController {
    private final QuestionService questionService;


    @GetMapping("/question/{questionId}")
    public ResponseEntity<Question> getQuestionById(@PathVariable("questionId") Long questionId ) throws QuestionNotFoundException {
        return ResponseEntity.ok().body(questionService.getQuestionById(questionId));
    }

    @GetMapping("/filter-by-topic/{topic}")
    public ResponseEntity<Question> getQuestionByTopic(@PathVariable("topic")String topic) throws QuestionNotFoundException {
        return ResponseEntity.ok().body(questionService.getQuestionByTopic(topic));
    }

    @DeleteMapping("/question/{questionId}")
    public void deleteQuestion(@PathVariable("questionId") Long questionId){
        questionService.deleteQuestionById(questionId);
        System.out.println( "question deleted successfully");
    }

    @PutMapping("/update-question")
    public ResponseEntity<Question> updateQuestion(@RequestBody QuestionDto questionDto) {
        return ResponseEntity.ok().body(questionService.updateQuestion(questionDto));
    }


    @PostMapping("/create-questionList")
    public ResponseEntity<List<Question>> createQuestionList (@RequestBody List<QuestionDto> questionDtoList){
        return ResponseEntity.ok().body(questionService.createQuestionList(questionDtoList));
    }
}


