package org.knit.lab25;

import java.util.Scanner;

public class FileApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к файлу или папке: ");
        String path = scanner.nextLine();

        FileProcessor processor = new FileProcessor();
        processor.processFiles(path);
    }
}
