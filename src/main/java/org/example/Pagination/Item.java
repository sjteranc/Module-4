package org.example.Pagination;


class Item implements IListItem {
  private String data;

  public Item(String data) {
    this.data = data;
  }

  @Override
  public String display() {
    return data;
  }
}