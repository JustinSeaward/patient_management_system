package com.project;

import com.project.patientrecord.PatientHistorySystem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.project.patient.Patient;
import com.project.patient.PatientWaitingRoom;

import java.time.LocalDate;

public class UnitTest {
    private PatientWaitingRoom waitingRoom;
    private Patient patient1;
    private Patient patient2;
    private Patient patient3;
    private PatientHistorySystem historySystem;

    @BeforeEach
    public void setUp() {
        waitingRoom = new PatientWaitingRoom();
        patient1 = new Patient(1, "Rusty", "Shakelford", "709-123-4567", LocalDate.of(1989,1,1), "Lower back");
        patient2 = new Patient(2,"Homer", "Simpson", "800-555-1234", LocalDate.of(1968,5,5),"Lump on head");
        patient3 = new Patient(3,"Hank", "Hill", "800-555-5678",LocalDate.of(1970,6,6),"Burn from propane");
        historySystem = new PatientHistorySystem();
        historySystem.insertPatientRecord(LocalDate.of(2022,1,15),"Routine Checkup","Patient is healthy. Recommended daily vitamins.");
        historySystem.insertPatientRecord(LocalDate.of(2023,6,10),"Sprained Ankle","Prescribed rest, ice, compression, and elevation (RICE).");
        historySystem.insertPatientRecord(LocalDate.of(2024,2,20),"Seasonal Flu","Prescribed fluids and rest. Expected recovery in 1 week.");
    }

    @Test
    public void testCreateWaitingRoom(){
        waitingRoom.createWaitingRoom(patient1);

        Assertions.assertEquals(1, waitingRoom.getSize());
        Assertions.assertEquals(patient1, waitingRoom.getHead().getPatientInformation());
        Assertions.assertEquals(patient1, waitingRoom.getTail().getPatientInformation());
    }

    @Test
    public void testAddPatientToBackOfQueue(){
        waitingRoom.addPatient(patient1, 1);
        waitingRoom.addPatient(patient2, 1);

        Assertions.assertEquals(2,waitingRoom.getSize());
        Assertions.assertEquals(patient1, waitingRoom.getHead().getPatientInformation());
        Assertions.assertEquals(patient2, waitingRoom.getTail().getPatientInformation());
    }

    @Test
    public void testAddEmergencyPatient() {
        waitingRoom.addPatient(patient1,1);
        waitingRoom.addPatient(patient2,1);
        waitingRoom.addPatient(patient3,0);

        Assertions.assertNotEquals(patient1, waitingRoom.getHead().getPatientInformation());
        Assertions.assertEquals(patient3, waitingRoom.getHead().getPatientInformation());
        Assertions.assertEquals(3,waitingRoom.getSize());
        Assertions.assertEquals(patient2,waitingRoom.getTail().getPatientInformation());
    }

    @Test
    public void testServingNextPatientInLine(){
        waitingRoom.addPatient(patient1, 1);
        waitingRoom.addPatient(patient2, 1);
        waitingRoom.addPatient(patient3, 1);

        Assertions.assertEquals(3,waitingRoom.getSize());
        waitingRoom.serveNextPatientInLine();
        Assertions.assertEquals(2,waitingRoom.getSize());
        Assertions.assertEquals(patient2,waitingRoom.getHead().getPatientInformation());
    }

    @Test
    public void testNavigationForPreviousRecords(){
        historySystem.displayNewestPatientRecord();
        historySystem.moveToPreviousPatientRecord();

        Assertions.assertEquals("Sprained Ankle", historySystem.getCurrentView().getDiagnosis());
    }

    @Test
    public void testNoCrashTryingToGoAheadOfOldestRecord() {
        historySystem.displayOldestPatientRecord();
        historySystem.moveToPreviousPatientRecord();

        Assertions.assertEquals("Routine Checkup",historySystem.getCurrentView().getDiagnosis());
    }

    @Test
    public void testNavigationForNextRecords(){
        historySystem.displayOldestPatientRecord();
        historySystem.moveToNextPatientRecord();

        Assertions.assertEquals("Sprained Ankle", historySystem.getCurrentView().getDiagnosis());
    }

    @Test
    public void testNoCrashTryingToMovePassNewestRecord() {
        historySystem.displayNewestPatientRecord();
        historySystem.moveToNextPatientRecord();

        Assertions.assertEquals("Seasonal Flu",historySystem.getCurrentView().getDiagnosis());
    }
}
