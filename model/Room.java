/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Room {

    private int roomId;
    private int hotelId;
    private String type;
    private double price;
    private String status;

    // GETTERS
    public int getRoomId() {
        return roomId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    // SETTERS
    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}