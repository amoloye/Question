package com.example.quiz_application.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "question")
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long questionId;

    private String topic;

    private DifficultyLevel difficultyLevel;

    private String content;

    @OneToMany
    @JoinColumn(name = "responseId")
    private List<Response> responses;

}
