package com.uma.parkings.services;

public class Client {

	public static void main(String[] args) {
		int vCompactSpots= 2;
		int vBikeSpots= 2;
		int vLargeSpots= 2;
		ParkingLot vParkingLot= new ParkingLot(vCompactSpots, vLargeSpots, vBikeSpots);
		
		Vehicles vTruck1= new Vehicles(VehicleType.TRUCK);
		Vehicles vTruck2= new Vehicles(VehicleType.TRUCK);
		
		Vehicles vCar1= new Vehicles(VehicleType.CAR);
		Vehicles vCar2= new Vehicles(VehicleType.CAR);
		Vehicles vCar3= new Vehicles(VehicleType.CAR);
		
		Vehicles vBike1= new Vehicles(VehicleType.BIKE);
		Vehicles vBike2= new Vehicles(VehicleType.BIKE);
		Vehicles vBike3= new Vehicles(VehicleType.BIKE);
		
		
		vParkingLot.parkVehicle(vTruck1);
		vParkingLot.parkVehicle(vCar1);
		vParkingLot.parkVehicle(vCar2);
		vParkingLot.parkVehicle(vBike1);
		vParkingLot.parkVehicle(vBike2);
		vParkingLot.parkVehicle(vBike3);
		vParkingLot.parkVehicle(vCar2);
		vParkingLot.parkVehicle(vTruck2);
		vParkingLot.parkVehicle(vCar3);
		
		vParkingLot.unParkVehicle(vCar3);
		vParkingLot.unParkVehicle(vBike3);
		vParkingLot.unParkVehicle(vBike3);
		
		vParkingLot.parkVehicle(vTruck2);
		vParkingLot.parkVehicle(vCar3);
		
		
	}
}
