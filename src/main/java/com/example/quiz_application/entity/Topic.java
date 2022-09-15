package com.example.quiz_application.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Topic {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long topicId;
    private String topic;
}
