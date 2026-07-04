package com.project.patientrecord;

import java.time.LocalDate;

public class PatientRecord {
    private LocalDate visitDate;
    private String diagnosis;
    private String treatmentNotes;
    private PatientRecord next;
    private PatientRecord previous;
    private int value;

    public PatientRecord(){
    }

    public PatientRecord(LocalDate visitDate, String diagnosis, String treatmentNotes) {
        this.visitDate = visitDate;
        this.diagnosis = diagnosis;
        this.treatmentNotes = treatmentNotes;
        this.previous = null;
        this.next = null;
    }

    public PatientRecord getNext() {
        return next;
    }

    public void setNext(PatientRecord next) {
        this.next = next;
    }

    public PatientRecord getPrevious() {
        return previous;
    }

    public void setPrevious(PatientRecord previous) {
        this.previous = previous;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTreatmentNotes() {
        return treatmentNotes;
    }

    public void setTreatmentNotes(String treatmentNotes) {
        this.treatmentNotes = treatmentNotes;
    }
}
