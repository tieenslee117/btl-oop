/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package auth;
import java.sql.*;
import customer.CustomerHome;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.*;
import utils.JDBCUtils;
import manager.ManagerHome;

/**
 *
 * @author DELL
 */
public class Entrance extends javax.swing.JFrame {
    private JButton btnNewButton;
    /**
     * Creates new form NewJFrame
     * @param dbURL
     * @param userName
     * @param password
     * @return 
     */
    public static Connection getConnection(String dbURL, String userName, 
            String password) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
    /**
     * Creates new form NewJFrame
     */
    public Entrance() {
        setBounds(520, 220, 1000, 650);
        setResizable(false);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Loại tài khoản:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Người mua", "Quản lý" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Tên tài khoản:");

        jLabel4.setText("Mật khẩu:");

        jButton2.setText("Đăng ký");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Đăng nhập");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel5.setText("Phần mềm quản lý tài khoản chứng khoán cá nhân");

        jLabel2.setText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(jButton2)))
                                .addGap(0, 36, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3)
                            .addComponent(jTextField2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)))
                .addGap(90, 90, 90))
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addGap(59, 59, 59))
        );

        pack();
    }// </editor-fold>                         

    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if (jTextField2.getText().equals("") || jTextField3.getText().equals("")) {
            jLabel2.setText("Vui lòng nhập đầy đủ thông tin!");
        }else {
            String value = jComboBox1.getSelectedItem().toString();
            if ("Người mua".equals(value)) {
                try (Connection conn = JDBCUtils.getConnection()) {
                    PreparedStatement ps = 
                    conn.prepareStatement
                    ("SELECT pass FROM buyer WHERE username = ?");

                    ps.setString(1, jTextField2.getText());
//                    ps.setString(2, jTextField3.getText());
                    ResultSet rs = ps.executeQuery();
                    String pw = null;
                    while (rs.next()) {
                        pw = rs.getString("pass");
                    }
                    if (pw.equals(jTextField3.getText())) {
                        // Đăng nhập thành công
                        JOptionPane.showMessageDialog(btnNewButton, "Đăng nhập thành công");
                        try (Connection connection = JDBCUtils.getConnection();
                            PreparedStatement preparedStatement = connection
                            .prepareStatement("SELECT buyer_id FROM buyer WHERE username = ? and pass = ? ")) {
                            preparedStatement.setString(1, jTextField2.getText());
                            preparedStatement.setString(2, pw);
                            System.out.println(preparedStatement);
                            ResultSet rs1 = preparedStatement.executeQuery();
                            String id ="";
                            while(rs1.next()) {
                                id = rs1.getString("buyer_id");
                                System.out.println(id);
                            }
                            CustomerHome ch = new CustomerHome(id);
                            dispose();
                            ch.setVisible(true);

                        } catch (SQLException e) {
                            // process sql exception
                            JDBCUtils.printSQLException(e);
                        }
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton, "Tài khoản hoặc mật khẩu không đúng!");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } 
            }
            else {
                try (Connection conn = JDBCUtils.getConnection() ) {
                    PreparedStatement ps = 
                    conn.prepareStatement
                    ("SELECT pass FROM manager WHERE username = ?");
                    ps.setString(1, jTextField2.getText());
//                    ps.setString(2, jTextField3.getText());
                    ResultSet rs = ps.executeQuery();
                    String pw = null;
                    while (rs.next()) {
                        pw = rs.getString("pass");
                       
                    }
                    if (pw.equals(jTextField3.getText())) {
                        JOptionPane.showMessageDialog(btnNewButton, "Đăng nhập thành công");
                        try (Connection connection = JDBCUtils.getConnection();
                            PreparedStatement preparedStatement = connection
                            .prepareStatement("SELECT man_id FROM manager WHERE username = ? and pass = ? ")) {
                            preparedStatement.setString(1, jTextField2.getText());
                            preparedStatement.setString(2, pw);
                            System.out.println(preparedStatement);
                            ResultSet rs1 = preparedStatement.executeQuery();
                            String id ="";
                            while(rs1.next()) {
                                id = rs1.getString("man_id");
                                System.out.println(id);
                            }
                            ManagerHome mh = new ManagerHome(id);
                            dispose();
                            mh.setVisible(true);

                        } catch (SQLException e) {
                            // process sql exception
                            JDBCUtils.printSQLException(e);
                        }
                        
                    } else {
                        jLabel2.setText("Tài khoản hoặc mật khẩu không đúng!");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } 
            }
            
            
            
        }
        
    }                                        

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        Signup otherClass = new Signup();
        otherClass.setVisible(true);
    }                                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Entrance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Entrance().setVisible(true);
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration                   
}
