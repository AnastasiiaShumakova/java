package Lab_2_2.lab_2;

import java.util.LinkedList;
import java.util.Queue;


import java.util.LinkedList;
import java.util.Queue;

public class Tray {
    private final Queue<String> dishes = new LinkedList<>(); // Очередь для хранения блюд
    private final int capacity = 3; // Максимальное количество блюд на подносе

    public synchronized void addDish(String dish) throws InterruptedException {
        while (dishes.size() >= capacity) {
            wait(); // Ожидаем, если поднос полон
        }
        dishes.add(dish); // Добавляем блюдо на поднос
        System.out.println("Повар приготовил: " + dish);
        System.out.println("На подносе: " + dishes.size() + " блюда(ов)"); // Выводим количество блюд после добавления
        notify(); // Уведомляем официанта о наличии нового блюда
    }

    public synchronized String takeDish() throws InterruptedException {
        while (dishes.isEmpty()) {
            wait(); // Ожидаем, если поднос пуст
        }
        String dish = dishes.poll(); // Берем блюдо с подноса
        System.out.println("Официант подал: " + dish);
        System.out.println("На подносе: " + dishes.size() + " блюда(ов)"); // Выводим количество блюд после удаления
        notify(); // Уведомляем повара о том, что место освободилось
        return dish; // Возвращаем взятое блюдо
    }
}





