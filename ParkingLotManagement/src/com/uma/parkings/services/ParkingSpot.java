package com.uma.parkings.services;

public class ParkingSpot {

	private ParkingSpotType oParkingSpotType;
	private Vehicles oVehicles;
	private boolean bFree;
	
	public ParkingSpot(ParkingSpotType pParkingSpotType) {
		this.oParkingSpotType= pParkingSpotType;
	}
	
	public ParkingSpotType getoParkingSpotType() {
		return oParkingSpotType;
	}
	public void setoParkingSpotType(ParkingSpotType oParkingSpotType) {
		this.oParkingSpotType = oParkingSpotType;
	}
	public Vehicles getoVehicles() {
		return oVehicles;
	}
	public void setoVehicles(Vehicles oVehicles) {
		this.oVehicles = oVehicles;
	}
	public boolean isbFree() {
		return bFree;
	}
	public void setbFree(boolean bFree) {
		this.bFree = bFree;
	}
}
