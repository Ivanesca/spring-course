package ru.diasoft.service.impl;

import org.springframework.stereotype.Service;
import ru.diasoft.service.IOService;

import java.util.Scanner;

@Service
public class IOServiceImpl implements IOService {
    @Override
    public void printString(String message) {
        System.out.println(message);
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
