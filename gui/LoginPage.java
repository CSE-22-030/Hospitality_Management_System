/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import dao.userDAO;

import javax.swing.*;
import java.awt.*;

public class LoginPage extends JFrame {

    public LoginPage(){

        setTitle("Login");
        setSize(300,200);
        setLayout(new GridLayout(3,2));

        JTextField user = new JTextField();
        JPasswordField pass = new JPasswordField();
        JButton login = new JButton("Login");

        add(new JLabel("Username"));
        add(user);
        add(new JLabel("Password"));
        add(pass);
        add(login);

        login.addActionListener(e -> {

            if(new userDAO().login(user.getText(), new String(pass.getPassword()))){
                new Dashboard();
                dispose();
            }else{
                JOptionPane.showMessageDialog(this,"Invalid Login");
            }
        });

        setVisible(true);
    }
}