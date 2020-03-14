package com.zwk.sync;

/**
 * 生产商
 */
public class Manufacturer implements Runnable {
    Warehouse warehouse;

    public Manufacturer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            warehouse.push(new NotebookPC(i));
            System.out.println("生产-->第" + (i + 1) + "个NotebookPC");
        }
    }
}
