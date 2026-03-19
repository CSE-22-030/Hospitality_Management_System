/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import dao.HotelDAO;
import model.Hotel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.List;

public class HotelManagement extends JFrame {

    JTextField nameField = new JTextField();
    JTextField locationField = new JTextField();
    JTextField amenitiesField = new JTextField();
    JTextField searchField = new JTextField();

    JButton addBtn = new JButton("Add Hotel");
    JButton updateBtn = new JButton("Update Hotel");
    JButton deleteBtn = new JButton("Delete Hotel");

    JTable table;
    DefaultTableModel model;

    HotelDAO dao = new HotelDAO();

    public HotelManagement() {

        setTitle("Hotel Management");
        setSize(700,500);
        setLayout(new BorderLayout());

        // TOP PANEL (FORM)
        JPanel top = new JPanel(new GridLayout(4,2));

        top.add(new JLabel("Name"));
        top.add(nameField);

        top.add(new JLabel("Location"));
        top.add(locationField);

        top.add(new JLabel("Amenities"));
        top.add(amenitiesField);

        top.add(addBtn);
        top.add(updateBtn);

        add(top, BorderLayout.NORTH);

        // TABLE
        model = new DefaultTableModel(new String[]{"ID","Name","Location","Amenities"},0);
        table = new JTable(model);

        add(new JScrollPane(table), BorderLayout.CENTER);

        // BOTTOM PANEL
        JPanel bottom = new JPanel(new BorderLayout());

        bottom.add(new JLabel("Search: "), BorderLayout.WEST);
        bottom.add(searchField, BorderLayout.CENTER);
        bottom.add(deleteBtn, BorderLayout.EAST);

        add(bottom, BorderLayout.SOUTH);

        // LOAD DATA
        loadHotels();

        // ADD HOTEL
        addBtn.addActionListener(e -> {

            Hotel h = new Hotel();
            h.setName(nameField.getText());
            h.setLocation(locationField.getText());
            h.setAmenities(amenitiesField.getText());

            dao.addHotel(h);

            JOptionPane.showMessageDialog(this,"Hotel Added");

            loadHotels();
        });

        // TABLE CLICK (fill form)
        table.getSelectionModel().addListSelectionListener(e -> {

            int row = table.getSelectedRow();

            if(row >= 0){
                nameField.setText(model.getValueAt(row,1).toString());
                locationField.setText(model.getValueAt(row,2).toString());
                amenitiesField.setText(model.getValueAt(row,3).toString());
            }
        });

        // UPDATE HOTEL
        updateBtn.addActionListener(e -> {

            int row = table.getSelectedRow();

            if(row == -1){
                JOptionPane.showMessageDialog(this,"Select a row");
                return;
            }

            int id = (int) model.getValueAt(row,0);

            Hotel h = new Hotel();
            h.setHotelId(id);
            h.setName(nameField.getText());
            h.setLocation(locationField.getText());
            h.setAmenities(amenitiesField.getText());

            dao.updateHotel(h);

            JOptionPane.showMessageDialog(this,"Hotel Updated");

            loadHotels();
        });

        // DELETE HOTEL
        deleteBtn.addActionListener(e -> {

            int row = table.getSelectedRow();

            if(row == -1){
                JOptionPane.showMessageDialog(this,"Select a row");
                return;
            }

            int id = (int) model.getValueAt(row,0);

            dao.deleteHotel(id);

            JOptionPane.showMessageDialog(this,"Hotel Deleted");

            loadHotels();
        });

        // SEARCH FILTER
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);

        searchField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void insertUpdate(javax.swing.event.DocumentEvent e) { filter(); }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { filter(); }
            public void changedUpdate(javax.swing.event.DocumentEvent e) { filter(); }

            private void filter() {
                String text = searchField.getText();
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
            }
        });

        setVisible(true);
    }

    // LOAD HOTELS INTO TABLE
    private void loadHotels() {

        model.setRowCount(0);

        List<Hotel> list = dao.getAllHotels();

        for(Hotel h : list){
            model.addRow(new Object[]{
                    h.getHotelId(),
                    h.getName(),
                    h.getLocation(),
                    h.getAmenities()
            });
        }
    }
}