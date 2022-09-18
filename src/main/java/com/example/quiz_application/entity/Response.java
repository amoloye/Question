package com.example.quiz_application.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Builder
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long responseId;

    private String text;

    private boolean correct;

    @ManyToOne
    @JoinColumn(name = "questionId")
    private Question question;
}
