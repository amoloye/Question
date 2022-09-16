package com.example.quiz_application.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long responseId;

    private String text;

    private boolean correct;
}
