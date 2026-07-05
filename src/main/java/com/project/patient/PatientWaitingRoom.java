package com.project.patient;

public class PatientWaitingRoom {
    private PatientNode head;
    private PatientNode tail;
    private int size;

   public PatientWaitingRoom(){
       this.head = null;
       this.tail = null;
       this.size = 0;
   }

    public PatientNode getHead() {
        return head;
    }

    public void setHead(PatientNode head) {
        this.head = head;
    }

    public PatientNode getTail() {
        return tail;
    }

    public void setTail(PatientNode tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void createWaitingRoom(Patient firstPatient){
       PatientNode newNode = new PatientNode(firstPatient);
        head = newNode;
        tail = newNode;
        size++;
    }

   public void addPatient(Patient newPatient, int location){
       PatientNode newNode = new PatientNode(newPatient);

       if(head == null){
           createWaitingRoom(newPatient);
           System.out.println("\nPatient added to waiting room");
           return;
       } else if (location == 0) {
            newNode.setNext(head);
            head = newNode;
           System.out.println("Patient added to waiting room");
       } else if (location >= size) {
           tail.setNext(newNode);
           tail = newNode;
       }
       size++;
   }

    public Patient serveNextPatientInLine(){
        if(head == null){
            System.out.println("Waiting room is empty");
            return null;
        }
        Patient nextPatientToServe = head.getPatientInformation();
        head = head.getNext();
        size--;
        return nextPatientToServe;
    }

    public void displayPatientWaitingRoomList(){
       if(head == null){
           System.out.println("Waiting room is empty");
           return;
       }
       PatientNode tempNode = head;
       for(int i = 0; i < size; i++){
           System.out.println(tempNode.getPatientInformation().toString());
           tempNode = tempNode.getNext();
       }
        System.out.println(size + " patient(s) waiting.");
    }
}
