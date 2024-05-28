package com.parkingLot.model;

import com.parkingLot.model.ParkingSpot.ParkingSpot;
import com.parkingLot.model.Vehicle.Vehicle;

import java.time.LocalDateTime;

public class ParkingTicket {
    private String ticketNumber;
    private LocalDateTime issueTime;
    private LocalDateTime payTime;
    private double parkingFee;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;

    public ParkingTicket(String ticketNumber, ParkingSpot parkingSpot, Vehicle vehicle) {
        this.ticketNumber = ticketNumber;
        this.issueTime = LocalDateTime.now();
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public LocalDateTime getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(LocalDateTime issueTime) {
        this.issueTime = issueTime;
    }

    public LocalDateTime getPayTime() {
        return payTime;
    }

    public void setPayTime(LocalDateTime payTime) {
        this.payTime = payTime;
    }

    public double getParkingFee() {
        return parkingFee;
    }

    public void setParkingFee(double parkingFee) {
        this.parkingFee = parkingFee;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
}
