package ru.diasoft;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.diasoft.service.QuestionOutPutService;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("/application-context.xml");

        QuestionOutPutService questionOutPutService = context.getBean("questionOutPutService", QuestionOutPutService.class);
        questionOutPutService.printData();
    }
}