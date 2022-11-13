package ru.vsu.btd;

public interface PriorityQueue {

    void insert(int value, int priority);

    int extractMax();

    void increase(int value, int priority);
}
