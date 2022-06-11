package com.uma.parkings.services;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

	List<CompactSpot> vAlCompactSpot= new ArrayList<>();
	List<LargeSpot> vAlLargeSpot= new ArrayList<>();
	List<BikeSpot> vAlBikeSpot= new ArrayList<>();
	
	int vCompactSpotCount;
	int vLargeSpotCount;
	int vBikeSpotCount;
	
	public ParkingLot(int vCompactSpotCount, int vLargeSpotCount, int vBikeSpotCount) {
		super();
		this.vCompactSpotCount = vCompactSpotCount;
		this.vLargeSpotCount = vLargeSpotCount;
		this.vBikeSpotCount = vBikeSpotCount;
	}
	
	public void parkVehicle(Vehicles pVehicles) {
		System.out.print("Park new Vehicle..... ");
		if(pVehicles.getvParkingSpot() == null) {
			if(pVehicles.getvVehicleType().equals(VehicleType.TRUCK)) {
				if(vLargeSpotCount > 0) {
					parkLargeVehicle(pVehicles);
				}
				else {
					System.out.println("No spot available for trucks.");
				}
			}
			else if(pVehicles.getvVehicleType().equals(VehicleType.CAR)) {
				if(vCompactSpotCount > 0) {
					parkCompactVehicle(pVehicles);
				}
				else if(vLargeSpotCount > 0) {
					parkLargeVehicle(pVehicles);
				}
				else {
					System.out.println("No spot available for cars.");
				}
			}
			else if(pVehicles.getvVehicleType().equals(VehicleType.BIKE)) {
				if(vBikeSpotCount > 0) {
					parkBikeVehicle(pVehicles);
				}
				else if(vCompactSpotCount > 0) {
					parkCompactVehicle(pVehicles);
				}
				else if(vLargeSpotCount > 0) {
					parkLargeVehicle(pVehicles);
				}
				else {
					System.out.println("No spot available for bikes.");
				}
			}
		}
		else {
			System.out.println("Vehicle is already parked.");
		}
	}

	private void parkLargeVehicle(Vehicles pVehicles) {
		LargeSpot vLargeSpot= new LargeSpot(ParkingSpotType.LARGE);
		vLargeSpot.setbFree(false);
		vLargeSpot.setoVehicles(pVehicles);
		pVehicles.setvParkingSpot(vLargeSpot);
		vAlLargeSpot.add(vLargeSpot);
		vLargeSpotCount--;
		System.out.println("Vehicle is parked "+ pVehicles.getvVehicleType() + " vehicle.");
	}

	private void parkCompactVehicle(Vehicles pVehicles) {
		CompactSpot vCompactSpot= new CompactSpot(ParkingSpotType.COMPACT);
		vCompactSpot.setbFree(false);
		vCompactSpot.setoVehicles(pVehicles);
		pVehicles.setvParkingSpot(vCompactSpot);
		vAlCompactSpot.add(vCompactSpot);
		vCompactSpotCount--;
		System.out.println("Vehicle is parked "+ pVehicles.getvVehicleType() + " vehicle.");
	}

	private void parkBikeVehicle(Vehicles pVehicles) {
		BikeSpot vBikeSpot= new BikeSpot(ParkingSpotType.BIKE);
		vBikeSpot.setbFree(false);
		vBikeSpot.setoVehicles(pVehicles);
		pVehicles.setvParkingSpot(vBikeSpot);
		vAlBikeSpot.add(vBikeSpot);
		vBikeSpotCount--;
		System.out.println("Vehicle is parked "+ pVehicles.getvVehicleType() + " vehicle.");
	}
	
	
	public void unParkVehicle(Vehicles pVehicles) {
		System.out.print("Unpark parked Vehicle.....");
		ParkingSpot vParkingSpot= pVehicles.getvParkingSpot();
		if(vParkingSpot != null) {
			vParkingSpot.setbFree(true);
			if(pVehicles.getvVehicleType().equals(VehicleType.TRUCK)) {
				if(vAlLargeSpot.remove(vParkingSpot)) {
					vLargeSpotCount++;
					System.out.println("Truck is unParked.");
				}
				else {
					System.out.println("Truck is not parked at this spot.");
				}
			}
			else if(pVehicles.getvVehicleType().equals(VehicleType.CAR)) {
				if(vAlCompactSpot.remove(vParkingSpot)) {
					vCompactSpotCount++;
					System.out.println("Car is unParked.");
				}
				else if(vAlLargeSpot.remove(vParkingSpot)) {
					vLargeSpotCount++;
					System.out.println("Car is unParked.");
				}
				else {
					System.out.println("Car is not parked at this spot.");
				}
			}
			else if(pVehicles.getvVehicleType().equals(VehicleType.BIKE)) {
				if(vAlBikeSpot.remove(vParkingSpot)) {
					vBikeSpotCount++;
					System.out.println("Bike is unParked.");
				}
				else if(vAlCompactSpot.remove(vParkingSpot)) {
					vCompactSpotCount++;
					System.out.println("Bike is unParked.");
				}
				else if(vAlLargeSpot.remove(vParkingSpot)) {
					vLargeSpotCount++;
					System.out.println("Bike is unParked.");
				}
				else {
					System.out.println("Bike is not parked at this spot.");
				}
			}
		}
		else {
			System.out.println("Vehicle is not parked.");
		}
	}
	
}
