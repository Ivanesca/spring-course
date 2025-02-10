package ru.diasoft.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public record DatasourceProperties(@Value("${datasource.name}") String questionDatasourceName) {
}
