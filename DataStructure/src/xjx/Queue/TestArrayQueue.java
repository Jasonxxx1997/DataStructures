package xjx.Queue;

import java.util.Scanner;

/**
 * 用数组模拟队列
 *
 */
public class TestArrayQueue {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        String key = null;
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while (loop){
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据");
            System.out.println("g(get): 取出数据");
            System.out.println("h(head): 查看对头数据");
            key = scanner.next();
            switch (key){
                case "s":
                    arrayQueue.showQueue();
                    break;
                case "a":
                    System.out.println("输入一个数据");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case "g":
                    try {
                        int result = arrayQueue.getQueue();
                        System.out.println("取出的数据是："+result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "h":
                    try {
                        int result = arrayQueue.showFront();
                        System.out.println("取出的头数据是："+result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "e":
                    scanner.close();
                    loop = false;
                    break;
                default:break;
            }

        }
        System.out.println("程序退出");
    }
}

class ArrayQueue{
    private int maxSize; //对列的最大容量
    private int front; //队列头
    private int rear; //队列尾
    private int[] arr; //模拟队列

    /**
     * 初始化队列
     */
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        front = -1; //指向队列的头部，不包含队列的第一个元素
        rear = -1; //指向队列的尾部，指向队尾的数据
        arr = new int[maxSize]; //初始化数组
    }
    /**
     * 判断队列是否满了
     */
    public boolean isFull(){
        return this.rear == maxSize-1;
    }
    /**
     * 队列是否为空
     */
     public boolean isEmpty(){
         return rear == front;
     }
    /**
     * 添加数据(入队列)
     */
    public void addQueue(int data){
        if (isFull()){
            System.out.println("队列已满不能加数据了");
            return;
        }
        rear++;
        arr[rear] = data;
    }
    /**
     * 出队列
     */
    public int getQueue(){
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        front++;
        return arr[front];
    }
    /**
     * 显示队列的头数据
     */
    public int showFront(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return arr[front+1];
    }
    /**
     * 显示队列的所有元素
     */
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空");
            return;
        }else{
            for (int i = 0;i < arr.length;i++){
                System.out.println("arr["+i+"] = "+arr[i]);
            }
        }
    }
}
