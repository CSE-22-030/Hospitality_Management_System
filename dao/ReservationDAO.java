/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.DBConnection;
import model.Reservation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {

    public void addReservation(Reservation r){

        try{
            Connection conn = DBConnection.getConnection();

            String sql = "INSERT INTO reservations(guest_id,room_id,check_in,check_out,total_amount) VALUES (?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, r.getGuestId());
            ps.setInt(2, r.getRoomId());
            ps.setString(3, r.getCheckIn());
            ps.setString(4, r.getCheckOut());
            ps.setDouble(5, r.getTotalAmount());

            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public List<Reservation> getAllReservations(){

        List<Reservation> list = new ArrayList<>();

        try{
            Connection conn = DBConnection.getConnection();

            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM reservations");

            while(rs.next()){
                Reservation r = new Reservation();

                r.setReservationId(rs.getInt("reservation_id"));
                r.setGuestId(rs.getInt("guest_id"));
                r.setRoomId(rs.getInt("room_id"));
                r.setCheckIn(rs.getString("check_in"));
                r.setCheckOut(rs.getString("check_out"));
                r.setTotalAmount(rs.getDouble("total_amount"));

                list.add(r);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }

    public void deleteReservation(int id){

        try{
            Connection conn = DBConnection.getConnection();

            PreparedStatement ps = conn.prepareStatement("DELETE FROM reservations WHERE reservation_id=?");

            ps.setInt(1,id);

            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}