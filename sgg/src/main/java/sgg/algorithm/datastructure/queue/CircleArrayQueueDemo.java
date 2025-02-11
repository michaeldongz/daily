package sgg.algorithm.datastructure.queue;

import java.util.Scanner;

/**
 * @author: Michael
 * @date: 2025/2/11
 * @desc: 环形数组队列
 */
public class CircleArrayQueueDemo {

    public static void main(String[] args) {
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(4); // 设置队列大小为4,但数量最多为3
        char key = ' '; // 接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s: 显示队列");
            System.out.println("e: 退出程序");
            System.out.println("a: 添加数据到队列");
            System.out.println("g: 获取队列的数据");
            System.out.println("h: 查看队列头的数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    circleArrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    circleArrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = circleArrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = circleArrayQueue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
            }
        }
    }

}

class CircleArrayQueue{

    private int maxSize; // 表示数组的最大容量

    private int front; // 指向队列的第一个元素

    private int rear; // 指向队列的最后一个元素的后一个位置

    private int[] arr; // 该数组用于存放数据，模拟队列

    // 创建队列的构造器
    public CircleArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0; // 指向队列的第一个元素
        rear = 0; // 指向队列的最后一个元素的后一个位置
    }

    // 判断队列是否满
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    // 判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    // 添加数据到队列
    public void addQueue(int n){
        // 判断队列是否满
        if(isFull()){
            System.out.println("队列满，不能加入数据~");
            return;
        }

        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    // 获取队列的数据，出队列
    public int getQueue(){
        if(isEmpty()){
            // 抛出异常
            throw new RuntimeException("队列空，不能取数据");
        }
        int temp = arr[front];
        front = (front + 1) % maxSize;
        return temp;
    }

    // 显示队列的所有数据
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列空的，没有数据~~");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    // 获取有效数据
    public int size(){
        return (rear + maxSize - front) % maxSize;
    }

    // 显示队列的头数据，不是取出数据
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列空的，没有数据~~");
        }
        return arr[front];
    }
}
