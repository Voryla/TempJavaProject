package com.zwk.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 无锁即无障碍的运行, 所有线程都可以到达临界区, 接近于无等待.
 *
 * 无锁采用CAS(compare and swap)算法来处理线程冲突, 其原理如下
 *
 * CAS原理
 * CAS包含3个参数CAS(V,E,N).V表示要更新的变量, E表示预期值, N表示新值.
 *
 * 仅当V值等于E值时, 才会将V的值设为N, 如果V值和E值不同, 则说明已经有其他线程做了更新, 则当前线程什么
 *
 * 都不做. 最后, CAS返回当前V的真实值. CAS操作是抱着乐观的态度进行的, 它总是认为自己可以成功完成操作.
 *
 * 当多个线程同时使用CAS操作一个变量时, 只有一个会胜出, 并成功更新, 其余均会失败.失败的线程不会被挂起,
 *
 * 仅是被告知失败, 并且允许再次尝试, 当然也允许失败的线程放弃操作.基于这样的原理, CAS操作即时没有锁,
 *
 * 也可以发现其他线程对当前线程的干扰, 并进行恰当的处理.
 *
 * CPU指令
 *
 * 另外, 虽然上述步骤繁多, 实际上CAS整一个操作过程是一个原子操作, 它是由一条CPU指令完成的,
 *
 * 从指令层保证操作可靠, 不会被多线程干扰.
 *
 * 无锁与volatile
 *
 * 无锁可以通过cas来保证原子性与线程安全, 他与volatile什么区别呢?
 *
 * 当给变量加了volatile关键字, 表示该变量对所有线程可见, 但不保证原子性.
 *
 * 以volatile i, i++为例, 分为以下四步:
 *
 * 加载i
 * 对i进行+1
 * 回写i的值
 * 用内存屏障通知其他线程i的值
 * 其中前三步是线程不安全的, 可能其他线程会对i进行读写.
 *
 * 因此任何依赖于之前值的操作, 如i++, i = i *10使用volatile都不安全.
 *
 * 而诸如get/set, boolean这类可以使用volatile.
 */
public class CAS {
    private static AtomicInteger atomicInteger=new AtomicInteger(5);
    public static void main(String[] args){
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){

                }
                Integer integer=atomicInteger.decrementAndGet();
                System.out.println("线程"+Thread.currentThread().getName()
                        +"抢了一件商品还剩下："+atomicInteger.get()+"件商品");
                if (integer<1){
                    System.out.println("抢完了");
                    return;
                }
            }).start();
        }
    }
}