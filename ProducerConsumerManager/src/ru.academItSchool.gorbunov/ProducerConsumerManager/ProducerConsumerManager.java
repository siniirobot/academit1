package ru.academItSchool.gorbunov.ProducerConsumerManager;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerManager {
    private int producersCount;
    private int consumerCount;
    private final Queue<String> queue = new LinkedList<>();
    private static final int MAX_CAPACITY = 20;

    public ProducerConsumerManager(int producersCount, int consumerCount) {
        this.producersCount = producersCount;
        this.consumerCount = consumerCount;
    }

    public void start() {
        for (int i = 0; i < this.producersCount; i++) {
            Thread t = new Thread(() -> {
                try {
                    int j = 1;

                    while (true) {
                        String el = "Элемент" + j;
                        j++;
                        Thread.sleep(500);

                        synchronized (queue) {
                            while (queue.size() >= MAX_CAPACITY) {
                                queue.wait();
                            }

                            queue.offer(el);
                            System.out.println("Размер очереди производителя - " + queue.size());
                            queue.notifyAll();
                        }
                    }
                } catch (InterruptedException ignored) {
                }
            });
            t.start();
        }

        for (int i = 0; i < this.consumerCount; i++) {
            Thread t = new Thread(() -> {
                try {
                    while (true) {
                        Thread.sleep(500);

                        synchronized (queue) {
                            while (queue.isEmpty()) {
                                queue.wait();
                            }

                            String el = queue.remove();
                            System.out.println("Размер очереди потребителя - " + queue.size());
                            System.out.println(el);
                            queue.notifyAll();
                        }
                    }
                } catch (InterruptedException ignored) {

                }
            });
            t.start();
        }
    }
}
