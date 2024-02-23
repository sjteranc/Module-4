import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Clase para gestionar la lista y la paginación
class PaginatedList<T> {
  private List<T> items;
  private int pageSize;
  private int currentPage;

  public PaginatedList() {
    items = new ArrayList<>();
    pageSize = 5; // Tamaño de página predeterminado
    currentPage = 0; // Página inicial
  }

  public void addItem(T item) {
    items.add(item);
  }

  public void setPageSize(int size) {
    pageSize = size;
  }

  public void showPage(int page) {
    int startIndex = page * pageSize;
    int endIndex = Math.min(startIndex + pageSize, items.size());

    if (startIndex >= items.size()) {
      System.out.println("Página no válida.");
      return;
    }

    for (int i = startIndex; i < endIndex; i++) {
      System.out.println(items.get(i));
    }
  }

  public void firstPage() {
    currentPage = 0;
    showPage(currentPage);
  }

  public void lastPage() {
    currentPage = items.size() / pageSize;
    showPage(currentPage);
  }

  public void nextPage() {
    if ((currentPage + 1) * pageSize < items.size()) {
      currentPage++;
      showPage(currentPage);
    } else {
      System.out.println("No hay más páginas.");
    }
  }

  public void prevPage() {
    if (currentPage > 0) {
      currentPage--;
      showPage(currentPage);
    } else {
      System.out.println("Ya estás en la primera página.");
    }
  }
}

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    PaginatedList<String> paginatedList = new PaginatedList<>();

    // Agregar algunos elementos de ejemplo
    paginatedList.addItem("Elemento 1");
    paginatedList.addItem("Elemento 2");
    paginatedList.addItem("Elemento 3");
    paginatedList.addItem("Elemento 4");
    paginatedList.addItem("Elemento 5");
    paginatedList.addItem("Elemento 6");
    paginatedList.addItem("Elemento 7");
    paginatedList.addItem("Elemento 8");
    paginatedList.addItem("Elemento 9");
    paginatedList.addItem("Elemento 10");

    // Bucle principal
    while (true) {
      System.out.println("\nComandos: primero, último, siguiente, prev, ir a <número_página>, salir");
      System.out.print("Ingrese un comando: ");
      String input = scanner.nextLine();

      if (input.equals("primero")) {
        paginatedList.firstPage();
      } else if (input.equals("último")) {
        paginatedList.lastPage();
      } else if (input.equals("siguiente")) {
        paginatedList.nextPage();
      } else if (input.equals("prev")) {
        paginatedList.prevPage();
      } else if (input.startsWith("ir a")) {
        String[] parts = input.split(" ");
        if (parts.length == 3 && parts[1].equals("a")) {
          try {
            int pageNumber = Integer.parseInt(parts[2]) - 1;
            paginatedList.showPage(pageNumber);
          } catch (NumberFormatException e) {
            System.out.println("Número de página no válido.");
          }
        } else {
          System.out.println("Comando no válido.");
        }
      } else if (input.equals("salir")) {
        break;
      } else {
        System.out.println("Comando no válido.");
      }
    }

    scanner.close();
  }
}
