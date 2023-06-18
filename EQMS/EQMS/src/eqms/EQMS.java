package eqms;

import employeeManagementSystemGUI.*;
import java.util.Scanner;
import java.util.ArrayList; // import the ArrayList class
//import SQL statements
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EQMS {

    public static String connectionURL = "jdbc:derby://localhost:1527/EQMSDB";
    

    //Add/Update/Delete Records 
    public static void ddl(String query) {
        try {
            Connection conn = DriverManager.getConnection(connectionURL, "bue", "bue");
            Statement st = conn.createStatement();
            String sql = query;
            st.executeUpdate(sql);
            st.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Connect failed ! ");
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        //ManageCourseUI manageCourseUI = new ManageCourseUI();
        //manageCourseUI.inputSkills();
        new loginGUI().setVisible(true);
        //ManageEmployeeUI manageEmployeeUI = new ManageEmployeeUI();
        //manageEmployeeUI.inputEmployeeInfo();
      //  boolean x = manageEmployeeUI.EnterID(100003);
       // if(x){
       //      manageEmployeeUI.selectField(100003);
       // }
        //manageEmployeeUI.inputEmployeeInfo();
    }

}
