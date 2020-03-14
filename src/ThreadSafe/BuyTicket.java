package ThreadSafe;

/**
 * 英语单词：
 * Total 总数
 * Ticket 票
 * safe 安全
 */
public class BuyTicket {
    public static void main(String[] args) {
        BuyTicketService buyTicketService = new BuyTicketService();
        new Thread(buyTicketService, "美团").start();
        new Thread(buyTicketService, "携程").start();
        new Thread(buyTicketService, "智行").start();
    }
}

class BuyTicketService implements Runnable {
    int ticketTotal = 10;
    boolean flag = true;

    @Override
    public void run() {
        buy01();
    }

    /**
     * 直接锁定方法效率较低
     */
    private synchronized void buy() {
        while (this.flag) {
            if (ticketTotal < 1) {
                this.flag = false;
                return;
            }
            System.out.println(Thread.currentThread().getName() + "获得-->>第" + this.ticketTotal + "张票");
            this.ticketTotal--;
//                try {
//                    wait(200);
//                } catch (InterruptedException e) {
//                }


        }
    }

    /**
     * 双重检测，保证效率，和安全性
     */
    private void buy01() {
        while (this.flag) {
            if (ticketTotal < 1) {
                this.flag = false;
                return;
            }
            synchronized (this) {
                if (ticketTotal < 1) {
                    this.flag = false;
                    return;
                }
                System.out.println(Thread.currentThread().getName() + "获得-->>第" + this.ticketTotal + "张票");
                this.ticketTotal--;
//                try {
//                    wait(200);
//                } catch (InterruptedException e) {
//                }
            }

        }
    }

}
