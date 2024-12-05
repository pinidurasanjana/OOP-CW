public class Customer implements Runnable{

    private TicketPool ticketPool;
    private int customerRetrievalRate;
    private int quantity;

    public Customer(TicketPool ticketPool, int customerRetrievalRate, int quantity) {
        this.ticketPool = ticketPool;
        this.customerRetrievalRate = customerRetrievalRate;
        this.quantity = quantity;
    }

    @Override
    public void run() {
        for (int j=0;j<=quantity;j++){
            try {
                Ticket ticket = ticketPool.removeTicket();
                System.out.println(Thread.currentThread().getName() +" Ticket is " + ticket );
                Thread.sleep(customerRetrievalRate * 1000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " failed to purchase tickets.");
                throw new RuntimeException(e);

            }



        }
    }
}
