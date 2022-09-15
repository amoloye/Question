package com.example.quiz_application.controller;

import com.example.quiz_application.dto.TopicDto;
import com.example.quiz_application.entity.Topic;
import com.example.quiz_application.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TopicController {
    private final TopicService topicService;

    @PostMapping("/create-topic")
    public ResponseEntity<Topic> createTopic (@RequestBody TopicDto topicDto){
        return ResponseEntity.ok().body(topicService.createTopic(topicDto));

    }


}
