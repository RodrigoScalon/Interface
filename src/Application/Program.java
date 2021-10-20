package Application;

import Entities.CarRental;
import Entities.Vehicle;
import Services.BrazilTaxService;
import Services.RentalService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {
        Scanner input = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");

        System.out.println("Enter the rental data: ");
        System.out.print("Car model: ");
        String carModel = input.nextLine();
        System.out.print("Pickup (dd/MM/yyyy hh:ss): ");
        Date start = sdf.parse(input.nextLine());
        System.out.print("Return (dd/MM/yyyy hh:ss): ");
        Date finish = sdf.parse(input.nextLine());

        CarRental carRental = new CarRental(start, finish, new Vehicle(carModel));

        System.out.print("Enter the price per hour: ");
        double pricePerHour = input.nextDouble();
        System.out.print("Enter the price per day: ");
        double pricePerDay = input.nextDouble();

        RentalService rentalService = new RentalService(pricePerDay, pricePerHour, new BrazilTaxService());

        rentalService.processInvoice(carRental);

        System.out.println("INVOICE");
        System.out.println("Basic Payment: " +String.format("%.2f", + carRental.getInvoice().getBasicPayment()));
        System.out.println("Basic Tax: " +String.format("%.2f", + carRental.getInvoice().getTax()));
        System.out.println("Basic Total Payment: " +String.format("%.2f", + carRental.getInvoice().getTotalPayment()));

    input.close();

    }
}
