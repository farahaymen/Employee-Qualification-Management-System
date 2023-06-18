package eqms;

import java.util.ArrayList;

enum Gender {
    male,
    female
}

public class Employee {

    private static int count = 0;
    private int id;
    private long Ssn;
    private String name;
    private String address;
    private String password;
    private String email;
    private Long phoneNumber;
    private Gender gender;
    private String employmentDate;
    private String dateOfBirth;
    private ArrayList<EmployeeSkill> employeeSkills;
    private ArrayList<Qualification> qualifications;
    private ArrayList<Achievement> achievements;
    private Insurance insurance;
    private JobTitle jobTitle;
    
    private static int incrementAndGetCount() {
        return ++count;
    }

    public Employee() {
        id = 0;
        Ssn = 0;
        name = "";
        address = "";
        phoneNumber = 0L;
        gender = null;
        employmentDate = "";
        dateOfBirth = "";
        password = "";
        email = "";
        employeeSkills = new ArrayList<EmployeeSkill>();
        qualifications = new ArrayList<Qualification>();
        achievements = new ArrayList<Achievement>();
        insurance = null;
        jobTitle = null;
    }

    public Employee(int id, long Ssn, String name, String address, String password, String email, Long phoneNumber, String gender, String employmentDate, String dateOfBirth, ArrayList<EmployeeSkill> employeeSkills, ArrayList<Qualification> qualifications, ArrayList<Achievement> achievements, Insurance insurance, JobTitle jobTitle) {
        this.id = id;
        this.Ssn = Ssn;
        this.name = name;
        this.address = address;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = Gender.valueOf(gender);
        this.employmentDate = employmentDate;
        this.dateOfBirth = dateOfBirth;
        this.employeeSkills = employeeSkills;
        this.qualifications = qualifications;
        this.achievements = achievements;
        this.insurance = insurance;
        this.jobTitle = jobTitle;
    }
    
    public Employee(long Ssn, String name, String address, String password, String email, Long phoneNumber, String gender, String employmentDate, String dateOfBirth, ArrayList<EmployeeSkill> employeeSkills, ArrayList<Qualification> qualifications, ArrayList<Achievement> achievements, Insurance insurance, JobTitle jobTitle) {
        id = 100000 + incrementAndGetCount();
        this.Ssn = Ssn;
        this.name = name;
        this.address = address;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = Gender.valueOf(gender);
        this.employmentDate = employmentDate;
        this.dateOfBirth = dateOfBirth;
        this.employeeSkills = employeeSkills;
        this.qualifications = qualifications;
        this.achievements = achievements;
        this.insurance = insurance;
        this.jobTitle = jobTitle;
    }

    public Employee(long Ssn, String name, String address, String email, String password, Long phoneNumber, String gender, String employmentDate, String dateOfBirth, ArrayList<EmployeeSkill> employeeSkills, ArrayList<Qualification> qualifications, Insurance insurance, JobTitle jobTitle) {
        id = 100000 + incrementAndGetCount();
        this.Ssn = Ssn;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.gender = Gender.valueOf(gender);
        this.employmentDate = employmentDate;
        this.dateOfBirth = dateOfBirth;
        this.employeeSkills = employeeSkills;
        this.qualifications = qualifications;
        this.achievements = new ArrayList<>();
        this.insurance = insurance;
        this.password = password;
        this.email = email;
        this.jobTitle = jobTitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getSsn() {
        return Ssn;
    }

    public void setSsn(long Ssn) {
        this.Ssn = Ssn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(String employmentDate) {
        this.employmentDate = employmentDate;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void addDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public ArrayList<EmployeeSkill> getEmployeeSkills() {
        return employeeSkills;
    }

    public void addEmployeeSkill(EmployeeSkill employeeSkill) {
        this.employeeSkills.add(employeeSkill);
    }

    public ArrayList<Qualification> getQualifications() {
        return qualifications;
    }

    public void addQualifications(Qualification qualifications) {
        this.qualifications.add(qualifications);
    }

    public ArrayList<Achievement> getAchievements() {
        return achievements;
    }

    public void addAchievement(Achievement achievements) {
        this.achievements.add(achievements);
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitle jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", Ssn=" + Ssn + ", name=" + name + ", address=" + address + ", password=" + password + ", email=" + email + ", phoneNumber=" + phoneNumber + ", gender=" + gender + ", employmentDate=" + employmentDate + ", dateOfBirth=" + dateOfBirth + ", employeeSkills=" + employeeSkills + ", qualifications=" + qualifications + ", achievements=" + achievements + ", insurance=" + insurance + ", jobTitle=" + jobTitle + '}';
    }
    
    
}
