package com.uma.parkings.services;

public class Vehicles {

	private int vVehicleNo;
	private VehicleType vVehicleType;
	private ParkingSpot vParkingSpot;
	
	public Vehicles(VehicleType vVehicleType) {
		super();
		this.vVehicleType = vVehicleType;
	}
	
	public int getvVehicleNo() {
		return vVehicleNo;
	}
	public void setvVehicleNo(int vVehicleNo) {
		this.vVehicleNo = vVehicleNo;
	}
	public VehicleType getvVehicleType() {
		return vVehicleType;
	}
	public void setvVehicleType(VehicleType vVehicleType) {
		this.vVehicleType = vVehicleType;
	}
	public ParkingSpot getvParkingSpot() {
		return vParkingSpot;
	}
	public void setvParkingSpot(ParkingSpot vParkingSpot) {
		this.vParkingSpot = vParkingSpot;
	}
	
	
	
}
