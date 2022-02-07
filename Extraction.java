/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transbusassignment2;

/**
 *
 * @author yomol
 */

import java.sql.*;
import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TransbusAssignment2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try
        {
            //Get Oracle Username and Password from user
            BufferedReader input = 
                    new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter Oracle Username:");
            String username = input.readLine();
            System.out.print("Enter Oracle Password:");
            String password = input.readLine();
            
            //Connect to database
            
            String myConnectionString = new String 
                    ("jdbc:oracle:thin:@35.166.130.72:1521:xe");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = 
                    DriverManager.getConnection(myConnectionString, username, password);
            System.out.println("I am here");
            System.out.print("CompanyID" + " ");
            System.out.print("CompanyNAME" + " ");
            System.out.print("NUMBEROFBUSES" + " ");
            System.out.println("");
            
           //Select all data from table Student
                    Statement stmt = con.createStatement();
           ResultSet r = stmt.executeQuery("Select C.CompanyID, C.CompanyName,C.numberOFBuses() from Company_Table C");
         
          //Display the data a row at a time           
           while (r.next())
            {
                System.out.print(r.getString("COMPANYID")+ "        " );
                System.out.print(r.getString("COMPANYNAME")+ "         " );
                System.out.print(r.getString("C.NUMBEROFBUSES()")+ "         " );
                System.out.println(""); 
               
            }
            System.out.println("End SQL");
            stmt.close();
        
            
        } //On IO exception, display system error messages
        catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(TransbusAssignment2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TransbusAssignment2.class.getName()).log(Level.SEVERE, null, ex);
        }
        // on SQl exception, display sql error message
    }

}
