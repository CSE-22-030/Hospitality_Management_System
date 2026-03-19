/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Reservation {

    private int reservationId;
    private int guestId;
    private int roomId;
    private String checkIn;
    private String checkOut;
    private double totalAmount;

    // GETTERS
    public int getReservationId() {
        return reservationId;
    }

    public int getGuestId() {
        return guestId;
    }

    public int getRoomId() {
        return roomId;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    // SETTERS
    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    // OPTIONAL (for your DAO error)
    public int getDays() {
        return 1; // simple placeholder (you can improve later)
    }
}