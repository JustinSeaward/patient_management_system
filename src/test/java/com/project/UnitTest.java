package com.project;

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

    @BeforeEach
    public void setUp() {
        waitingRoom = new PatientWaitingRoom();
        patient1 = new Patient(1, "Rusty", "Shakelford", "709-123-4567", LocalDate.of(1989,1,1), "Lower back");
        patient2 = new Patient(2,"Homer", "Simpson", "800-555-1234", LocalDate.of(1968,5,5),"Lump on head");
        patient3 = new Patient(3,"Hank", "Hill", "800-555-5678",LocalDate.of(1970,6,6),"Burn from propane");
    }

    @Test
    public void testAddPatientToQueue(){
        waitingRoom.addPatient(patient1);
        Assertions.assertEquals(patient1,waitingRoom.serveNextPatient());
    }

    @Test
    public void testServeNextPatientInQueue(){
        Assertions.assertNull(waitingRoom.serveNextPatient());

        waitingRoom.addPatient(patient1);
        waitingRoom.addPatient(patient2);
        waitingRoom.addPatient(patient3);

        Assertions.assertNotNull(waitingRoom.serveNextPatient());
    }

    @Test
    public void testAddEmergencyPatientIntoFrontOfQueue(){
        waitingRoom.addPatient(patient1);
        waitingRoom.addPatient(patient2);
        Assertions.assertEquals(patient1, waitingRoom.serveNextPatient());

        waitingRoom.addEmergencyPatient(patient3,0);

        Assertions.assertEquals(patient3, waitingRoom.serveNextPatient());
    }
}
