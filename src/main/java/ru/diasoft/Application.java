package ru.diasoft;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import ru.diasoft.model.TestResult;
import ru.diasoft.service.TestingService;

@ComponentScan
@PropertySource("classpath:application.properties")
public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Application.class);

        TestingService testingService = context.getBean(TestingService.class);
        TestResult testResult = testingService.runTest();
        System.out.println("Your result: " + testResult.correctAnswers() + "/" + testResult.totalQuestions());
    }
}