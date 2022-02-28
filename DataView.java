/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataExtractionDisplay;

/**
 *
 * @author yomol
 */

    
    // Packages to import
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
 
public class DataView {
    // frame
    JFrame f;
    // Table
    JTable j;
 
    // Constructor
    DataView()
    {
        // Frame initialization
        f = new JFrame();
 
        // Frame Title
        f.setTitle("DataView");
 
        // Data to be displayed in the JTable
        String[][] data = {
            { "", "", "" },
            { "", "", "" },
            { "", "", "" }
        };
 
        // Column Names
        String[] columnNames = { "CompanyID", "CompanyNAME", "NUMBEROFBUSES" };
 
        // Initializing the JTable
        j = new JTable(data, columnNames);
        j.setBounds(30, 40, 200, 300);
 
        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(j);
        f.add(sp);
        // Frame Size
        f.setSize(500, 200);
        // Frame Visible = true
        f.setVisible(true);
    }
 
    
}
    
