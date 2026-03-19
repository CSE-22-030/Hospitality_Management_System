package gui;

import dao.statsDAO;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {

    public Dashboard(){

        setTitle("Dashboard");
        setSize(400,400);
        setLayout(new GridLayout(6,1));

        statsDAO dao = new statsDAO();

        add(new JLabel("Total Hotels: " + dao.getCount("hotels"), SwingConstants.CENTER));
        add(new JLabel("Total Rooms: " + dao.getCount("rooms"), SwingConstants.CENTER));
        add(new JLabel("Total Guests: " + dao.getCount("guests"), SwingConstants.CENTER));
        add(new JLabel("Total Reservations: " + dao.getCount("reservations"), SwingConstants.CENTER));

        // 🔥 BUTTON TO OPEN HOTEL MANAGEMENT
        JButton hotelBtn = new JButton("Manage Hotels");

        hotelBtn.addActionListener(e -> new HotelManagement());

        add(hotelBtn);

        setVisible(true);
    }
}