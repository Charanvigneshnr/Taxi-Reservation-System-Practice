package TaxiReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Taxi Reservation System");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of taxis: ");
        int numberOfTaxis = sc.nextInt();
        Reservation r = new Reservation(numberOfTaxis);
        int customerId = 0;
        int input = 0;
        while (input!=3){
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("1. Book Taxi\n2. View Taxis\n3. Exit");
            System.out.print("Enter option: ");
            input = sc.nextInt();
            System.out.println("--------------------------------------------------------------------------------------");

            switch (input){
                case 1:
                    System.out.println("Book Taxi");
                    System.out.print("Enter pickup point (A, B, C, D, E, F): ");
                    char pickUpPoint = sc.next().charAt(0);
                    if (pickUpPoint<'A'||pickUpPoint>'F'){
                        System.out.println("Enter valid pickup point (A, B, C, D, E, F)");
                        break;
                    }
                    System.out.print("Enter drop point (A, B, C, D, E, F): ");
                    char dropPoint = sc.next().charAt(0);
                    if (dropPoint<'A'||dropPoint>'F'){
                        System.out.println("Enter valid drop point (A, B, C, D, E, F)");
                        break;
                    }
                    if (pickUpPoint>=dropPoint){
                        System.out.println("Invalid Pickup and drop points!");
                        break;
                    }
                    System.out.print("Enter pickup time (Operating hours: 1 PM to 9 PM): ");
                    int time = sc.nextInt();
                    if (time<1||time>9){
                        System.out.println("Out of service!");
                        break;
                    }
                    Customer c = new Customer(++customerId,pickUpPoint,dropPoint,time);
                    r.bookTaxi(c);
                    System.out.format("Taxi booked!");
                    break;
                case 2:
                    System.out.println("Taxi Status");
                    System.out.println(" Customer ID | Taxi ID | Pickup Point | Drop Point | Pickup Time | Drop Time | Income ");
                    System.out.println("--------------------------------------------------------------------------------------");
                    r.printDetials();
                    break;
                case 3:
                    System.out.println("Program exitting!");
                    break;
                default:
                    System.out.println("Enter a valid input");
            }
            numberOfTaxis--;
            System.out.println();
        }
    }
}