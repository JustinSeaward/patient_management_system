package com.project.patientrecord;

import java.time.LocalDate;

public class PatientHistorySystem {
    private PatientRecord head;
    private PatientRecord tail;
    private int size;

    public PatientRecord createPatientRecord(LocalDate visitData, String diagnosis, String treatmentNotes){
        PatientRecord patientRecord = new PatientRecord(visitData, diagnosis, treatmentNotes);
        head = patientRecord;
        tail = patientRecord;
        size = 1;
        return head;
    }

    public void insertPatientRecord(LocalDate visitData, String diagnosis, String treatmentNotes){

    }
}
