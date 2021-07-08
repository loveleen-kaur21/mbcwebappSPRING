package net.codejava.mbcwebapp;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Applications")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false, length = 100)
    private Long userId;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(name = "firstName", nullable = false, length = 20)
    private String firstName;

    @Column(name = "lastName", nullable = false, length = 20)
    private String lastName;

    @Column(name = "currentSchool", nullable = false)
    private String currentSchool;

    @Column(name = "gender", nullable = false, length = 15)
    private String gender;

    @Column(name = "race", nullable = false)
    private String race;

    @Column(name = "ethnicity", nullable = false)
    private String ethnicity;

    @Column(name = "commuteAbility", length = 3, nullable = false)
    private String commuteAbility;

    @Column(name="graduation", nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime graduation;

    @Column(name="age", nullable = false, length = 2)
    private int age;

    @Column(name = "phoneNumber", nullable = false, length = 10)
    private String phoneNumber;

    @Column(name = "parentFirstName", nullable = true, length = 20)
    private String parentFirstName;

    @Column(name = "parentLastName", nullable = true, length = 20)
    private String parentLastName;

    @Column(name = "parentEmail", nullable = true)
    private String parentEmail;

    @Column(name = "parentPhoneNumber", nullable = true, length = 10)
    private String parentPhoneNumber;

    @Column(name = "currentPlan", nullable = false)
    private String currentPlan;

    @Column(name = "aptitude", nullable = false)
    private String aptitude;

    @Column(name = "dedication", nullable = false)
    private String dedication;

    @Column(name = "passion", nullable = false)
    private String passion;

    @Column(name = "persistence", nullable = false)
    private String persistence;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "full_name", nullable = false)
    private String fullName;


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCurrentSchool() {
        return currentSchool;
    }

    public void setCurrentSchool(String currentSchool) {
        this.currentSchool = currentSchool;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getCommuteAbility() {
        return commuteAbility;
    }

    public void setCommuteAbility(String commuteAbility) {
        this.commuteAbility = commuteAbility;
    }

    public void setGraduation(LocalDateTime graduation) {
        this.graduation = graduation;
    }
    public LocalDateTime getGraduation() {
        return graduation;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getParentFirstName() {
        return parentFirstName;
    }

    public void setParentFirstName(String parentFirstName) {
        this.parentFirstName = parentFirstName;
    }

    public String getParentLastName() {
        return parentLastName;
    }

    public void setParentLastName(String parentLastName) {
        this.parentLastName = parentLastName;
    }

    public String getParentEmail() {
        return parentEmail;
    }

    public void setParentEmail(String parentEmail) {
        this.parentEmail = parentEmail;
    }

    public String getParentPhoneNumber() {
        return parentPhoneNumber;
    }

    public void setParentPhoneNumber(String parentPhoneNumber) {
        this.parentPhoneNumber = parentPhoneNumber;
    }

    public String getCurrentPlan() {
        return currentPlan;
    }

    public void setCurrentPlan(String currentPlan) {
        this.currentPlan = currentPlan;
    }

    public String getAptitude() {
        return aptitude;
    }

    public void setAptitude(String aptitude) {
        this.aptitude = aptitude;
    }

    public String getDedication() {
        return dedication;
    }

    public void setDedication(String dedication) {
        this.dedication = dedication;
    }

    public String getPassion() {
        return passion;
    }

    public void setPassion(String passion) {
        this.passion = passion;
    }

    public String getPersistence() {
        return persistence;
    }

    public void setPersistence(String persistence) {
        this.persistence = persistence;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserid(Long userId) {
        this.userId = userId;
    }

}




