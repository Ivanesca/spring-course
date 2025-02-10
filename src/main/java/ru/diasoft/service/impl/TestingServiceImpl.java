package ru.diasoft.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.diasoft.model.Question;
import ru.diasoft.service.QuestionInputService;
import ru.diasoft.service.QuestionOutPutService;
import ru.diasoft.service.TestingService;

import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

@Service
@AllArgsConstructor
public class TestingServiceImpl implements TestingService {

    private QuestionOutPutService questionOutPutService;
    private QuestionInputService questionInputService;

    @Override
    public void startTest() {
        List<Question> questions = questionInputService.readData();
        String studentName = getStudentName();
        int correctAnswer = 0;

        for (Question question : questions) {
            correctAnswer += askQuestion(question) ? 1 : 0;
        }

        System.out.println("Your result: " + correctAnswer + "/" + questions.size());
        if (correctAnswer > questions.size() / 2) {
            System.out.println("The test is passed");
        } else {
            System.out.println("The test failed");
        }
    }

    private boolean askQuestion(Question question) {
        questionOutPutService.printQuestion(question);
        Scanner scanner = new Scanner(System.in);
        int answer;
        do {
            String str = scanner.nextLine();
            answer = parseInt(str);
        } while (answer < 1 || answer > 3);
        return question.correctAnswer() == answer;
    }

    private String getStudentName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        while (name.isBlank()) {
            name = scanner.nextLine();
        }
        return name;
    }
}
