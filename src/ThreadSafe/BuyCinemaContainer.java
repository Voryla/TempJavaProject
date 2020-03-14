package ThreadSafe;

import java.util.ArrayList;
import java.util.List;

public class BuyCinemaContainer {
    public static void main(String[] args){
        List<Integer> ticketTotal=new ArrayList<Integer>();
        ticketTotal.add(1);
        ticketTotal.add(2);
        ticketTotal.add(3);
        ticketTotal.add(4);
        ticketTotal.add(5);
        ticketTotal.add(6);
        CinemaContainer cinemaContainer=new CinemaContainer(ticketTotal,"方逸");
        ArrayList<Integer> zwkSeats=new ArrayList<Integer>();
        zwkSeats.add(1);
        zwkSeats.add(3);
        ArrayList<Integer> mmrSeats=new ArrayList<Integer>();
        mmrSeats.add(2);
        mmrSeats.add(4);
        new Thread(new Customers(cinemaContainer,zwkSeats),"zwk").start();
        new Thread(new Customers(cinemaContainer,mmrSeats),"mmr").start();
    }
}
class CinemaContainer {
    List<Integer> ticketTotal;
    String CinemaName;
    public CinemaContainer(List<Integer> ticketTotal,String CinemaName){
        this.ticketTotal=ticketTotal;
        this.CinemaName=CinemaName;
    }
    public boolean bookTicket(List<Integer> seats){
        List<Integer> copy=new ArrayList<Integer>();
        copy.addAll(ticketTotal);
        System.out.println(CinemaName+"影院当前余票-->>"+ticketTotal.toString());
        System.out.println(CinemaName+"影院：选购位置为："+seats.toString());
        //如果已有的票小于所购的票
        if(ticketTotal.size()<seats.size()) return false;
        ticketTotal.removeAll(seats);
        if(copy.size()-ticketTotal.size()==seats.size()){
            System.out.println(CinemaName+"影院：购票成功!影院剩余位置为："+ticketTotal.toString());
            return true;
        }else{
            ticketTotal=copy;
            return false;
        }
    }
}
class Customers implements Runnable{
    CinemaContainer cinemaContainer;
    List<Integer> seats;
    public Customers(CinemaContainer cinemaContainer,List<Integer> seats){
        this.cinemaContainer=cinemaContainer;
        this.seats=seats;
    }
    @Override
    public void run() {
        synchronized(cinemaContainer){
            boolean flag=cinemaContainer.bookTicket(seats);
            if(flag){
                System.out.println(Thread.currentThread().getName()+"购票成功!");
            }else {
                System.out.println(cinemaContainer.CinemaName+"影院：购票失败!影院剩余位置为："+cinemaContainer.ticketTotal.toString());
            }
        }
    }
}
