package com.project.patient;

public class PatientNode {
    private PatientNode next;
    private Patient patientInformation;

    public PatientNode(Patient patientInformation){
        this.next = null;
        this.patientInformation = patientInformation;
    }

    public PatientNode getNext() {
        return next;
    }

    public void setNext(PatientNode next) {
        this.next = next;
    }

    public Patient getPatientInformation() {
        return patientInformation;
    }

    public void setPatientInformation(Patient patientInformation) {
        this.patientInformation = patientInformation;
    }
}
