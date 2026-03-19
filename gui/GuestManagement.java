/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import dao.GuestDAO;
import model.Guest;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class GuestManagement extends JFrame {

    JTextField name = new JTextField();
    JTextField email = new JTextField();
    JTextField phone = new JTextField();

    JButton add = new JButton("Add Guest");
    JButton delete = new JButton("Delete Guest");

    JTable table;
    DefaultTableModel model;

    GuestDAO dao = new GuestDAO();

    public GuestManagement(){

        setTitle("Guest Management");
        setSize(600,400);
        setLayout(new BorderLayout());

        JPanel top = new JPanel(new GridLayout(4,2));

        top.add(new JLabel("Name"));
        top.add(name);

        top.add(new JLabel("Email"));
        top.add(email);

        top.add(new JLabel("Phone"));
        top.add(phone);

        top.add(add);

        add(top, BorderLayout.NORTH);

        model = new DefaultTableModel(new String[]{"ID","Name","Email","Phone"},0);
        table = new JTable(model);

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(delete, BorderLayout.SOUTH);

        loadGuests();

        add.addActionListener(e -> {

            Guest g = new Guest();
            g.setName(name.getText());
            g.setEmail(email.getText());
            g.setPhone(phone.getText());

            dao.addGuest(g);

            loadGuests();
        });

        delete.addActionListener(e -> {

            int row = table.getSelectedRow();

            if(row != -1){
                int id = (int) model.getValueAt(row,0);
                dao.deleteGuest(id);
                loadGuests();
            }
        });

        setVisible(true);
    }

    private void loadGuests(){

        model.setRowCount(0);

        List<Guest> list = dao.getAllGuests();

        for(Guest g : list){
            model.addRow(new Object[]{
                    g.getGuestId(),
                    g.getName(),
                    g.getEmail(),
                    g.getPhone()
            });
        }
    }
}