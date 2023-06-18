/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eqms;

//import SQL statements
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Scanner;
import java.util.ArrayList; // import the ArrayList class
import java.util.HashMap; // import the HashMap class

/**
 *
 * @author bavshehata
 */
public class ManageCourse {

    Scanner input = new Scanner(System.in);
    private static HashMap<Integer, Course> skillCourseList = new HashMap<Integer, Course>();
    private static ArrayList<Integer> skillIds = new ArrayList<Integer>();

    public static boolean doesExist(int skillId) {
        boolean exists = false;

        try {
            Connection conn = DriverManager.getConnection(EQMS.connectionURL, "bue", "bue");
            String sqlRetrieveSkill = "SELECT * FROM \"Skill\" WHERE \"id\" = " + skillId;
            Statement st = conn.createStatement();
            ResultSet rs = null;
            rs = st.executeQuery(sqlRetrieveSkill);

            while (rs.next()) {
                exists = true;
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Connect failed ! ");
        }
        if (exists) {
            return true;
        } else {
            return false;
        }

    }
    public static ArrayList<Course> retrieveRelevantCourses(int skillId) {
        ArrayList<Course> relevantCourses = new ArrayList<Course>();

        try {
            Connection conn = DriverManager.getConnection(EQMS.connectionURL, "bue", "bue");
            String sql = "SELECT \"id\", \"title\", \"description\", \"price\"FROM \"Course\" WHERE \"sid\" = " + skillId;
            Statement st = conn.createStatement();
            ResultSet rs = null;
            rs = st.executeQuery(sql);
            while (rs.next()) {
                relevantCourses.add(new Course(rs.getInt("id"), rs.getString("title"), rs.getString("description"), rs.getFloat("price")));
            }

            rs.close();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Connect failed ! ");
        }
        return relevantCourses;

    }

    public static ArrayList<Course> pullOutSkill(int skillId) {
        // Get the first skill in the list and remove it from the list.
        ArrayList<Course> relevantCourses = retrieveRelevantCourses(skillId);
        if(!relevantCourses.isEmpty())skillIds.add(skillId);
        // Retrieve courses that match this skill by their IDs
        return relevantCourses;
    }

    public static void addToList(int skillId, Course course) {
        skillCourseList.put(skillId, course);
    }

    public static int assignCourses() {
        int numberOfAssignedCourses = 0;
        // Loop through all required Skills
        for (int i = 0; i < skillIds.size(); i++) {
            int skillId = skillIds.get(i);
            int courseId = skillCourseList.get(skillId).getId();
            ArrayList<Integer> skilledEmployees = new ArrayList<Integer>();
            try {
                Connection conn = DriverManager.getConnection(EQMS.connectionURL, "bue", "bue");
                Statement st = conn.createStatement();
                ResultSet rs = null;
                // Retrieve all employees
                String sqlRetrieveEmployeesSkills = "SELECT * FROM \"Employee_Skills\"";
                String sqlAddEmployeeSkill;
                rs = st.executeQuery(sqlRetrieveEmployeesSkills);
                // Store employees that already have the skill, in an arraylist
                while (rs.next()) {
                    if (rs.getInt("sid") == skillId) {
                        skilledEmployees.add(rs.getInt("eid"));
                    }
                }
                String sqlRetrieveEmployees = "SELECT * FROM \"Employee\"";
                rs = st.executeQuery(sqlRetrieveEmployees);
                // Loop through all employees again
                while (rs.next()) {
                    boolean exists = false;
                    for (int j = 0; j < skilledEmployees.size(); j++) {
                        // If an employee has the skill, move to the next employee
                        if (rs.getInt("id") == skilledEmployees.get(j)) {
                            exists = true;
                            break;
                        }
                    }
                    if (!exists) {
                        // If the employee doesn't have the skill, add it to them
                        sqlAddEmployeeSkill = "INSERT INTO \"Employee_Skills\" VALUES(" + rs.getInt("id") + ',' + skillId + ',' + courseId + ',' + "false)";
                        EQMS.ddl(sqlAddEmployeeSkill);
                        numberOfAssignedCourses++;
                    }
                }
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Connect failed ! ");
            }
        }
        return numberOfAssignedCourses;
    }
}
