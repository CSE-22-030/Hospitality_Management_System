/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.DBConnection;
import java.sql.*;

public class statsDAO {

    public int getCount(String table){

        int count = 0;

        try{
            Connection conn = DBConnection.getConnection();
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM " + table);

            if(rs.next()){
                count = rs.getInt(1);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return count;
    }
}