package com.example.quiz_application.mapper;

import com.example.quiz_application.dto.TopicDto;
import com.example.quiz_application.entity.Topic;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TopicMapper {
    TopicMapper INSTANCE = Mappers.getMapper(TopicMapper.class);

    Topic topicDtoToTopic(TopicDto topicDto);

    @InheritInverseConfiguration
    TopicDto topicToTopicDto (Topic topic);


}
