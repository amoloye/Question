package com.example.quiz_application.service.impl;

import com.example.quiz_application.dto.TopicDto;
import com.example.quiz_application.entity.Topic;
import com.example.quiz_application.mapper.TopicMapper;
import com.example.quiz_application.repository.TopicRepository;
import com.example.quiz_application.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TopicServiceImpl implements TopicService {
    private final TopicRepository topicRepository;

    @Override
    public Topic createTopic (TopicDto topicDto) {
        Topic topic = TopicMapper.INSTANCE.topicDtoToTopic(topicDto);

        return topicRepository.save(topic);
    }
}
