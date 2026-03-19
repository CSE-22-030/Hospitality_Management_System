/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.DBConnection;
import model.Room;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {

    public void addRoom(Room r){

        try{
            Connection conn = DBConnection.getConnection();

            String sql = "INSERT INTO rooms(hotel_id,room_type,price,status) VALUES (?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, r.getHotelId());
            ps.setString(2, r.getType());
            ps.setDouble(3, r.getPrice());
            ps.setString(4, r.getStatus());

            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public List<Room> getAllRooms(){

        List<Room> list = new ArrayList<>();

        try{
            Connection conn = DBConnection.getConnection();

            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM rooms");

            while(rs.next()){
                Room r = new Room();

                r.setRoomId(rs.getInt("room_id"));
                r.setHotelId(rs.getInt("hotel_id"));
                r.setType(rs.getString("room_type"));
                r.setPrice(rs.getDouble("price"));
                r.setStatus(rs.getString("status"));

                list.add(r);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }

    public void deleteRoom(int id){

        try{
            Connection conn = DBConnection.getConnection();

            PreparedStatement ps = conn.prepareStatement("DELETE FROM rooms WHERE room_id=?");

            ps.setInt(1,id);

            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}