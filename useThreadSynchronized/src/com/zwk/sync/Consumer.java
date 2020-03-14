package com.zwk.sync;

/**
 * 消费者
 */
public class Consumer implements Runnable {
    Warehouse warehouse;

    public Consumer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            warehouse.takeOut();
            System.out.println("消费-->第" + (i + 1) + "个NotebookPC");
        }
    }
}
