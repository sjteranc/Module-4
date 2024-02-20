package org.example;

import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;

// Main class containing the main method
public class DroneDelivery {
  public static void main(String[] args) {
    // Sample data
    String[] droneData = {"Drone #1", "100", "Drone #2", "150"}; // Information of drones: name and maximum weight
    String[][] deliveryData = {
            {"Location #1", "20"}, // Information of deliveries: location name and package weight
            {"Location #2", "30"},
            {"Location #3", "40"},
            {"Location #4", "50"},
            {"Location #5", "60"},
            {"Location #6", "70"},
            {"Location #7", "80"}
    };

    // Processing drone data
    List<Drone> drones = new ArrayList<>(); // List to store Drone objects
    for (int i = 0; i < droneData.length; i += 2) {
      String droneName = droneData[i]; // Drone name
      int maxWeight = Integer.parseInt(droneData[i + 1]); // Maximum weight of the drone
      drones.add(new Drone(droneName, maxWeight)); // Create a new Drone object and add it to the drones list
    }

    // Distributing deliveries to drones
    int droneIndex = 0; // Index to track which drone is receiving the deliveries
    for (String[] delivery : deliveryData) {
      String location = delivery[0]; // Delivery location name
      int weight = Integer.parseInt(delivery[1]); // Package weight
      //System.out.println("Prueba" );
      Drone drone = drones.get(droneIndex); // Get the current drone from the drones list
      if (weight <= drone.maxWeight) { // Check if the package weight is less than or equal to the drone's maximum weight
        drone.addDelivery(location, weight); // Add the delivery to the drone
      } else {
        System.out.println("Weight of location exceeds max capacity of " + drone.name);
      }

      droneIndex = (droneIndex + 1) % drones.size(); // Move to the next drone cyclically
    }

    // Printing deliveries for each drone
    for (Drone drone : drones) { // Iterate over each Drone object in the drones list
      System.out.println("Drone: " + drone.name + ", Max Weight: " + drone.maxWeight);
      // Print the drone name and its maximum weight
      int tripNumber = 1; // Trip number
      for (int i = 0; i < drone.deliveries.size(); i++) { // Iterate over the drone's deliveries
        //System.out.println("Entra" );
        if (i % 2 == 0) { // If the index is even, it means a new trip starts
          System.out.println("Trip #" + tripNumber++); // Print the trip number
        }
        System.out.println(drone.deliveries.get(i)); // Print the delivery (location and weight)
      }
    }
  }
}