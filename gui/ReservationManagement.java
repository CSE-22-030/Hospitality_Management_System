/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import dao.ReservationDAO;
import model.Reservation;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.List;

public class ReservationManagement extends JFrame {

    JTextField guestId = new JTextField();
    JTextField roomId = new JTextField();
    JTextField amount = new JTextField();

    JDateChooser checkIn = new JDateChooser();
    JDateChooser checkOut = new JDateChooser();

    JButton add = new JButton("Add Reservation");
    JButton delete = new JButton("Delete Reservation");

    JTable table;
    DefaultTableModel model;

    ReservationDAO dao = new ReservationDAO();

    public ReservationManagement(){

        setTitle("Reservation Management");
        setSize(700,400);
        setLayout(new BorderLayout());

        JPanel top = new JPanel(new GridLayout(6,2));

        top.add(new JLabel("Guest ID"));
        top.add(guestId);

        top.add(new JLabel("Room ID"));
        top.add(roomId);

        top.add(new JLabel("Check In"));
        top.add(checkIn);

        top.add(new JLabel("Check Out"));
        top.add(checkOut);

        top.add(new JLabel("Amount"));
        top.add(amount);

        top.add(add);

        add(top, BorderLayout.NORTH);

        model = new DefaultTableModel(
                new String[]{"ID","Guest","Room","CheckIn","CheckOut","Amount"},0);

        table = new JTable(model);

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(delete, BorderLayout.SOUTH);

        loadReservations();

        add.addActionListener(e -> {

            try {

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                Reservation r = new Reservation();

                r.setGuestId(Integer.parseInt(guestId.getText()));
                r.setRoomId(Integer.parseInt(roomId.getText()));
                r.setCheckIn(sdf.format(checkIn.getDate()));
                r.setCheckOut(sdf.format(checkOut.getDate()));
                r.setTotalAmount(Double.parseDouble(amount.getText()));

                dao.addReservation(r);

                JOptionPane.showMessageDialog(this,"Reservation Added");

                loadReservations();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,"Invalid Data");
            }
        });

        delete.addActionListener(e -> {

            int row = table.getSelectedRow();

            if(row != -1){
                int id = (int) model.getValueAt(row,0);
                dao.deleteReservation(id);
                loadReservations();
            }
        });

        setVisible(true);
    }

    private void loadReservations(){

        model.setRowCount(0);

        List<Reservation> list = dao.getAllReservations();

        for(Reservation r : list){
            model.addRow(new Object[]{
                    r.getReservationId(),
                    r.getGuestId(),
                    r.getRoomId(),
                    r.getCheckIn(),
                    r.getCheckOut(),
                    r.getTotalAmount()
            });
        }
    }
}