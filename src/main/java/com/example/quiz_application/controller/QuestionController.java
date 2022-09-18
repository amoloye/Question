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


    @GetMapping("/question")
    public ResponseEntity<Question> getQuestionById(@RequestBody QuestionDto questionDto) throws QuestionNotFoundException {
        return ResponseEntity.ok().body(questionService.getQuestionById(questionDto));
    }

    @GetMapping("/filter-by-topic")
    public ResponseEntity<Question> getQuestionByTopic(@RequestBody QuestionDto questionDto) throws QuestionNotFoundException {
        return ResponseEntity.ok().body(questionService.getQuestionByTopic(questionDto));
    }

    @DeleteMapping("/question")
    public void deleteQuestion(@RequestBody QuestionDto questionDto){
        questionService.deleteQuestionById(questionDto);
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


