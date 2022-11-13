package ru.vsu.btd;


public interface PriorityQueue {

    public void insert(int value, int priority);

    public int extractMax();

    public void increase(int value, int priority);
}
