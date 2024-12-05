import java.math.BigDecimal;

public class Vendor implements Runnable {

    private TicketPool ticketPool;
    private int totalTickets;
    private int ticketReleaseRate;

    public Vendor(TicketPool ticketPool, int totalTickets, int ticketReleaseRate) {
        this.ticketPool = ticketPool;
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
    }

    @Override
    public void run() {
        for (int i=0;i<=totalTickets;i++){
            Ticket ticket = new Ticket(i,001,"Event 01",new BigDecimal(2000));
            try {
                ticketPool.addTicket(ticket);
                Thread.sleep(ticketReleaseRate * 1000);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
