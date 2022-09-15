package com.example.quiz_application.service;

import com.example.quiz_application.dto.TopicDto;
import com.example.quiz_application.entity.Topic;

public interface TopicService {
    Topic createTopic (TopicDto topicDto);
}
