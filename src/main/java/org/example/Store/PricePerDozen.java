package org.example.Store;

class PricePerDozen implements IPrice {
  @Override
  public double calculatePrice(int quantity, double unitPrice, double dozenPrice) {
    int dozens = quantity / 12;
    int remainingUnits = quantity % 12;
    return (dozens * dozenPrice) + (remainingUnits * unitPrice);
  }
}