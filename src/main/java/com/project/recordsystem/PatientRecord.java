package com.project.recordsystem;

import java.time.LocalDate;

public class PatientRecord {
    private LocalDate visitDate;
    private String diagnosis;
    private String treatmentNotes;
    private PatientRecord next;
    private PatientRecord previous;

    public PatientRecord(LocalDate visitDate, String diagnosis, String treatmentNotes) {
        this.visitDate = visitDate;
        this.diagnosis = diagnosis;
        this.treatmentNotes = treatmentNotes;
        this.previous = null;
        this.next = null;
    }
}
