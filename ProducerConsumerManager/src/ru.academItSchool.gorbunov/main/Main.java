package ru.academItSchool.gorbunov.main;

import ru.academItSchool.gorbunov.ProducerConsumerManager.ProducerConsumerManager;

public class Main {
    public static void main(String[] args) {
        ProducerConsumerManager producerConsumerManager = new ProducerConsumerManager(3, 1);
        producerConsumerManager.start();
    }
}
