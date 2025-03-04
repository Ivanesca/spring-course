package ru.diasoft.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.diasoft.config.AppConfig;
import ru.diasoft.service.IOService;

import java.util.Locale;
import java.util.Scanner;

@Service
@AllArgsConstructor
public class IOServiceImpl implements IOService {
    private final MessageSource messageSource;
    private final AppConfig appConfig;

    @Override
    public void printString(String... message) {
        StringBuilder builder = new StringBuilder();
        for (String s : message) {
            builder.append(messageSource.getMessage(s, null, s, Locale.of(appConfig.getLocale())));
            builder.append(" ");
        }
        System.out.println(builder);
    }

    @Override
    public String readString() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        while (str.isBlank()) {
            str = scanner.nextLine();
        }
        return str;
    }
}
