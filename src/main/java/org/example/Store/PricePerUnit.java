package org.example.Store;

class PricePerUnit implements IPrice {
  @Override
  public double calculatePrice(int quantity, double unitPrice, double dozenPrice) {
    return quantity * unitPrice;
  }
}