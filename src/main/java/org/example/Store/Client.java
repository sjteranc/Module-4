package org.example.Store;

class Client {
  private String name;
  private int orderNumber;
  private IPrice priceStrategy;
  private int requestedQuantity;

  public Client(String name, int orderNumber, IPrice priceStrategy, int requestedQuantity) {
    this.name = name;
    this.orderNumber = orderNumber;
    this.priceStrategy = priceStrategy;
    this.requestedQuantity = requestedQuantity;
  }

  public double makePurchase(Inventory inventory) {
    if (inventory.checkStock(requestedQuantity)) {
      double finalPrice = priceStrategy.calculatePrice(requestedQuantity, inventory.getUnitPrice(), inventory.getDozenPrice());
      inventory.reduceInventory(requestedQuantity);
      return finalPrice;
    } else {
      System.out.println("Insufficient stock available.");
      return 0.0;
    }
  }
}
