# Vehicle Rental System (Java Console App)

This is a beginner-friendly MCA mini-project that demonstrates core **Object-Oriented Programming (OOP)** concepts using a console-based vehicle rental system.

## Features

- Vehicle hierarchy using inheritance:
  - `Vehicle` (abstract parent class)
  - `Car` and `Bike` (child classes with method overriding)
- Customer and rental management:
  - `Customer` with driving license validation
  - `Rental` with cost calculation and rental status handling
- OOP concepts demonstrated:
  - Encapsulation (private fields with getters/setters)
  - Inheritance (`Car`, `Bike` from `Vehicle`)
  - Polymorphism (`getVehicleType()` and overridden `toString()`)
  - Constructor overloading (e.g., `Vehicle`, `Customer`)
  - Method overriding (`toString()` in child classes)
- Uses `ArrayList` for vehicles, customers, and rentals
- Menu-driven console interface using `Scanner`
- Includes validations for:
  - Duplicate IDs
  - Invalid license format
  - Invalid rental duration
  - Renting unavailable vehicles
  - Invalid rental state transitions (complete/cancel)

## Project Structure

All source files are in:

`/home/runner/work/Vehicle-Rental-System/Vehicle-Rental-System/src`

Main classes:

- `Vehicle.java`
- `Car.java`
- `Bike.java`
- `Customer.java`
- `Rental.java`
- `Main.java`

## How to Compile and Run

From the repository root (`/home/runner/work/Vehicle-Rental-System/Vehicle-Rental-System`):

```bash
javac src/*.java
java -cp src Main
```

## Usage

When the program starts, it loads predefined sample vehicles and customers.

Use menu options to:

1. List all vehicles
2. Search vehicle by ID
3. List customers
4. Rent a vehicle
5. Return a vehicle
6. Cancel a rental
7. List rentals
0. Exit
