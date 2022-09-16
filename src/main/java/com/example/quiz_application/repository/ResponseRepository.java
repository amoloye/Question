package com.example.quiz_application.repository;

import com.example.quiz_application.entity.Response;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponseRepository extends JpaRepository<Response,Long> {
}
