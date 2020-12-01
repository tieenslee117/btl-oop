/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;

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

public class CustomerHome extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    private JLabel label;
    private JPanel contentPane;
    private String[] fakeFields = {"Tên", "Công ty", "Người quản lý", "Số lượng phát hành", "Số lượng đã bán", "Giá trần", "Giá sàn"};
    private final String[][] fakeDatas;

    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CustomerHome frame = new CustomerHome();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public CustomerHome() {
        this.fakeDatas = new String[][] {
                {"cp1", "ct1", "ql1", "10", "3", "1$", "0$"},
                {"cp1", "ct1", "ql1", "10", "3", "1$", "0$"},
                {"cp1", "ct1", "ql1", "10", "3", "1$", "0$"}
                };
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 120, 1000, 600);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton homeBtn = new JButton("Cổ phiếu đang sở hữu");
        homeBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
        homeBtn.setBounds(50, 20, 200, 30);
        
        contentPane.add(homeBtn);
        
        JButton stockBtn = new JButton("Cổ phiếu trên thị trường");
        stockBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
        stockBtn.setBounds(400, 20, 200, 30);
        
        contentPane.add(stockBtn);
          
        JButton inforBtn = new JButton("Thông tin cá nhân");
        inforBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
        inforBtn.setBounds(700, 20, 200, 30);
        
        inforBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User us = new User();
                contentPane.add(us);
                
            }
        });
        contentPane.add(inforBtn);
        
        DefaultTableModel model = new DefaultTableModel() { 
            @Override 
            public int getColumnCount() { 
                return fakeFields.length; 
            } 

            @Override 
            public String getColumnName(int index) { 
                return fakeFields[index]; 
            } 
        }; 
        
        JTable stockTable = new JTable(fakeDatas, fakeFields);
        stockTable.setBounds(50, 80, 900, 400);
        contentPane.add(stockTable);
        
    }
}
