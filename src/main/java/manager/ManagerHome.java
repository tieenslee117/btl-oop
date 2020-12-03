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
import java.sql.*;
import java.util.ArrayList;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import model.Stock;
import utils.JDBCUtils;

public class ManagerHome extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    private JLabel label;
    private JPanel contentPane;
    private String[] fakeFields = {"Tên", "Công ty", "Người quản lý", "Số lượng phát hành", "Số lượng đã bán", "Giá trần", "Giá sàn"};
    private final String[][] fakeDatas;
//    private String id;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ManagerHome frame = new ManagerHome("3");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public ManagerHome(String id) {
        this.fakeDatas = new String[][] {
                {"cp1", "ct1", "ql1", "10", "3", "1$", "0$"},
                {"cp1", "ct1", "ql1", "10", "3", "1$", "0$"},
                {"cp1", "ct1", "ql1", "10", "3", "1$", "0$"}
                };
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 120, 1000, 600);
        setResizable(false);
        setTitle("Cổ phiếu đang sở hữu");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton homeBtn = new JButton("Cổ phiếu đang sở hữu");
        homeBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
        homeBtn.setBounds(50, 20, 200, 30);
        
        
        
        homeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        contentPane.add(homeBtn);
        
        JButton stockBtn = new JButton("Cổ phiếu trên thị trường");
        stockBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
        stockBtn.setBounds(400, 20, 200, 30);
        
//        stockBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                StockList sl = new StockList(id);
//                dispose();
//                sl.setVisible(true);
//            }
//        });
        
        contentPane.add(stockBtn);
          
        JButton inforBtn = new JButton("Thông tin cá nhân");
        inforBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
        inforBtn.setBounds(700, 20, 200, 30);
        
        inforBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User us = new User(id);
                dispose();
                us.setVisible(true);
            }
        });
        contentPane.add(inforBtn);
        
//        JLabel title = new JLabel("Cổ phiếu đang sở hữu");
//        title.setBackground(Color.BLACK);
//        title.setForeground(Color.BLACK);
//        title.setFont(new Font("Tahoma", Font.PLAIN, 18));
//        title.setBounds(350, 90, 193, 52);
//        contentPane.add(title);
        
        
        ArrayList<Stock> stocks = new ArrayList<>();
        DefaultTableModel tbModel = new DefaultTableModel(new String[]{"Name", "Company", "Manager", "Release", "Sold", "Tran", "San"}, 0);
//        String[] fields = {"Name", "Company", "Manager", "Release", "Sold", "Tran", "San"};
////        for(int i = 0; i < fields.length; i++) {
//            tbModel.addColumn(fields);
////        }
        JTable stockTable = new JTable(tbModel);
        stockTable.setBounds(50, 80, 900, 400);
        System.out.println("1");
        try {
            Connection connection = JDBCUtils.getConnection();
            String query = "SELECT * FROM (\n" +
                                "SELECT\n" +
                                "  historyTrade.cus_id,\n" +
                                "  stock.stockname,\n" +
                                "  company.companyname,\n" +
                                "  manager.fullname,\n" +
                                "  historyTrade.price,\n" +
                                "  stock.quantity_release,\n" +
                                "  stock.quantity_sold,\n" +
                                "  stock.tran,\n" +
                                "  stock.san\n" +
                                "FROM stock\n" +
                                "JOIN historyTrade\n" +
                                "  ON historyTrade.stock_id = historyTrade.stock_id\n" +
                                "JOIN manager\n" +
                                "  ON manager.man_id = stock.man_id\n" +
                                "JOIN company \n" +
                                "  ON company.company_id = stock.company_id\n" +
                                "  ) AS st WHERE cus_id=?;";
            PreparedStatement st = (PreparedStatement) connection.prepareStatement(query);
                    st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Stock s = new Stock(rs.getString("stockname"), rs.getString("companyname"), rs.getString("fullname"), rs.getInt("quantity_release"), rs.getInt("quantity_sold"), rs.getInt("tran"), rs.getInt("san"));
//                        stocks.add(s);
                String[] data = {rs.getString("stockname"), rs.getString("companyname"), rs.getString("fullname"), ""+rs.getInt("quantity_release"), ""+rs.getInt("quantity_sold"), ""+rs.getInt("tran"), ""+rs.getInt("san")};
                System.out.println(rs.getString("stockname") + " " + rs.getString("companyname") + " " + rs.getString("fullname")+ " "+rs.getInt("quantity_release") + " "+rs.getInt("quantity_sold") + " "+rs.getInt("tran") + " "+rs.getInt("san"));
                tbModel.addRow(data);
            }
            connection.close();
            stockTable.setModel(tbModel);
                    contentPane.add(stockTable);
                    System.out.println("da xong");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        
        
    }
}
