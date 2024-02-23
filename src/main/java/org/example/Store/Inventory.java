package org.example.Store;


class Inventory {
  private int availableQuantity;
  private double unitPrice;
  private double dozenPrice;

  public Inventory(int availableQuantity, double unitPrice, double dozenPrice) {
    this.availableQuantity = availableQuantity;
    this.unitPrice = unitPrice;
    this.dozenPrice = dozenPrice;
  }

  public boolean checkStock(int quantity) {
    return quantity <= availableQuantity;
  }

  public void reduceInventory(int quantity) {
    availableQuantity -= quantity;
  }

  // Accessor methods for unitPrice and dozenPrice
  public double getUnitPrice() {
    return unitPrice;
  }

  public double getDozenPrice() {
    return dozenPrice;
  }
}
