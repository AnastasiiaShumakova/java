package org.knit.lab25;

import java.util.Scanner;

// Необходимо создать консольное приложение, которое принимает на вход путь к папке или файлу,
// и сохраняет все файлы размером менее 10 MB в базу данных.
// В базе данных создается таблица, в которой хранятся имена файлов и их содержимое в виде бинарных данных.

public class FileApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к файлу или папке: ");
        String path = scanner.nextLine();

        FileProcessor processor = new FileProcessor();
        processor.processFiles(path);
    }
}
