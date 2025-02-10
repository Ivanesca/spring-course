package ru.diasoft.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.diasoft.model.Answer;
import ru.diasoft.model.Question;
import ru.diasoft.service.QuestionOutPutService;

import java.util.List;

@Service
@AllArgsConstructor
public class QuestionOutPutServiceImpl implements QuestionOutPutService {
    @Override
    public void printQuestion(Question question) {
        System.out.println(question.value());
        List<Answer> answerOptions = question.answerOptions();
        for (int i = 0; i < answerOptions.size(); i++) {
            Answer answer = answerOptions.get(i);
            System.out.printf("\t%d %s%n", i + 1, answer.value());
        }
    }
}
