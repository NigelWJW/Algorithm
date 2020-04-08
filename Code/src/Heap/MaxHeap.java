package Heap;

import java.util.Arrays;
import java.util.NoSuchElementException;
/**
 * 最大堆完全二叉树实现，优先级最高的在最顶端
 * @param <T>
 */
public class MaxHeap<T extends Comparable<T>> {
    public T[] heap;
    public int size;

    /**
     * 构造函数
     */
    public MaxHeap(){
        int DEFAULTSIZE = 20;
        heap = (T[]) new Comparable[DEFAULTSIZE];
        size = 0;
    }

    public MaxHeap(int s){
        heap = (T[]) new Comparable[s];
        size = 0;
    }

    public MaxHeap(T[] array){
        heap = array;
        size = array.length;
        for (int i = 0; i<size;i++){
            percolateUp(i);
        }
    }

    /**
     * 堆插入-上滤：将插入元素放在堆末尾，根据和父节点大小比较判断上滤否
     * @param e
     */
    public void insert(T e){
        if (size == heap.length){
            expand();
        }
        heap[size++] = e;
        percolateUp(size-1);
    }
    public void percolateUp(int index){
        while (parentValid(index)) {
            int parentIndex = getParent(index);
            if (heap[parentIndex].compareTo(heap[index])>0){
                break;
            }
            else if(heap[parentIndex].compareTo(heap[index])<0){
                swap(parentIndex,index);
                index = parentIndex;
            }
            else{
                System.out.println("error!");
            }
        }
    }

    /**
     * 删除元素-下滤：删除最大者，与最后的元素兑换再与子节点比较下滤
     */
    public T delMax(){
        if (size == 0){
            throw new NoSuchElementException();
        }
        T maxElem = getMax();
        heap[0] = heap[--size];
        percolateDown(getSize(),0);
        return maxElem;
    }
    public void percolateDown(int n,int index){
        int choice;
        while (index != (choice =properParent(n,index))){
//            System.out.println(index +" " + choice +" ");
            swap(index,choice);
            index = choice;
        }
    }

    /**
     * Floyd建堆算法自底向上下滤各节点
     */
    public void heapify(int n){
        for (int i = lastInternal(getSize());inHeap(n,i);i--){
            percolateDown(n,i);
        }
    }

    /**
     * 堆排序A,hi哨兵元素
     */
    public void sortA(int lo,int hi){
        while (hi>lo){
            heap[--hi] = delMax();
        }
        for (T e:heap
             ) {
            System.out.print(e + " ");
        }
    }
    /**
     * 堆排序B
     */
    public void sortB(){
        T[] elem = (T[]) new Comparable[getSize()];
        for (int i = 0;i<elem.length;i++){
            elem[i] = getMax();
            delMax();
        }
        for (T e:elem
             ) {
            System.out.print(e + " ");
        }
    }
    /**
     *获取最大值
     */
    public T getMax(){
        if (size == 0){
            throw new NoSuchElementException();
        }
        return heap[0];
    }

    /**
     *获取元素总数
     */
    public int getSize(){
        return size;
    }

    /**
     *是否为空堆
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 清空堆
     */
    public void clear(){
        size = 0;
        Arrays.fill(heap,null);
    }

    /**
     * 获取父节点的索引
     * @param sonIndex
     */
    public int getParent(int sonIndex){
        if (sonIndex == 0){
            return -1;
        }
        return (sonIndex-1)>>1;
    }

    /**
     * 获得左孩子的索引
     * @param paIndex
     */
    public int getLc(int paIndex){
        return 2*paIndex + 1;
    }

    /**
     * 获得右孩子的索引
     * @param paIndex
     */
    public int getRc(int paIndex){
        return 2*paIndex + 2;
    }

    /**
     * 交换
     * @param a
     * @param b
     */
    public void swap(int a,int b){
        T temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    /**
     * 扩容
     */
    public void expand(){
        heap = Arrays.copyOf(heap,heap.length<<1);
    }

    /**
     * 判断heap[sonindex]是否有父节点
     * @param sonIndex
     */
    public boolean parentValid(int sonIndex){
        return sonIndex>0;
    }

    /**
     * 判断heap[index]是否合法
     * @param index
     */
    public boolean inHeap(int n,int index){
        return (((-1)<(index)) && ((index)<(n)));
    }

    /**
     * 判断heap[index]是否有左孩子
     * @param index
     */
    public boolean ClVaild(int n,int index){
        return inHeap(n,getLc(index));
    }

    /**
     * 判断heap[index]是否有左右孩子（完全二叉树，没有只有右孩子的情况)
     * @param index
     */
    public boolean CrVaild(int n,int index){
        return inHeap(n,getRc(index));
    }

    /**
     * 取大者
     * @param i
     * @param j
     */
    public int Bigger(int i,int j){
        return  heap[i].compareTo(heap[j])>0 ? i : j;
    }

    /**
     * 父子取最大者
     * @param index
     */
    public int properParent(int n,int index){
        if(CrVaild(n,index)){//左右孩子
            return Bigger(Bigger(index,getLc(index)),getRc(index));
        }
        if (ClVaild(n,index)){//只有左孩子
            return Bigger(index,getLc(index));
        }
        return index;
    }

    /**
     * 最后一个内部节点（末节点的父亲）
     * @param index
     */
    public int lastInternal(int index){
        return getParent(index-1);
    }

    /**
     * 打印堆
     * @param i
     */
    public void printMaxHeap(int i) {
        if (size > i) {
            System.out.print(heap[i]);
            if (2 * i + 1 < size || 2 * i + 2 < size) {
                System.out.print("(");
                printMaxHeap(2 * i + 1);
                System.out.print(",");
                printMaxHeap(2 * i + 2);
                System.out.print(")");
            }
        }
    }

}
