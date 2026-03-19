/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.DBConnection;
import model.Guest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GuestDAO {

    public void addGuest(Guest g){

        try{
            Connection conn = DBConnection.getConnection();

            String sql = "INSERT INTO guests(name,email,phone) VALUES (?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, g.getName());
            ps.setString(2, g.getEmail());
            ps.setString(3, g.getPhone());

            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public List<Guest> getAllGuests(){

        List<Guest> list = new ArrayList<>();

        try{
            Connection conn = DBConnection.getConnection();

            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM guests");

            while(rs.next()){
                Guest g = new Guest();

                g.setGuestId(rs.getInt("guest_id"));
                g.setName(rs.getString("name"));
                g.setEmail(rs.getString("email"));
                g.setPhone(rs.getString("phone"));

                list.add(g);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }

    public void deleteGuest(int id){

        try{
            Connection conn = DBConnection.getConnection();

            PreparedStatement ps = conn.prepareStatement("DELETE FROM guests WHERE guest_id=?");

            ps.setInt(1,id);

            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}