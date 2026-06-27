package com.project.patient;

import java.util.LinkedList;

public class PatientWaitingRoom {
    private LinkedList<Patient> queue;

    public PatientWaitingRoom(){
        this.queue = new LinkedList<>();
    }

    public LinkedList<Patient> getQueue() {
        return queue;
    }

    public void setQueue(LinkedList<Patient> queue) {
        this.queue = queue;
    }

    public void addPatient(Patient patient){
        queue.add(patient);
    }

    public Patient serveNextPatient() {
        if(queue.isEmpty()){
            System.out.println("The waiting room is empty.");
            return null;
        }
        return queue.removeFirst();
    }

    public void addEmergencyPatient(Patient patient, int location){
        queue.add(location, patient);
    };

    public void printAllPatientsInQueue(){
        if (queue.isEmpty()) {
            System.out.println("The waiting room is currently empty.");
            return;
        }

        System.out.println("Patients currently waiting...");
        for(Patient patient : queue){
            System.out.println(patient.toString());
        }
    }


}
