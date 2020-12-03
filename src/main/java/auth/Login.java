/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auth;

/**
 *
 * @author PC
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.*;
import javax.swing.*;
import customer.CustomerHome;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

import utils.JDBCUtils;

public class Login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    private JLabel label;
    private JPanel contentPane;
    private String type;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {     
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Login() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Login");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        lblNewLabel.setBounds(423, 13, 273, 93);
        contentPane.add(lblNewLabel);
        
        
        JLabel lbType = new JLabel("Loại tài khoản");
        lbType.setBackground(Color.BLACK);
        lbType.setForeground(Color.BLACK);
        lbType.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lbType.setBounds(250, 120, 193, 52);
        contentPane.add(lbType);
        
        
        String[] types = {"Khách hàng", "Quản lý"};
        JComboBox cbType = new JComboBox(types);
        cbType.setForeground(Color.BLACK);
        cbType.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        cbType.setBounds(481, 120, 273, 40);
        contentPane.add(cbType);

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        textField.setBounds(481, 220, 281, 68);
        contentPane.add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(481, 320, 281, 68);
        contentPane.add(passwordField);

        JLabel lblUsername = new JLabel("Tên người dùng");
        lblUsername.setBackground(Color.BLACK);
        lblUsername.setForeground(Color.BLACK);
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblUsername.setBounds(250, 220, 193, 52);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Mật khẩu");
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setBackground(Color.CYAN);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblPassword.setBounds(250, 320, 193, 52);
        contentPane.add(lblPassword);

        btnNewButton = new JButton("Login");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnNewButton.setBounds(460, 440, 150, 60);
        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String userName = textField.getText();
                String password = new String(passwordField.getPassword());
                String t = "" + cbType.getSelectedItem();
                if(t == "Khách hàng") type = "customer";
                if(t == "Quản lý") type = "admin";
//                try {
//                    Connection connection = JDBCUtils.getConnection();
//                    PreparedStatement st = (PreparedStatement) connection
//                        .prepareStatement("SELECT username, pass FROM customer WHERE username=? and pass=?;");
//                    st.setString(1, type);
//                    st.setString(2, userName);
//                    st.setString(3, password);
                    System.out.println(type +  userName+ password);
//                    ResultSet rs = st.executeQuery();
//                    if (rs.next()) {
//                        dispose();
//                        CustomerHome ah = new CustomerHome(userName);
//                        ah.setTitle("Welcome");
//                        ah.setVisible(true);
//                        JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
//                    } else {
//                        JOptionPane.showMessageDialog(btnNewButton, "Wrong Username & Password");
//                    }
//                } catch (SQLException sqlException) {
//                    sqlException.printStackTrace();
//                }
            }
        });
        
        contentPane.add(btnNewButton);

        label = new JLabel("");
        label.setBounds(0, 0, 1008, 562);
        contentPane.add(label);
    }
}