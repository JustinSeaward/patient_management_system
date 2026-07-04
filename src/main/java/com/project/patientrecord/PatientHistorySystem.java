package com.project.patientrecord;

import java.time.LocalDate;

public class PatientHistorySystem {
    private PatientRecord head;
    private PatientRecord tail;
    private PatientRecord currentView;
    private int size;

    public PatientRecord getCurrentView() {
        return currentView;
    }

    public PatientRecord createPatientRecord(LocalDate visitData, String diagnosis, String treatmentNotes){
        PatientRecord patientRecord = new PatientRecord(visitData, diagnosis, treatmentNotes);
        head = patientRecord;
        tail = patientRecord;
        size = 1;
        return head;
    }

    public void insertPatientRecord(LocalDate visitDate, String diagnosis, String treatmentNotes){
        PatientRecord newRecord = new PatientRecord(visitDate, diagnosis, treatmentNotes);
        if (head == null){
            createPatientRecord(visitDate, diagnosis, treatmentNotes);
            return;
        }
        newRecord.setPrevious(tail);
        tail.setNext(newRecord);
        tail = newRecord;
        size++;
    }

    public void displayNewestPatientRecord(){
        if(tail == null){
            System.out.println("No record to display");
            return;
        }
        currentView = tail;
        System.out.println(currentView.getVisitDate());
        System.out.println(currentView.getDiagnosis());
        System.out.println(currentView.getTreatmentNotes());
    }

    public void displayOldestPatientRecord(){
        if(head == null){
            System.out.println("No record to display");
            return;
        }
        currentView = head;
        System.out.println(currentView.getVisitDate());
        System.out.println(currentView.getDiagnosis());
        System.out.println(currentView.getTreatmentNotes());
    }

    public void moveToNextPatientRecord() {
        if(tail == currentView){
            System.out.println("You have reached newest patient record");
            return;
        }
        currentView = currentView.getNext();
        System.out.println(currentView.getVisitDate());
        System.out.println(currentView.getDiagnosis());
        System.out.println(currentView.getTreatmentNotes());
    }

    public void moveToPreviousPatientRecord(){
        if(head == currentView){
            System.out.println("You have reach the oldest patient record");
            return;
        }
        currentView = currentView.getPrevious();
        System.out.println(currentView.getVisitDate());
        System.out.println(currentView.getDiagnosis());
        System.out.println(currentView.getTreatmentNotes());
    }
}
