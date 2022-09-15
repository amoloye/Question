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
public class Quiz {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long quizId;

    @OneToMany
    @JoinColumn(name = "questionId")
    private List<Question> question;
}
