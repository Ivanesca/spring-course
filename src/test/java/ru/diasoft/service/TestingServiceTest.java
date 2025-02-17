package ru.diasoft.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.diasoft.model.Answer;
import ru.diasoft.model.Question;
import ru.diasoft.model.TestResult;
import ru.diasoft.service.impl.IOServiceImpl;
import ru.diasoft.service.impl.QuestionInputServiceImpl;
import ru.diasoft.service.impl.QuestionOutPutServiceImpl;
import ru.diasoft.service.impl.TestingServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestingServiceTest {

    @InjectMocks
    private TestingServiceImpl testingService;

    @Mock
    private IOServiceImpl ioService;

    @Mock
    private QuestionInputServiceImpl questionInputService;

    @Mock
    private QuestionOutPutServiceImpl questionOutPutService;

    private final List<Question> testQuestions = List.of(
            new Question("Question 1", 1, List.of(new Answer("Answer 1"), new Answer("Answer 2"))),
            new Question("Question 2", 2, List.of(new Answer("Answer 1"), new Answer("Answer 2")))
    );

    @Test
    public void shouldRunTestAndReturnStudentFullPassedResult() {
        when(questionInputService.readData()).thenReturn(testQuestions);
        doNothing().when(questionOutPutService).printQuestion(any());
        when(ioService.readString()).thenReturn("Apollo", "1", "2");

        TestResult expectedTestResult = new TestResult("Apollo", 2, 2);
        TestResult actualTestResult = testingService.runTest();

        verify(questionInputService, times(1)).readData();
        verify(ioService, times(3)).readString();
        assertEquals(expectedTestResult, actualTestResult);
    }

    @Test
    public void shouldRunTestAndReturnStudentHalfPassedResult() {
        when(questionInputService.readData()).thenReturn(testQuestions);
        doNothing().when(questionOutPutService).printQuestion(any());
        when(ioService.readString()).thenReturn("Apollo", "1", "1");

        TestResult expectedTestResult = new TestResult("Apollo", 1, 2);
        TestResult actualTestResult = testingService.runTest();

        verify(questionInputService, times(1)).readData();
        verify(ioService, times(3)).readString();
        assertEquals(expectedTestResult, actualTestResult);
    }

    @Test
    public void shouldRunTestAndReturnStudentFailedResult() {
        when(questionInputService.readData()).thenReturn(testQuestions);
        doNothing().when(questionOutPutService).printQuestion(any());
        when(ioService.readString()).thenReturn("Apollo", "2", "1");

        TestResult expectedTestResult = new TestResult("Apollo", 0, 2);
        TestResult actualTestResult = testingService.runTest();

        verify(questionInputService, times(1)).readData();
        verify(ioService, times(3)).readString();
        assertEquals(expectedTestResult, actualTestResult);
    }
}
