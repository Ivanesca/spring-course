package ru.diasoft.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.diasoft.model.Question;
import ru.diasoft.model.TestResult;
import ru.diasoft.service.IOService;
import ru.diasoft.service.QuestionInputService;
import ru.diasoft.service.QuestionOutPutService;
import ru.diasoft.service.TestingService;

import java.util.List;

import static java.lang.Integer.parseInt;

@Service
@AllArgsConstructor
public class TestingServiceImpl implements TestingService {

    private QuestionOutPutService questionOutPutService;
    private QuestionInputService questionInputService;
    private IOService ioService;

    @Override
    public TestResult runTest() {
        List<Question> questions = questionInputService.readData();
        ioService.printString("Enter your name:");
        String studentName = ioService.readString();

        int correctAnswer = 0;

        for (Question question : questions) {
            correctAnswer += askQuestion(question) ? 1 : 0;
        }

        return new TestResult(studentName, correctAnswer, questions.size());
    }

    private boolean askQuestion(Question question) {
        questionOutPutService.printQuestion(question);
        int answer;
        do {
            String str = ioService.readString();
            answer = parseInt(str);
        } while (answer < 1 || answer > 3);
        return question.correctAnswer() == answer;
    }
}
