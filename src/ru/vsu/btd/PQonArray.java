package ru.vsu.btd;

import java.util.ArrayList;

public class PQonArray implements PriorityQueue {

    private static class Node {
        int value;
        int priority;

        Node(int value, int priority) {
            this.value = value;
            this.priority = priority;
        }
    }

    int size;
    ArrayList<Node> arr = new ArrayList<>();

    @Override
    public void insert(int value, int priority) {
        int index = -1;
        if (size > 1) {
            for (int i = 1; i < size; i++) {
                if (arr.get(i).priority > priority) {
                    index = i;
                }
            }

            if (index == -1 || size - 1 == index) {
                arr.add(size, new Node(value, priority));
            } else {
                arr.add(index - 1, new Node(value, priority));
            }
        } else if (size == 1 && arr.get(0).priority > priority) {
            arr.add(0, new Node(value, priority));
        } else {
            arr.add(new Node(value, priority));
        }
        size++;
    }

    @Override
    public int extractMax() {
        int max = arr.remove(0).value;
        size--;
        return max;
    }

    @Override
    public void increase(int value, int priority) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (arr.get(i).value == value) {
                index = i;
            }
        }

        if (index != -1) {
            arr.get(index).priority += priority;
            for (int j = index; j < size - 1; j++) {
                if (arr.get(j).priority > arr.get(j + 1).priority) {
                    Node tmp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, tmp);
                } else {
                    return;
                }
            }
        }
    }

    public void sort() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (arr.get(j).priority < arr.get(j).priority) {
                    int tmp = arr.get(j).value;
                    arr.get(j).value = arr.get(j + 1).value;
                    arr.get(j + 1).value = tmp;

                    tmp = arr.get(j).priority;
                    arr.get(j).priority = arr.get(j + 1).priority;
                    arr.get(j + 1).priority = tmp;

                }
            }
        }
    }
}
