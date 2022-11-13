package ru.vsu.btd;


import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class Main {

    class Node {
        int value;
        int priority;

        Node(int value, int priority) {
            this.value = value;
            this.priority = priority;
        }
    }

    public static void main(String[] args) {

        Instant start, finish;
        long elapsed, avgElapsed;

        for (int n = 10000; n <= 20000; n += 2000) {

            System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
            PQonBinaryHeap heap = new PQonBinaryHeap();
            PQonArray arr = new PQonArray();
            System.out.println("Количество элементов: " + n);
            System.out.println("=========Insert=========");
            avgElapsed = 0;

            for (int k = 0; k < 10; k++) {
                start = Instant.now();
                for (int i = 1; i <= n; i++) {
                    heap.insert((int) (Math.random() * 10), (int) (Math.random() * 100));
                }
                finish = Instant.now();
                elapsed = Duration.between(start, finish).toNanos();
                avgElapsed += elapsed;
            }
            avgElapsed = avgElapsed / 10;
            System.out.println("BinaryHeap: Времени прошло, нс: " + avgElapsed);

            avgElapsed = 0;

            for (int k = 0; k < 10; k++) {
                start = Instant.now();
                for (int i = 1; i <= n; i++) {
                    arr.insert((int) (Math.random() * 10), (int) (Math.random() * 100));
                }
                finish = Instant.now();
                elapsed = Duration.between(start, finish).toNanos();
                avgElapsed += elapsed;
            }
            avgElapsed = avgElapsed / 10;
            System.out.println("LazyArray: Времени прошло, нс: " + avgElapsed);

            System.out.println();

            System.out.println("=========ExtractMax=========");

            start = Instant.now();
            heap.extractMax();
            finish = Instant.now();
            elapsed = Duration.between(start, finish).toNanos();
            System.out.println("BinaryHeap: Времени прошло, нс: " + elapsed);

            start = Instant.now();
            arr.extractMax();
            finish = Instant.now();
            elapsed = Duration.between(start, finish).toNanos();
            System.out.println("LazyArray: Времени прошло, нс: " + elapsed);

            System.out.println();

            System.out.println("=========Increase=========");

//            avgElapsed = 0;
//            for (int k = 0; k < 10; k++) {
//                start = Instant.now();
//                heap.increase(1, 10);
//                finish = Instant.now();
//                elapsed = Duration.between(start, finish).toNanos();
//                avgElapsed += elapsed;
//            }
//            System.out.println("BinaryHeap: Времени прошло, нс: " + avgElapsed);

            avgElapsed = 0;
            for (int k = 0; k < 10; k++) {
                start = Instant.now();
                arr.increase(1, 10);
                finish = Instant.now();
                elapsed = Duration.between(start, finish).toNanos();
                avgElapsed += elapsed;
            }
            System.out.println("LazyArray: Времени прошло, нс: " + avgElapsed);

        }

    }
}


