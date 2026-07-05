package com.project.patient;

import com.project.patientrecord.PatientHistorySystem;

import java.time.LocalDate;

public class Patient {

    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private String reasonForVisit;
    private PatientHistorySystem patientRecordFolder = new PatientHistorySystem();

    public Patient(){
    }

    public Patient(int id, String firstName, String lastName, String phoneNumber, LocalDate dataOfBirth, String reasonForVisit){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dataOfBirth;
        this.reasonForVisit = reasonForVisit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getReasonForVisit() {
        return reasonForVisit;
    }

    public void setReasonForVisit(String reasonForVisit) {
        this.reasonForVisit = reasonForVisit;
    }

    public PatientHistorySystem getPatientRecordFolder() {
        return patientRecordFolder;
    }

    @Override
    public String toString() {
        return "\nPatient - " +
                "Id: " + id + "\n" +
                "First Name: " + firstName + "\n" +
                "Last Name: " + lastName + "\n" +
                "Phone Number: " + phoneNumber + "\n" +
                "Date of Birth: " + dateOfBirth + "\n" +
                "Reason for Visit: " + reasonForVisit + "\n";
    }
}
