package org.example.Pagination;

// Clase para manejar la paginación
class Pagination {
  private int currentPage;
  private int totalPages;

  public Pagination() {
    currentPage = 1;
    totalPages = 1;
  }

  public void setCurrentPage(int currentPage) {
    this.currentPage = currentPage;
  }

  public void setTotalPages(int totalPages) {
    this.totalPages = totalPages;
  }

  public int getCurrentPage() {
    return currentPage;
  }

  public int getTotalPages() {
    return totalPages;
  }
}
