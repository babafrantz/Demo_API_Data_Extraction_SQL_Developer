/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataExtractionDisplay;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.Keymap;

/**
 *
 * @author yomol
 */
public class Detail_Verification {

    public Detail_Verification() {

        JFrame frame = new JFrame();

        frame.setTitle("Detail Verification");
        frame.setSize(400, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new GridLayout(3, 1, 3, 3));

        JPanel MainPanel1 = new JPanel();
        MainPanel1.setLayout(new FlowLayout());
        JPanel MainPanelsub1 = new JPanel();
        JPanel MainPanelsub2 = new JPanel();
        MainPanel1.add(MainPanelsub1);
        MainPanel1.add(MainPanelsub2);

        MainPanelsub1.add(new JLabel("Enter UserName"));
        JTextField username_info1 = new JTextField();
        MainPanelsub2.add(username_info1);
        username_info1.setColumns(8);
        frame.add(MainPanel1);

        JPanel MainPanel2 = new JPanel();
        MainPanel2.setLayout(new FlowLayout());
        JPanel MainPanelsub12 = new JPanel();
        JPanel MainPanelsub22 = new JPanel();
        MainPanel2.add(MainPanelsub12);
        MainPanel2.add(MainPanelsub22);

        MainPanelsub12.add(new JLabel("Password"));
        JTextField info2 = new JTextField();
        MainPanelsub22.add(info2);
        info2.setColumns(8);

        frame.add(MainPanel2);

        JPanel MainPanel3 = new JPanel();
        MainPanel3.setLayout(new FlowLayout());
        JPanel MainPanelsub13 = new JPanel();
        MainPanel3.add(MainPanelsub13);

        JButton post_ = new JButton("Post");
        MainPanelsub13.add(post_);
        frame.add(MainPanel3);

        frame.setVisible(true);

        post_.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                //get values from Textfield
                String username = username_info1.getText();
                String password1 = info2.getText();
                
                if (username != "YusufOAss2" && password1!="001146249"){
                    
                    JOptionPane.showMessageDialog(null,"Password Incorrect");
                }
                else{
                    DataView view = new DataView();
                }
                
                
                // Use the info to connect to database
                try {
                    String myConnectionString = new String("jdbc:oracle:thin:@35.166.130.72:1521:xe");
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection con
                            = DriverManager.getConnection(myConnectionString, username, password1);

                    // Query the database
                   // Statement stmt = con.createStatement();
                   // ResultSet r = stmt.executeQuery("Select C.CompanyID, C.CompanyName,C.numberOFBuses() from Company_Table C");

                } //On IO exception, display system error messages
 catch (SQLException ex) {
                    Logger.getLogger(TransbusAssignment2.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(TransbusAssignment2.class.getName()).log(Level.SEVERE, null, ex);
                }

                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        }
        );

    }
}
