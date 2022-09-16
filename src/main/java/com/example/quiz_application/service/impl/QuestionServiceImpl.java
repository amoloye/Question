package com.example.quiz_application.service.impl;

import com.example.quiz_application.dto.QuestionDto;
import com.example.quiz_application.entity.DifficultyLevel;
import com.example.quiz_application.entity.Question;
import com.example.quiz_application.exception.QuestionNotFoundException;
import com.example.quiz_application.mapper.QuestionMapper;
import com.example.quiz_application.repository.QuestionRepository;
import com.example.quiz_application.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;


    @Override
    public Question createQuestion (QuestionDto questionDto) {
        Question question = QuestionMapper.INSTANCE.questionDtoToQuestion(questionDto);

        return questionRepository.save(question);
    }

    @Override
    public Question getQuestionById (QuestionDto questionDto) throws QuestionNotFoundException {
        long questionId = questionDto.getQuestionId();
        Optional<Question> question=  questionRepository.findById(questionId);
        if (!question.isPresent()){
            throw new QuestionNotFoundException("Question Not Available");
        }
        return   question.get();
    }

    @Override
    public Question getQuestionByTopic (QuestionDto questionDto) throws QuestionNotFoundException {
        String topic = questionDto.getTopic();
        Optional<Question> question=  questionRepository.findByTopic(topic);
        if (!question.isPresent()){
            throw new QuestionNotFoundException("Question Not Available");
        }
        return   question.get();
    }

    @Override
    public void deleteQuestionById (QuestionDto questionDto) {
        long questionId = questionDto.getQuestionId();
        questionRepository.deleteById(questionId);
    }

    @Override
    public Question updateQuestion (QuestionDto questionDto) {
        long questionId = questionDto.getQuestionId();
        Question questionDB = questionRepository.findById(questionId).get();

        if (Objects.nonNull(questionDto.getContent())&&
                !"".equalsIgnoreCase(questionDto.getContent())){
            questionDB.setContent(questionDto.getContent());
        }

        if (Objects.nonNull(questionDto.getTopic())&&
                !"".equalsIgnoreCase(questionDto.getTopic())){
            questionDB.setTopic(questionDto.getTopic());
        }

        if (Objects.nonNull(questionDto.getDifficultyLevel())&&
                !"".equalsIgnoreCase(questionDto.getDifficultyLevel())){
            questionDB.setDifficultyLevel(DifficultyLevel.valueOf(questionDto.getDifficultyLevel()));
        }

        //question responses can only be added to and not replaced
        if (Objects.nonNull(questionDto.getResponses())&&
                !"".equalsIgnoreCase(String.valueOf(questionDto.getResponses()))){
            questionDB.getResponses().putAll(questionDto.getResponses());
        }

        return questionRepository.save(questionDB);
    }

}



//    @Override
//    public Department updateDepartment (Long departmentId, Department department) {

//        Department depDB = departmentRepository.findById(departmentId).get();
//
//        if (Objects.nonNull(department.getDepartmentName())&&
//                !"".equalsIgnoreCase(department.getDepartmentName())){
//            depDB.setDepartmentName(department.getDepartmentName());
//        }
//        if (Objects.nonNull(department.getDepartmentCode())&&
//                !"".equalsIgnoreCase(department.getDepartmentCode())){
//            depDB.setDepartmentCode(department.getDepartmentCode());
//        }
//
//        if (Objects.nonNull(department.getDepartmentAddress())&&
//                !"".equalsIgnoreCase(department.getDepartmentAddress())){
//            depDB.setDepartmentAddress(department.getDepartmentAddress());
//        }
//
//        return departmentRepository.save(depDB);
//
//    }
