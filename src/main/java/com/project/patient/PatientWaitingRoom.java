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
           System.out.println("Waiting room created");
           return;
       } else if (location == 0) {
            newNode.setNext(head);
            head = newNode;
       } else if (location >= size) {
           tail.setNext(newNode);
           tail = newNode;
       }
       size++;
   }

    public void serveNextPatientInLine(){
        if(head == null){
            System.out.println("Waiting room is empty");
            return;
        }
        head = head.getNext();
        size--;
    }

    public void printPatientWaitingRoomList(){
       if(head == null){
           System.out.println("Waiting room is empty");
           return;
       }
       PatientNode tempNode = head;
       int numberOfPatientInWaitingRoom = 0;
       for(int i = 0; i < size; i++){
           System.out.println(tempNode.getPatientInformation().toString());
           tempNode = tempNode.getNext();
           numberOfPatientInWaitingRoom++;
       }
        System.out.println(numberOfPatientInWaitingRoom + " of patient(s) waiting.");
    }
}
