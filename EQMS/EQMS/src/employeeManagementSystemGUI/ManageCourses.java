/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeeManagementSystemGUI;

import eqms.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Yousuf Yasser Rabie
 */
public class ManageCourses extends javax.swing.JFrame {
    private ArrayList<Integer>SIDs;
    private ArrayList<Course> relevantCourses;
    private ArrayList<Course> selectedCourses;
    private DefaultListModel addedSkillsListModel;
    
    private int index;
    public ManageCourses() {
        initComponents();
        SIDs = new ArrayList<Integer>();
        addedSkillsListModel = new DefaultListModel();
        relevantCourses = new ArrayList<Course>();
        selectedCourses = new ArrayList<Course>();
        index = 0;
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        replaceInput.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        header = new javax.swing.JLabel();
        enterSkillIdInput = new javax.swing.JTextField();
        enterSkillIdLabel = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        submitButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        addedSkillsList = new javax.swing.JList<>();
        addedSkillsLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        header1 = new javax.swing.JLabel();
        skillIdLabel = new javax.swing.JLabel();
        availableCoursesLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AvailableCoursesList = new javax.swing.JList<>();
        chooseCourseInput = new javax.swing.JTextField();
        chooseCourseButton = new javax.swing.JButton();
        showSkillId1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        header2 = new javax.swing.JLabel();
        skillIdLabel1 = new javax.swing.JLabel();
        idDoesNotExistLabel = new javax.swing.JLabel();
        continueRButton = new javax.swing.JRadioButton();
        replaceRButton = new javax.swing.JRadioButton();
        selectButton = new javax.swing.JButton();
        replaceInput = new javax.swing.JTextField();
        showSkillId2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        header3 = new javax.swing.JLabel();
        skillIdLabel2 = new javax.swing.JLabel();
        noAvailableCoursesLabel = new javax.swing.JLabel();
        continueButton1 = new javax.swing.JButton();
        showSkillId3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        header.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        header.setText("Assign Courses");

        enterSkillIdLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        enterSkillIdLabel.setText("Enter skill id:");

        addButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        submitButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(addedSkillsList);

        addedSkillsLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        addedSkillsLabel.setText("Added skills");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(enterSkillIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(enterSkillIdInput, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(addButton)
                        .addGap(36, 36, 36)))
                .addGap(45, 45, 45))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(285, 285, 285)
                .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(301, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(68, 68, 68)
                    .addComponent(addedSkillsLabel)
                    .addGap(211, 211, 211))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(523, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enterSkillIdInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enterSkillIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addButton)
                .addGap(18, 18, 18)
                .addComponent(submitButton))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(addedSkillsLabel)
                    .addGap(14, 14, 14)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(48, Short.MAX_VALUE)))
        );

        header1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        header1.setText("Employee Management System");

        skillIdLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        skillIdLabel.setText("Skill ID:");

        availableCoursesLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        availableCoursesLabel.setText("Available Courses");

        jScrollPane1.setViewportView(AvailableCoursesList);

        chooseCourseInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseCourseInputActionPerformed(evt);
            }
        });

        chooseCourseButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        chooseCourseButton.setText("Choose course");
        chooseCourseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseCourseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(skillIdLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(showSkillId1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(availableCoursesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                        .addGap(371, 371, 371))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(chooseCourseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(chooseCourseInput, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(212, 212, 212)
                    .addComponent(header1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(184, 184, 184)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(chooseCourseInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chooseCourseButton))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(skillIdLabel)
                            .addComponent(showSkillId1))
                        .addGap(18, 18, 18)
                        .addComponent(availableCoursesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(header1)
                    .addContainerGap(215, Short.MAX_VALUE)))
        );

        header2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        header2.setText("Employee Management System");

        skillIdLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        skillIdLabel1.setText("Skill ID:");

        idDoesNotExistLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        idDoesNotExistLabel.setForeground(new java.awt.Color(255, 0, 0));
        idDoesNotExistLabel.setText("ID does not exist");

        continueRButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        continueRButton.setText("Continue");
        continueRButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continueRButtonActionPerformed(evt);
            }
        });

        replaceRButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        replaceRButton.setText("Replace");
        replaceRButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                replaceRButtonActionPerformed(evt);
            }
        });

        selectButton.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        selectButton.setText("Select");
        selectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addComponent(idDoesNotExistLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(138, Short.MAX_VALUE)
                        .addComponent(header2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(replaceRButton)
                                    .addComponent(continueRButton)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(skillIdLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(replaceInput, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(showSkillId2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(113, 113, 113))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(selectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(195, 195, 195))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(header2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(skillIdLabel1)
                    .addComponent(showSkillId2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(idDoesNotExistLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(replaceInput, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 49, Short.MAX_VALUE)
                        .addComponent(continueRButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(replaceRButton)))
                .addGap(18, 18, 18)
                .addComponent(selectButton)
                .addGap(18, 18, 18))
        );

        header3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        header3.setText("Employee Management System");

        skillIdLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        skillIdLabel2.setText("Skill ID:");

        noAvailableCoursesLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        noAvailableCoursesLabel.setForeground(new java.awt.Color(153, 0, 0));
        noAvailableCoursesLabel.setText("No available courses for this skill");

        continueButton1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        continueButton1.setText("Continue");
        continueButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continueButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(continueButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(noAvailableCoursesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(skillIdLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(showSkillId3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)))))
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(header3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(skillIdLabel2)
                    .addComponent(showSkillId3))
                .addGap(26, 26, 26)
                .addComponent(noAvailableCoursesLabel)
                .addGap(18, 18, 18)
                .addComponent(continueButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(header3)
                    .addGap(0, 181, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
       Integer skillId =  Integer.valueOf(enterSkillIdInput.getText());
       SIDs.add(skillId);
       addedSkillsListModel.addElement(skillId.toString());
       addedSkillsList.setModel(addedSkillsListModel);
    }//GEN-LAST:event_addButtonActionPerformed

    private void loopThroughCourses(){
        for(; index < SIDs.size();){
            if(ManageCourse.doesExist(SIDs.get(index))){
                relevantCourses.clear();
                relevantCourses = ManageCourse.pullOutSkill(SIDs.get(index));
                if(!relevantCourses.isEmpty()){
                    showSkillId1.setText(SIDs.get(index).toString());
                    jPanel2.setVisible(true);
                    DefaultListModel availableCoursesModelList = new DefaultListModel();
                    for(int j = 0; j < relevantCourses.size(); ++j){
                        Integer courseNumber = (j+1);
                        availableCoursesModelList.addElement(courseNumber.toString() + "- " + relevantCourses.get(j).displayCourse());
                    }
                    AvailableCoursesList.setModel(availableCoursesModelList);
                    return;
                }
                else{
                    showSkillId3.setText(SIDs.get(index).toString());
                    jPanel4.setVisible(true);
                    return;
                }
            }
            else{
                showSkillId2.setText(SIDs.get(index).toString());
                jPanel3.setVisible(true);
                return;
            }
        }
        
        if (selectedCourses.size() == 0){
            JOptionPane.showMessageDialog(null, "No courses to assign");
        } 
        else{   
            int NumofCourses = ManageCourse.assignCourses();
            String assignedCourses = "";
            for (Integer i = 1; i <= selectedCourses.size(); i++) {
                String pos = i.toString() + ". ";
                assignedCourses += pos + selectedCourses.get(i-1).getTitle() + "\n";
            }
            JOptionPane.showMessageDialog(null, NumofCourses + " courses were assigned successfully!\nThe chosen courses are: \n" + assignedCourses);
        }
        this.dispose();
    }
    
    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
       jPanel1.setVisible(false);
       loopThroughCourses();
    }//GEN-LAST:event_submitButtonActionPerformed

    private void chooseCourseInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseCourseInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chooseCourseInputActionPerformed

    private void chooseCourseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseCourseButtonActionPerformed
        int courseIndex = Integer.valueOf(chooseCourseInput.getText());
        if(courseIndex > relevantCourses.size()){
            JOptionPane.showMessageDialog(null, "Invalid input\n Please enter a number between 1 and " + relevantCourses.size());
        }
        else{
            selectedCourses.add(relevantCourses.get(courseIndex - 1));
            ManageCourse.addToList(SIDs.get(index), relevantCourses.get(courseIndex - 1));
            jPanel2.setVisible(false);
            index++;
            loopThroughCourses();
        }
    }//GEN-LAST:event_chooseCourseButtonActionPerformed

    private void replaceRButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_replaceRButtonActionPerformed
        replaceInput.setEnabled(true);
    }//GEN-LAST:event_replaceRButtonActionPerformed

    private void selectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectButtonActionPerformed
        jPanel3.setVisible(false);
        if(continueRButton.isSelected()){
            index++;
            loopThroughCourses();
        }
        else{
            Integer newId = Integer.valueOf(replaceInput.getText());
            SIDs.set(index, newId);
            
            loopThroughCourses();
        }
    }//GEN-LAST:event_selectButtonActionPerformed

    private void continueButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continueButton1ActionPerformed
        index++;
        loopThroughCourses();
        jPanel4.setVisible(false);
    }//GEN-LAST:event_continueButton1ActionPerformed

    private void continueRButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continueRButtonActionPerformed
        replaceInput.setEnabled(false);
    }//GEN-LAST:event_continueRButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageCourses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageCourses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageCourses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageCourses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageCourses().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> AvailableCoursesList;
    private javax.swing.JButton addButton;
    private javax.swing.JLabel addedSkillsLabel;
    private javax.swing.JList<String> addedSkillsList;
    private javax.swing.JLabel availableCoursesLabel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton chooseCourseButton;
    private javax.swing.JTextField chooseCourseInput;
    private javax.swing.JButton continueButton1;
    private javax.swing.JRadioButton continueRButton;
    private javax.swing.JTextField enterSkillIdInput;
    private javax.swing.JLabel enterSkillIdLabel;
    private javax.swing.JLabel header;
    private javax.swing.JLabel header1;
    private javax.swing.JLabel header2;
    private javax.swing.JLabel header3;
    private javax.swing.JLabel idDoesNotExistLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel noAvailableCoursesLabel;
    private javax.swing.JTextField replaceInput;
    private javax.swing.JRadioButton replaceRButton;
    private javax.swing.JButton selectButton;
    private javax.swing.JLabel showSkillId1;
    private javax.swing.JLabel showSkillId2;
    private javax.swing.JLabel showSkillId3;
    private javax.swing.JLabel skillIdLabel;
    private javax.swing.JLabel skillIdLabel1;
    private javax.swing.JLabel skillIdLabel2;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}
