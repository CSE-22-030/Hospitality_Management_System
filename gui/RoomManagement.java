/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import dao.RoomDAO;
import model.Room;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class RoomManagement extends JFrame {

    JTextField hotelId = new JTextField();
    JTextField type = new JTextField();
    JTextField price = new JTextField();
    JTextField status = new JTextField();

    JButton add = new JButton("Add Room");
    JButton delete = new JButton("Delete Room");

    JTable table;
    DefaultTableModel model;

    RoomDAO dao = new RoomDAO();

    public RoomManagement(){

        setTitle("Room Management");
        setSize(600,400);
        setLayout(new BorderLayout());

        JPanel top = new JPanel(new GridLayout(5,2));

        top.add(new JLabel("Hotel ID"));
        top.add(hotelId);

        top.add(new JLabel("Type"));
        top.add(type);

        top.add(new JLabel("Price"));
        top.add(price);

        top.add(new JLabel("Status"));
        top.add(status);

        top.add(add);
        add(top, BorderLayout.NORTH);

        model = new DefaultTableModel(new String[]{"ID","HotelId","Type","Price","Status"},0);
        table = new JTable(model);

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(delete, BorderLayout.SOUTH);

        loadRooms();

        add.addActionListener(e -> {

            Room r = new Room();
            r.setHotelId(Integer.parseInt(hotelId.getText()));
            r.setType(type.getText());
            r.setPrice(Double.parseDouble(price.getText()));
            r.setStatus(status.getText());

            dao.addRoom(r);

            loadRooms();
        });

        delete.addActionListener(e -> {

            int row = table.getSelectedRow();

            if(row != -1){
                int id = (int) model.getValueAt(row,0);
                dao.deleteRoom(id);
                loadRooms();
            }
        });

        setVisible(true);
    }

    private void loadRooms(){

        model.setRowCount(0);

        List<Room> list = dao.getAllRooms();

        for(Room r : list){
            model.addRow(new Object[]{
                    r.getRoomId(),
                    r.getHotelId(),
                    r.getType(),
                    r.getPrice(),
                    r.getStatus()
            });
        }
    }
}