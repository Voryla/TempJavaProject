package com.zwk.sync;

import com.zwk.sync.Consumer;

/**
 * @function 此模块演示 线程同步 管程法
 * 信号灯法使用boolean标志位控制类似于红绿灯此处不演示
 * @version 1.0
 * @author 赵文凯
 */
public class Main {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        new Thread(new Manufacturer(warehouse)).start();
        new Thread(new Consumer(warehouse)).start();
    }
}
