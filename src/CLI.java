import java.util.Scanner;

public class CLI {

    public static Configuration configureSystem(){
        Scanner scanner = new Scanner(System.in);

        int totalTickets = validInput(scanner,"Enter total number of tickets: ");
        int ticketReleaseRate = validRate(scanner,"Enter tickets release rate: ");
        int customerRetrievalRate = validRate(scanner,"Enter customer retrieval rate: ");
        int maxTicketCapacity = validInput(scanner,"Enter maximum ticket capacity: ");

        Configuration configuration = new Configuration(totalTickets,maxTicketCapacity,ticketReleaseRate,customerRetrievalRate);

        String jsonFilePath = "configuration.json";
        configuration.saveToJson(jsonFilePath);

        String textFilePath = "configuration.txt";
        configuration.saveToTextFile(textFilePath);

        return new Configuration(totalTickets,maxTicketCapacity,ticketReleaseRate,customerRetrievalRate);
    }


    private static int validInput(Scanner scanner, String prompt){
        int value;
        System.out.println(prompt);
        while (true){
            if (scanner.hasNextInt()){
                value = scanner.nextInt();
                if (value> 0){
                    return value;
                }else {
                    System.out.println("Please input positive value!!");
                }
            }else {
                System.out.println("Input is invalid!! Input valid integer.");
                scanner.next();
            }
        }
    }

    private static int validRate(Scanner scanner, String prompt){
        int rate = 0;
        while (true) {
            System.out.println(prompt);
            if (scanner.hasNextDouble()) {
                rate = scanner.nextInt();
                if (rate >= 0 && rate <= 100) {
                    return rate;
                } else {
                    System.out.println("Rate should be between 0 and 100.");
                }
            } else {
                System.out.println("Please enter a valid number.");
                scanner.next();
            }
        }
    }
}
