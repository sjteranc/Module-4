package org.example.Pagination;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ListManager listManager = new ListManager();
    Pagination pagination = new Pagination();

    boolean exit = false;

    while (!exit) {
      System.out.println("Commands: add <item>, display, first, last, next, prev, goto <page>, exit");
      System.out.print("Enter command: ");
      String command = scanner.next();

      switch (command) {
        case "add":
          listManager.addItem(scanner.nextLine().trim());
          break;
        case "display":
          listManager.displayPage(pagination.getCurrentPage());
          break;
        case "first":
          pagination.setCurrentPage(1);
          listManager.displayPage(pagination.getCurrentPage());
          break;
        case "last":
          pagination.setCurrentPage(pagination.getTotalPages());
          listManager.displayPage(pagination.getCurrentPage());
          break;
        case "next":
          if (pagination.getCurrentPage() < pagination.getTotalPages()) {
            pagination.setCurrentPage(pagination.getCurrentPage() + 1);
            listManager.displayPage(pagination.getCurrentPage());
          } else {
            System.out.println("Already on the last page.");
          }
          break;
        case "prev":
          if (pagination.getCurrentPage() > 1) {
            pagination.setCurrentPage(pagination.getCurrentPage() - 1);
            listManager.displayPage(pagination.getCurrentPage());
          } else {
            System.out.println("Already on the first page.");
          }
          break;
        case "goto":
          int page = scanner.nextInt();
          if (page >= 1 && page <= pagination.getTotalPages()) {
            pagination.setCurrentPage(page);
            listManager.displayPage(pagination.getCurrentPage());
          } else {
            System.out.println("Invalid page number.");
          }
          break;
        case "exit":
          exit = true;
          break;
        default:
          System.out.println("Invalid command.");
      }
    }

    scanner.close();
  }
}