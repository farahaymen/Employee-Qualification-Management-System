package eqms;

import static eqms.AddEmployee.retrieveAchievements;
import static eqms.AddEmployee.retrieveInsurances;
import static eqms.AddEmployee.retrieveJobTitles;
import static eqms.AddEmployee.retrieveQualification;
import static eqms.AddEmployee.retrieveSkills;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author amro
 */
public class UpdateEmployee {
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
    
    public static JobTitle retrieveJobTitle(int jobTitlesNumber) {
        return retrieveJobTitles().get(jobTitlesNumber - 1);
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
        ArrayList<Qualification> qualifications = new ArrayList<Qualification>();
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

    public static ArrayList<Employee> retrieveEmployees() {
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
    
    public static ArrayList<Qualification> retrieveEmployeeQualifications(int id) {
        ArrayList<Qualification> employeeQualifications = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(EQMS.connectionURL, "bue", "bue");
            String sql = "SELECT * FROM \"GraduatedWith\"";
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
}
