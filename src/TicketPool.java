import java.util.*;

public class TicketPool {
    private int maximumCapacity;
    private Queue<Ticket> ticketPool;

    TicketPool(){}

    public TicketPool(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
        this.ticketPool = new LinkedList<>();
    }

    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    public void setMaximumCapacity(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    public synchronized void addTicket(Ticket tickets) throws InterruptedException {
        while (ticketPool.size()>= maximumCapacity){
            wait();
        }
        this.ticketPool.add(tickets);
        notifyAll();
        System.out.println(Thread.currentThread().getName()+" has added tickets in the Ticket Pool. Now available size is "+ticketPool.size());
    }

    public synchronized Ticket removeTicket() throws InterruptedException {
        while (ticketPool.isEmpty()){
            wait();
        }
        Ticket ticket = ticketPool.poll();
        notifyAll();
        System.out.println(Thread.currentThread().getName()+" has bought tickets from the Ticket Pool.Now available size is "+ticketPool.size());
        return ticket;
    }
}
