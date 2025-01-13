package ru.diasoft.service.impl;

import lombok.AllArgsConstructor;
import ru.diasoft.config.DatasourceProperties;
import ru.diasoft.model.Answer;
import ru.diasoft.model.Question;
import ru.diasoft.service.QuestionInputService;

import java.util.*;

@AllArgsConstructor
public class QuestionInputServiceImpl implements QuestionInputService {
    private final DatasourceProperties datasourceProperties;

    @Override
    public List<Question> readData() {
        List<Question> questions = new ArrayList<>();
        try (Scanner scanner = new Scanner(Objects.requireNonNull(
                this.getClass().getResourceAsStream(datasourceProperties.questionDatasourceName()))
        )) {
            // Read header
            scanner.nextLine();

            while (scanner.hasNext()) {
                String[] row = scanner.nextLine().split("\t");
                String question = row[0];
                int correctAnswer = Integer.parseInt(row[1]) - 1;
                List<Answer> answerOptions = Answer.createFromArray(Arrays.copyOfRange(row, 2, row.length));
                questions.add(new Question(question, correctAnswer, answerOptions));
            }
        }

        return questions;
    }


}
