public class Main {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        TicketPool ticketPool = new TicketPool(10);
        Vendor[] vendors = new Vendor[10];
        for (int k=0;k< vendors.length;k++){
            vendors[k] = new Vendor(ticketPool, configuration.getTotalTickets(), configuration.getTicketReleaseRate());
            Thread vendorThread = new Thread(vendors[k],"Vendor- "+k);
            vendorThread.start();
        }
        Customer[] customers = new Customer[10];
        for (int k=0;k< customers.length;k++){
            customers[k] = new Customer(ticketPool,configuration.getCustomerRetrievalRate(),5);
            Thread customerThread = new Thread(customers[k],"Customer- "+k);
            customerThread.start();
        }
    }
}
