/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataExtractionDisplay;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


/**
 *
 * @author yomol
 */
public class FirstPage {

    public FirstPage() {
        JFrame frame = new JFrame();

        frame.setTitle("Number of Buses Information");
        frame.setSize(400, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        frame.setLayout(new GridLayout(2, 1, 3, 3));

        JPanel mainpanel1 = new JPanel();
        mainpanel1.setLayout(new FlowLayout());
        JPanel mainpanelsub1 = new JPanel();
        JPanel mainpanelsub2 = new JPanel();
        JPanel mainpanelsub3 = new JPanel();
        mainpanel1.add(mainpanelsub1);
        mainpanel1.add(mainpanelsub2);
        mainpanel1.add(mainpanelsub3);
        mainpanelsub2.setLayout(new BorderLayout());
        JTextArea info = new JTextArea();
        mainpanelsub2.add(info);
        info.append("                  Welcome to our application ! \n"
                + "\n"
                + "\n"
                + "This Application Counts the number of Buses in the Tranbus fleet\n"
                + "\n"
                + "\n");
        info.setEditable(false);
    
        info.setForeground(Color.red);
        info.setBackground(Color.BLACK);
        
        
        frame.add(mainpanel1);

        
        JPanel mainpanel2 = new JPanel();
        mainpanel2.setLayout(new FlowLayout());
        JPanel mainpanelsub12 = new JPanel();
        JPanel mainpanelsub22 = new JPanel();
        JPanel mainpanelsub32 = new JPanel();
        mainpanel2.add(mainpanelsub12);
        mainpanel2.add(mainpanelsub22);
        mainpanel2.add(mainpanelsub32);
        mainpanelsub22.setLayout(new BorderLayout(5, 10));
        JButton selectToCount = new JButton("Select to Count");
        mainpanelsub22.add(selectToCount, BorderLayout.CENTER);
        frame.add( mainpanel2);
       
        frame.setVisible(true);
        
        selectToCount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                // Create an Object of the detail Verification class
                
                Detail_Verification detail = new Detail_Verification();
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                
                
                
                
                
            }
            
        });

}
}
