package org.example.Store;

import java.util.Scanner;

public class Store {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter customer name:");
    String customerName = scanner.nextLine();

    System.out.println("Enter order number:");
    int orderNumber = scanner.nextInt();

    System.out.println("Enter requested quantity:");
    int requestedQuantity = scanner.nextInt();

    System.out.println("Enter 'unit' for unit price or 'dozen' for dozen price:");
    String unit = scanner.next();

    IPrice priceStrategy;
    if (unit.equalsIgnoreCase("unit")) {
      priceStrategy = new PricePerUnit();
    } else if (unit.equalsIgnoreCase("dozen")) {
      priceStrategy = new PricePerDozen();
    } else {
      System.out.println("Invalid unit. Please enter 'unit' or 'dozen'.");
      return;
    }

    // Initial setup
    Inventory inventory = new Inventory(100, 5.0, 50.0);

    // Client makes a purchase
    Client client = new Client(customerName, orderNumber, priceStrategy, requestedQuantity);
    double purchasePrice = client.makePurchase(inventory);
    System.out.println("Price of purchase: Bs." + purchasePrice);

    scanner.close();
  }
}