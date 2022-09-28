package com.example.quiz_application.service.impl;

import com.example.quiz_application.dto.QuestionDto;
import com.example.quiz_application.entity.DifficultyLevel;
import com.example.quiz_application.entity.Question;
import com.example.quiz_application.entity.Response;
import com.example.quiz_application.exception.QuestionNotFoundException;
import com.example.quiz_application.mapper.QuestionMapper;
import com.example.quiz_application.repository.QuestionRepository;
import com.example.quiz_application.service.QuestionService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Builder
@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;



    @Override
    public Question getQuestionById (Long questionId) throws QuestionNotFoundException {
        Optional<Question> question=  questionRepository.findByQuestionId(questionId);
        if (!question.isPresent()){
            throw new QuestionNotFoundException("Question Not Available");
        }
        return   question.get();
    }

    @Override
    public Question getQuestionByTopic (String topic) throws QuestionNotFoundException {
        return  questionRepository.findByTopicIgnoreCase(topic)
                .orElseThrow(()-> new QuestionNotFoundException("Question Not Available"));
    }

    @Override
    public void deleteQuestionById (Long questionId) {
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

        if (Objects.nonNull(questionDto.getResponses())&&
                !"".equalsIgnoreCase(String.valueOf(questionDto.getResponses()))){
            questionDB.getResponses().add((Response) questionDto.getResponses());
        }

        return questionRepository.save(questionDB);
    }

    @Override
    public List<Question> createQuestionList (List<QuestionDto> questionDtoList) {
        List<Question> questionList = QuestionMapper.INSTANCE.questionDtoToQuestion(questionDtoList);

       return  questionRepository.saveAll(questionList);
    }

}




