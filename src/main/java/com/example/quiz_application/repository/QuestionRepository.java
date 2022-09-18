package com.example.quiz_application.repository;

import com.example.quiz_application.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {
    Optional<Question> findByTopicIgnoreCase (String topic);
}
