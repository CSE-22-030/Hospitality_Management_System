/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.DBConnection;
import model.Hotel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelDAO {

    // ADD HOTEL
    public void addHotel(Hotel hotel) {

        try {

            Connection conn = DBConnection.getConnection();

            if(conn == null){
                System.out.println("Connection failed!");
                return;
            }

            String sql = "INSERT INTO hotels(name, location, amenities) VALUES(?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, hotel.getName());
            ps.setString(2, hotel.getLocation());
            ps.setString(3, hotel.getAmenities());

            int rows = ps.executeUpdate();

            System.out.println("Rows inserted: " + rows);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // GET ALL HOTELS
    public List<Hotel> getAllHotels(){

        List<Hotel> hotels = new ArrayList<>();

        try{

            Connection conn = DBConnection.getConnection();

            // DEBUG TEST
            ResultSet rsTest = conn.createStatement().executeQuery("SELECT COUNT(*) FROM hotels");

            if(rsTest.next()){
                System.out.println("Rows in DB: " + rsTest.getInt(1));
            }

            String sql = "SELECT * FROM hotels";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Hotel h = new Hotel();

                h.setHotelId(rs.getInt("hotel_id"));
                h.setName(rs.getString("name"));
                h.setLocation(rs.getString("location"));
                h.setAmenities(rs.getString("amenities"));

                hotels.add(h);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return hotels;
    }
    // UPDATE HOTEL
    public void updateHotel(Hotel hotel) {

        try {

            Connection conn = DBConnection.getConnection();

            String sql = "UPDATE hotels SET name=?, location=?, amenities=? WHERE hotel_id=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, hotel.getName());
            ps.setString(2, hotel.getLocation());
            ps.setString(3, hotel.getAmenities());
            ps.setInt(4, hotel.getHotelId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // DELETE HOTEL
    public void deleteHotel(int id) {

        try {

            Connection conn = DBConnection.getConnection();

            String sql = "DELETE FROM hotels WHERE hotel_id=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // SEARCH HOTEL
    public List<Hotel> searchHotel(String keyword) {

        List<Hotel> hotels = new ArrayList<>();

        try {

            Connection conn = DBConnection.getConnection();

            String sql = "SELECT * FROM hotels WHERE name LIKE ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Hotel h = new Hotel();

                h.setHotelId(rs.getInt("hotel_id"));
                h.setName(rs.getString("name"));
                h.setLocation(rs.getString("location"));
                h.setAmenities(rs.getString("amenities"));

                hotels.add(h);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return hotels;
    }

}