package org.example.Pagination;

import java.util.ArrayList;
import java.util.List;

class ListManager implements IListManager {
  private final List<IListItem> items;
  private final int pageSize;

  public ListManager() {
    items = new ArrayList<>();
    pageSize = 5;
  }

  @Override
  public void addItem(String item) {
    items.add(new Item(item));
  }

  @Override
  public void displayPage(int pageNumber) {
    int startIndex = (pageNumber - 1) * pageSize;
    int endIndex = Math.min(startIndex + pageSize, items.size());

    System.out.println("Page " + pageNumber + ":");
    for (int i = startIndex; i < endIndex; i++) {
      System.out.println(items.get(i).display());
    }
    if (endIndex == items.size() && items.size() % pageSize == 0) {
      System.out.println("Page is full. Press 'next' to create a new page.");
    }
  }
  public int getTotalPages() {
    return (int) Math.ceil((double) items.size() / pageSize);
  }
}

