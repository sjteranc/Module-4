# Drone Delivery Code Guide

## Introduction

This guide explains the functionality of the `DroneDelivery.java` code. The code simulates a scenario where drones are tasked with delivering packages to different locations efficiently.

## Code Overview

The code consists of two classes: `Drone` and `DroneDelivery`.

### Drone Class

- The `Drone` class represents a drone with attributes such as name, maximum weight capacity, and a list of deliveries.
- It contains a constructor to initialize a drone object and a method to add deliveries to its list.

### DroneDelivery Class

- The `DroneDelivery` class contains the main method responsible for driving the delivery simulation.
- It reads input data regarding drones and delivery locations, distributes deliveries among drones, and prints the delivery schedule for each drone.

## Execution Flow

1. **Data Initialization**: Drone and delivery data are provided as arrays of strings containing drone names, maximum weights, and delivery locations with corresponding package weights.
2. **Drone Initialization**: Drone objects are created based on the provided data and stored in a list.
3. **Delivery Distribution**: Deliveries are assigned to drones based on their maximum weight capacity. Each delivery is associated with a location and a package weight. If a delivery exceeds the drone's maximum weight capacity, a warning message is displayed.
4. **Printing Deliveries**: The delivery schedule for each drone is printed. For each drone, it prints the drone name, maximum weight capacity, and the list of deliveries organized by trip number.
