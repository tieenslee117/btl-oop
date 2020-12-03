/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

/**
 *
 * @author PC
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import utils.JDBCUtils;
import auth.Entrance;

public class User extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    private JLabel label;
    private JPanel contentPane;

    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    User frame = new User("1");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public User(String id) { 
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 120, 1000, 600);
        setResizable(false);
        setTitle("Thông tin cá nhân");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton homeBtn = new JButton("Cổ phiếu đang sở hữu");
        homeBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
        homeBtn.setBounds(50, 20, 200, 30);
        contentPane.add(homeBtn);
        
//        homeBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                CustomerHome sl = new CustomerHome(id);
//                dispose();
//                sl.setVisible(true);
//            }
//        });
//        
//        JButton stockBtn = new JButton("Cổ phiếu trên thị trường");
//        stockBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        stockBtn.setBounds(400, 20, 200, 30);
//        stockBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                StockList sl = new StockList(id);
//                dispose();
//                sl.setVisible(true);
//            }
//        });
//        contentPane.add(stockBtn);
          
        JButton inforBtn = new JButton("Thông tin cá nhân");
        inforBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
        inforBtn.setBounds(700, 20, 200, 30);
        contentPane.add(inforBtn);
      
        JLabel lbType = new JLabel("Loại tài khoản:");
        lbType.setBackground(Color.BLACK);
        lbType.setForeground(Color.BLACK);
        lbType.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbType.setBounds(350, 90, 193, 52);
        contentPane.add(lbType);

        
        JLabel type = new JLabel("Quản lý");
        type.setBackground(Color.BLACK);
        type.setForeground(Color.BLACK);
        type.setFont(new Font("Tahoma", Font.PLAIN, 18));
        type.setBounds(500, 90, 193, 52);
        contentPane.add(type);
        
        JLabel lbFn = new JLabel("Họ tên:");
        lbFn.setBackground(Color.BLACK);
        lbFn.setForeground(Color.BLACK);
        lbFn.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbFn.setBounds(350, 150, 193, 52);
        contentPane.add(lbFn);

        
        JLabel fn = new JLabel("");
        fn.setBackground(Color.BLACK);
        fn.setForeground(Color.BLACK);
        fn.setFont(new Font("Tahoma", Font.PLAIN, 18));
        fn.setBounds(500, 150, 193, 52);
        contentPane.add(fn);
        
        JLabel lbUn = new JLabel("Tên tài khoản:");
        lbUn.setBackground(Color.BLACK);
        lbUn.setForeground(Color.BLACK);
        lbUn.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbUn.setBounds(350, 210, 193, 52);
        
        JLabel un = new JLabel();
        un.setBackground(Color.BLACK);
        un.setForeground(Color.BLACK);
        un.setFont(new Font("Tahoma", Font.PLAIN, 18));
        un.setBounds(500, 210, 193, 52);
        contentPane.add(lbUn);
        contentPane.add(un);
        
        JLabel lbEmail = new JLabel("Email:");
        lbEmail.setBackground(Color.BLACK);
        lbEmail.setForeground(Color.BLACK);
        lbEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbEmail.setBounds(350, 270, 193, 52);
        
        JLabel email = new JLabel();
        email.setBackground(Color.BLACK);
        email.setForeground(Color.BLACK);
        email.setFont(new Font("Tahoma", Font.PLAIN, 18));
        email.setBounds(500, 270, 193, 52);
        contentPane.add(lbEmail);
        contentPane.add(email);
        
        JLabel lbPhone = new JLabel("Số điện thoại:");
        lbPhone.setBackground(Color.BLACK);
        lbPhone.setForeground(Color.BLACK);
        lbPhone.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbPhone.setBounds(350, 330, 193, 52);
        
        JLabel phone = new JLabel();
        phone.setBackground(Color.BLACK);
        phone.setForeground(Color.BLACK);
        phone.setFont(new Font("Tahoma", Font.PLAIN, 18));
        phone.setBounds(500, 330, 193, 52);
        contentPane.add(lbPhone);
        contentPane.add(phone);
        
        JLabel lbAddress = new JLabel("Địa chỉ:");
        lbAddress.setBackground(Color.BLACK);
        lbAddress.setForeground(Color.BLACK);
        lbAddress.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbAddress.setBounds(350, 390, 193, 52);
        
        JLabel address = new JLabel();
        address.setBackground(Color.BLACK);
        address.setForeground(Color.BLACK);
        address.setFont(new Font("Tahoma", Font.PLAIN, 18));
        address.setBounds(500, 390, 193, 52);
        contentPane.add(lbAddress);
        contentPane.add(address);
        
        try {
            Connection connection = JDBCUtils.getConnection();
            String query = "SELECT * FROM customer WHERE cus_id=?";
            PreparedStatement st = (PreparedStatement) connection.prepareStatement(query);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                fn.setText(rs.getString("fullname"));
                un.setText(rs.getString("username"));
                phone.setText(rs.getString("phone"));
                email.setText(rs.getString("email"));
                address.setText(rs.getString("address"));
                        
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        
        JButton editBtn = new JButton("Sửa thông tin");
        editBtn.setBounds(350, 450, 120, 40);
        editBtn.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
           }
        });
        
        contentPane.add(editBtn);
        
        JButton logOutBtn = new JButton("Đăng xuất");
        logOutBtn.setBounds(500, 450, 120, 40);
        logOutBtn.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               Entrance et = new Entrance();
               dispose();
               et.setVisible(true);
           }
        });
        
        contentPane.add(logOutBtn);
        
        
    }
}
