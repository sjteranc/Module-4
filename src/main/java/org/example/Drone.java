package org.example;
import java.util.*;

// Definición de la clase Drone que representa un dron
class Drone {
  String name; // Nombre del dron
  int maxWeight; // Peso máximo que puede llevar el dron
  List<String> deliveries; // Lista de entregas que realizará el dron

  // Constructor de la clase Drone
  public Drone(String name, int maxWeight) {
    this.name = name;
    this.maxWeight = maxWeight;
    this.deliveries = new ArrayList<>(); // Inicializa la lista de entregas como una lista vacía
  }

  // Método para agregar una entrega a la lista de entregas del dron
  public void addDelivery(String location, int weight) {
    deliveries.add(location + ", " + weight); // Agrega la ubicación y el peso como una cadena a la lista de entregas
  }
}