package ru.diasoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.diasoft.model.TestResult;
import ru.diasoft.service.IOService;
import ru.diasoft.service.TestingService;

@SpringBootApplication
public class SpringBootCourseApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootCourseApplication.class, args);

        TestingService testingService = context.getBean(TestingService.class);
        IOService ioService = context.getBean(IOService.class);
        TestResult testResult = testingService.runTest();
        ioService.printString("your.result", String.valueOf(testResult.correctAnswers()),
                "/" + testResult.totalQuestions()
        );
    }

}
