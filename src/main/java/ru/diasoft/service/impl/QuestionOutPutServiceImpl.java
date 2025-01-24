package ru.diasoft.service.impl;

import lombok.AllArgsConstructor;
import ru.diasoft.model.Answer;
import ru.diasoft.model.Question;
import ru.diasoft.service.QuestionInputService;
import ru.diasoft.service.QuestionOutPutService;

import java.util.List;

@AllArgsConstructor
public class QuestionOutPutServiceImpl implements QuestionOutPutService {
    private final QuestionInputService questionInputService;

    @Override
    public void printData() {
        List<Question> questions = questionInputService.readData();

        for (Question question : questions) {
            System.out.println(question.value());
            for (Answer answer : question.answerOptions()) {
                System.out.println("\t - " + answer.value());
            }
        }
    }
}
