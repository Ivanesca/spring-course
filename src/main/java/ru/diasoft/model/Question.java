package ru.diasoft.model;

import java.util.List;

public record Question(String value, int correctAnswer, List<Answer> answerOptions) {
}
