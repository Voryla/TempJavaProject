package ThreadSafe;

/**
 * 电影院出票
 */
public class BuyCinema {
    public static void main(String[] args){
        Cinema cinema=new Cinema("zwk",2);
        new Thread(new Customer(cinema,2),"jack").start();
        new Thread(new Customer(cinema,1),"voryla").start();
    }
}

class Cinema {
    String cinemaName;
    int ticketTotal;

    public Cinema(String cinemaName, int ticketTotal) {
        this.cinemaName = cinemaName;
        this.ticketTotal = ticketTotal;
    }

    public boolean bookTicket(int seats) {
        if (ticketTotal>=seats) {
            ticketTotal -= seats;
            System.out.println("影院剩余票数"+ticketTotal);
            return true;
        } else {
            return false;
        }
    }
}

class Customer implements Runnable {
    Cinema cinema;
    int seats;

    public Customer(Cinema cinema, int seats) {
        this.cinema = cinema;
        this.seats = seats;
    }

    @Override
    public void run() {
        synchronized (cinema) {
            boolean flag = cinema.bookTicket(seats);
            if (flag) {
                System.out.println(Thread.currentThread().getName() + "出票成功-->>>" + seats + "张");
            } else {
                System.out.println(Thread.currentThread().getName() + "出票失败-->>>");
            }
        }
    }
}