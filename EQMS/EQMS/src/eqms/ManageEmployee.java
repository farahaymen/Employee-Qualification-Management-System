package eqms;

import java.lang.*;
import java.io.*;
import java.util.*;
//import SQL statements
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ManageEmployee {

    //This function checks if the employee ssn exists before int the employee arraylist or not. 
    public static boolean doesSsnExist(long employeeSsn) {
        boolean exists = false;
        try {
            Connection conn = DriverManager.getConnection(EQMS.connectionURL, "bue", "bue");
            String sql = "SELECT * FROM \"Employee\" WHERE \"ssn\" = " + employeeSsn;
            Statement st = conn.createStatement();
            ResultSet rs = null;
            rs = st.executeQuery(sql);

            while (rs.next()) {
                exists = true;
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Connect failed ! ");
        }
        return exists;

    }

    public static boolean doesIdExist(int employeeId) {
        boolean exists = false;
        try {
            Connection conn = DriverManager.getConnection(EQMS.connectionURL, "bue", "bue");
            String sql = "SELECT * FROM \"Employee\" WHERE \"id\" = " + employeeId;
            Statement st = conn.createStatement();
            ResultSet rs = null;
            rs = st.executeQuery(sql);

            while (rs.next()) {
                exists = true;
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Connect failed ! ");
        }
        return exists;

    }

    //This function checks the validity of the entered ssn.
    //This function was supposed to send the ssn to the civil registry system and get a return value of true or false
    //depending on whether this ssn exists in the system or not but for the sake of testing we made isValid function
    //check if the ssn consists of exactly 14 digits or not and the first digit represents the millennium and the next
    //2 digits represents the year, next 2 digits represents the month, next 2 digits represents the day.
    public static boolean isValid(Long employeeSsn, String date) {
        long numberOfDigits = 0;
        long temp = employeeSsn;
        while (temp != 0) {
            numberOfDigits++;
            temp /= 10;
        }

        if (numberOfDigits != 14) {
            return false;
        }

        while (numberOfDigits > 7) {
            employeeSsn /= 10;
            numberOfDigits--;
        }

        long[] dateInfo = new long[]{Integer.parseInt(date.substring(0, 2)),
            Integer.parseInt(date.substring(3, 5)),
            Integer.parseInt(date.substring(8, 10))};
        long millennium = Integer.parseInt(date.substring(6, 7)) + 1;

        for (int i = 0; i < 3; ++i) {
            long check = employeeSsn % 10;
            employeeSsn /= 10;
            check += (employeeSsn % 10) * 10;
            employeeSsn /= 10;
            if (check != dateInfo[i]) {
                return false;
            }
        }
        return employeeSsn == millennium;
    }

    public static String reverseDate(String date) {
        String day, month, year;
        day = date.substring(0, 2);
        month = date.substring(3, 5);
        year = date.substring(6, 10);

        return year + '-' + month + '-' + day;
    }

    //This function adds the employee to the arraylist of employees.
    public static void addEmployee(Employee e) {

        String employee = "DEFAULT , " + e.getSsn() + ',' + "'" + e.getName() + "'" + ',' + "'" + e.getAddress() + "'" + ',' + e.getPhoneNumber() + ',' + "'" + e.getGender() + "'" + ',' + "'" + reverseDate(e.getEmploymentDate()) + "'" + ',' + "'" + reverseDate(e.getDateOfBirth()) + "'" + ',' + e.getJobTitle().getId() + ',' + e.getInsurance().getId();
        EQMS.ddl("INSERT INTO \"Employee\" VALUES(" + employee + ")");
    }

    public static ArrayList<Skill> retrieveSkills() {
        ArrayList<Skill> skills = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(EQMS.connectionURL, "bue", "bue");
            String sql = "SELECT * FROM \"Skill\"";
            Statement st = conn.createStatement();
            ResultSet rs = null;
            rs = st.executeQuery(sql);

            while (rs.next()) {
                skills.add(new Skill(rs.getInt("id"), rs.getString("title"), rs.getString("description"), rs.getFloat("bonus")));
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Connect failed ! ");
        }
        return skills;
    }

    public static EmployeeSkill addEmployeeSkill(int skillNumber) {
        return new EmployeeSkill(retrieveSkills().get(skillNumber - 1));
    }

    public static ArrayList<Achievement> retrieveAchievements() {
        ArrayList<Achievement> achievements = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(EQMS.connectionURL, "bue", "bue");
            String sql = "SELECT * FROM \"Achievement\"";
            Statement st = conn.createStatement();
            ResultSet rs = null;
            rs = st.executeQuery(sql);

            while (rs.next()) {
                achievements.add(new Achievement(rs.getInt("id"), rs.getString("title"), rs.getString("description"), rs.getFloat("bonusValue")));
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Connect failed ! ");
        }
        return achievements;
    }

    public static ArrayList<Qualification> retrieveQualifications() {
        ArrayList<Qualification> qualifications = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(EQMS.connectionURL, "bue", "bue");
            String sql = "SELECT * FROM \"Qualification\"";
            Statement st = conn.createStatement();
            ResultSet rs = null;
            rs = st.executeQuery(sql);

            while (rs.next()) {

                qualifications.add(new Qualification(rs.getInt("id"), rs.getString("degree"), rs.getString("specialization")));
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Connect failed ! ");
        }
        return qualifications;
    }

    public static ArrayList<EmployeeSkill> retrieveEmployeeSkills(int id) {
        ArrayList<EmployeeSkill> employeeSkills = new ArrayList<>();
        ArrayList<Skill> skills = new ArrayList<>();
        ArrayList<Integer> employeeCourseIds = new ArrayList<>();
        ArrayList<Integer> employeeSkillIds = new ArrayList<>();
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Boolean> completed = new ArrayList<>();
        Course course = new Course();
        try {
            Connection conn = DriverManager.getConnection(EQMS.connectionURL, "bue", "bue");
            String sql = "SELECT * FROM \"Employee_Skills\"";
            Statement st = conn.createStatement();
            ResultSet rs = null;
            rs = st.executeQuery(sql);

            while (rs.next()) {
                for (int i = 0; i < retrieveSkills().size(); i++) {
                    if (rs.getInt("eid") == id) {
                        employeeCourseIds.add(rs.getInt("cid"));
                    }
                }
                employeeSkillIds.add(rs.getInt("sid"));
                completed.add(rs.getBoolean("completed"));
            }
            sql = "SELECT * FROM \"Skill\"";
            rs = st.executeQuery(sql);

            while (rs.next()) {
                for (int i = 0; i < employeeSkillIds.size(); i++) {
                    if (rs.getInt("id") == employeeSkillIds.get(i)) {
                        sql = "SELECT * FROM \"Course\" WHERE \"id\" =" + employeeCourseIds.get(i);
                        rs = st.executeQuery(sql);

                        while (rs.next()) {
                            course = new Course(rs.getInt("id"), rs.getString("title"), rs.getString("description"), rs.getFloat("price"));
                        }
                        employeeSkills.add(new EmployeeSkill(new Skill(rs.getInt("id"), rs.getString("title"), rs.getString("description"), rs.getFloat("bonus")), course, completed.get(i)));
                    }
                }
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Connect failed ! ");
        }
        return employeeSkills;
    }

    public static ArrayList<Qualification> retrieveEmployeeQualifications(int id) {
        ArrayList<Qualification> employeeQualifications = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(EQMS.connectionURL, "bue", "bue");
            String sql = "SELECT * FROM \"Graduated_With\"";
            Statement st = conn.createStatement();
            ResultSet rs = null;
            rs = st.executeQuery(sql);

            while (rs.next()) {
                for (int i = 0; i < retrieveQualifications().size(); i++) {
                    if (rs.getInt("eid") == id) {
                        employeeQualifications.add(retrieveQualifications().get(i));
                    }
                }
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Connect failed ! ");
        }
        return employeeQualifications;
    }

    public static ArrayList<Achievement> retrieveEmployeeAchievments(int id) {
        ArrayList<Achievement> employeeAchievements = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(EQMS.connectionURL, "bue", "bue");
            String sql = "SELECT * FROM \"Achieve\"";
            Statement st = conn.createStatement();
            ResultSet rs = null;
            rs = st.executeQuery(sql);

            while (rs.next()) {
                for (int i = 0; i < retrieveAchievements().size(); i++) {
                    if (rs.getInt("eid") == id) {
                        employeeAchievements.add(retrieveAchievements().get(i));
                    }
                }
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Connect failed ! ");
        }
        return employeeAchievements;
    }

    public static ArrayList<Employee> retrieveEmployee() {
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(EQMS.connectionURL, "bue", "bue");
            String sql = "SELECT * FROM \"Employee\"";
            Statement st = conn.createStatement();
            ResultSet rs = null;
            rs = st.executeQuery(sql);

            while (rs.next()) {
                JobTitle job = new JobTitle();
                for (int i = 0; i < retrieveJobTitles().size(); i++) {
                    if (rs.getInt("jobid") == retrieveJobTitles().get(i).getId()) {
                        job = retrieveJobTitles().get(i);
                    }
                }
                Insurance insurance = new Insurance();
                for (int i = 0; i < retrieveInsurances().size(); i++) {
                    if (rs.getInt("insuranceId") == retrieveJobTitles().get(i).getId()) {
                        insurance = retrieveInsurances().get(i);
                    }
                }
                ArrayList<Qualification> qualifications = retrieveEmployeeQualifications(rs.getInt("id"));
                ArrayList<Achievement> achievements = retrieveEmployeeAchievments(rs.getInt("id"));
                ArrayList<EmployeeSkill> employeeSkills = retrieveEmployeeSkills(rs.getInt("id"));
                employees.add(new Employee(rs.getInt("id"), rs.getLong("ssn"), rs.getString("name"), rs.getString("address"),rs.getString("password"), rs.getString("email"), rs.getLong("phoneNo"), rs.getString("gender"), rs.getString("employmentDate"), rs.getString("dateOfBirth"), employeeSkills, qualifications, achievements, insurance, job));
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Connect failed ! ");
        }
        return employees;

    }

    public static Qualification retrieveQualification(int qualificationNumber) {

        return retrieveQualifications().get(qualificationNumber);

    }

    public static ArrayList<Insurance> retrieveInsurances() {
        ArrayList<Insurance> insurances = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(EQMS.connectionURL, "bue", "bue");
            String sql = "SELECT * FROM \"Insurance\"";
            Statement st = conn.createStatement();
            ResultSet rs = null;
            rs = st.executeQuery(sql);

            while (rs.next()) {
                insurances.add(new Insurance(rs.getInt("id"), rs.getString("title"), rs.getString("description")));
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Connect failed ! ");
        }
        return insurances;
    }

    public static Insurance retrieveInsurance(int insuranceNumber) {
        return retrieveInsurances().get(insuranceNumber - 1);
    }

    public static ArrayList<JobTitle> retrieveJobTitles() {
        ArrayList<JobTitle> jobTitles = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(EQMS.connectionURL, "bue", "bue");
            String sql = "SELECT * FROM \"JobTitle\"";
            Statement st = conn.createStatement();
            ResultSet rs = null;
            rs = st.executeQuery(sql);

            while (rs.next()) {
                jobTitles.add(new JobTitle(rs.getInt("id"), rs.getString("title"), rs.getFloat("salary"), rs.getString("description")));
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Connect failed ! ");
        }
        return jobTitles;
    }

    public static JobTitle retrieveJobTitle(int jobTitlesNumber) {
        return retrieveJobTitles().get(jobTitlesNumber - 1);
    }

    public static boolean sendEmployeeInfo(Employee employeeInfo) {
        if (!doesSsnExist(employeeInfo.getSsn()) && isValid(employeeInfo.getSsn(), employeeInfo.getDateOfBirth())) {
            return true;
        } else {
            return false;
        }
    }

    public static int getEmployeeCount() {
        int count = 0;
        try {
            Connection conn = DriverManager.getConnection(EQMS.connectionURL, "bue", "bue");
            String sql = "SELECT * FROM \"Employee\"";
            Statement st = conn.createStatement();
            ResultSet rs = null;
            rs = st.executeQuery(sql);

            while (rs.next()) {
                count++;
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Connect failed ! ");
        }
        return count;
    }

    public static void UpdateEmployee(int id, int fieldNumber, String data, int index) {
        if (fieldNumber == 3) {
            int cid = 500004;
            System.out.println("INSERT INTO \"Employee_Skills\" VALUES(" + id + ',' + retrieveSkills().get(index).getId() + ", null, true)");
            EQMS.ddl("INSERT INTO \"Employee_Skills\" VALUES(" + id + ',' + retrieveSkills().get(index).getId() + ", null, true)");
        } else if (fieldNumber == 1) {
            EQMS.ddl("UPDATE \"Employee\" SET \"address\" = " + data + " WHERE \"id\" = " + id);
        } else if (fieldNumber == 2) {
            EQMS.ddl("UPDATE \"Employee\" SET \"phoneNo\" = " + data + " WHERE \"id\" = " + id);
        } else if (fieldNumber == 4) {
            EQMS.ddl("INSERT INTO \"GraduatedWith\" VALUES(" + id + ',' + retrieveQualification(index).getId() + ")");
        } else if (fieldNumber == 5) {
            EQMS.ddl("INSERT INTO \"Achieve\" VALUES(" + id + ',' + retrieveAchievements().get(index).getId() + ")");

        }
    }
}
