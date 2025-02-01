package ru.diasoft.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.diasoft.config.DatasourceProperties;
import ru.diasoft.model.Answer;
import ru.diasoft.model.Question;
import ru.diasoft.service.impl.QuestionInputServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionInputServiceTest {
    private static QuestionInputService questionInputService;

    @BeforeAll
    static void setup() {
        DatasourceProperties datasourceProperties = new DatasourceProperties("/questions-test.csv");
        questionInputService = new QuestionInputServiceImpl(datasourceProperties);
    }

    @Test
    public void ReadDataTest() {
        List<Question> expectedQuestions = List.of(
                new Question("Question", 1, List.of(new Answer("Answer")))
        );

        List<Question> actualQuestions = questionInputService.readData();

        assertEquals(expectedQuestions, actualQuestions);
    }
}
