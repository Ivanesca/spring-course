package ru.diasoft.model;

import java.util.ArrayList;
import java.util.List;

public record Answer(String value) {

    public static List<Answer> createFromArray(String[] answers) {
        List<Answer> answerOptions = new ArrayList<>();
        for (String answer : answers) {
            answerOptions.add(new Answer(answer));
        }
        return answerOptions;
    }

}
