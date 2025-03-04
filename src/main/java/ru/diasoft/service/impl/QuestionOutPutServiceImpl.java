package ru.diasoft.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.diasoft.model.Answer;
import ru.diasoft.model.Question;
import ru.diasoft.service.IOService;
import ru.diasoft.service.QuestionOutPutService;

import java.util.List;

@Service
@AllArgsConstructor
public class QuestionOutPutServiceImpl implements QuestionOutPutService {
    private final IOService ioService;

    @Override
    public void printQuestion(Question question) {
        ioService.printString(question.value());
        List<Answer> answerOptions = question.answerOptions();
        for (int i = 0; i < answerOptions.size(); i++) {
            Answer answer = answerOptions.get(i);
            ioService.printString("\t", String.valueOf(i + 1), answer.value());
        }
    }
}
