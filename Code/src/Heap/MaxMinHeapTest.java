package Heap;

/**
 * 最大最小堆测试
 */
public class MaxMinHeapTest {
    public static void main(String[] args){
        Integer[] array = {1,2,3,4,0};
        MaxHeap<Integer> maxh = new MaxHeap<Integer>(array);
        maxh.printMaxHeap(0);
        System.out.println();
        maxh.heapify(maxh.getSize());
        maxh.printMaxHeap(0);
        System.out.println();

        maxh.insert(5);
        maxh.printMaxHeap(0);
        System.out.println();

        System.out.println(maxh.delMax());
        maxh.printMaxHeap(0);
        System.out.println();

        maxh.sortA(0,maxh.getSize());
        System.out.println(maxh.isEmpty());



        MinHeap<Integer> minh = new MinHeap<Integer>(array);
        minh.printMaxHeap(0);
        System.out.println();

        minh.insert(5);
        minh.printMaxHeap(0);
        System.out.println();

        minh.delMin();
        minh.printMaxHeap(0);
        System.out.println();

        minh.sortA(0,minh.getSize());

    }
}
