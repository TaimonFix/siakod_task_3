package ru.vsu.btd;

import java.util.ArrayList;

public class PQonBinaryHeap  implements PriorityQueue {


    private  class Node {
        int value;
        int priority;

        Node(int value, int priority) {
            this.value = value;
            this.priority = priority;
        }
    }

    int size;
    ArrayList<Node> heap = new ArrayList<>();

    @Override
    public void insert(int value, int priority) {
        heap.add(new Node(value, priority));
        size++;

        if (size > 1) {
            siftUp(size - 1);
        }

    }

    @Override
    public int extractMax() {
        int max = heap.get(0).value;

        heap.get(0).value = heap.get(size - 1).value;
        heap.get(0).priority = heap.get(size - 1).priority;

        heap.remove(size - 1);

        if (size > 1) {
            siftDown(0);
        }
        return max;
    }

    @Override
    public void increase(int value, int priority) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (heap.get(i).value == value) {
                index = i;
            }
        }
        if (index != -1) {
            heap.get(index).priority += priority;
            siftDown(index);
        }
    }

    public void siftUp(int index) {
        while (index > 0) {
            int parentIndex;
            if (index % 2 == 0) {
                parentIndex = (index - 1) / 2;
            } else {
                parentIndex = (index / 2);
            }

            if (heap.get(index).priority < heap.get(parentIndex).priority) {
                Node tmp = heap.get(index);
                heap.set(index, heap.get(parentIndex));
                heap.set(parentIndex, tmp);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    public void siftDown(int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int parent = index;

        if (left < size && heap.get(left).priority < heap.get(index).priority) {
            parent = left;
        }
        if (right < size && heap.get(right).priority < heap.get(index).priority) {
            parent = right;
        }

        if (parent != index) {
            Node tmp = heap.get(index);
            heap.set(index, heap.get(parent));
            heap.set(parent, tmp);
            siftDown(parent);
        }
    }
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            Node value = heap.get(i);
            System.out.println(value.value + " " + value.priority);
        }
    }

}
