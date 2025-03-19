/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloodtestapp;
import java.util.Stack;
import java.util.*;

/**
 *
 * @author canno
 */
public class BloodTestScheduler<T> implements BloodTestSchedulerInterface, BloodTestPriorityQueueInterface, NoShowQueueInterface{
    private Stack<T> bloodTestStack;
    private int size;
    private List<Patients> highPriorityList;
    private List<Patients> mediumPriorityList;
    private List<Patients> lowPriorityList;
    private List<Patients> sortedPatientsList; 
    private int currentPatientIndex = -1;
    
    public BloodTestScheduler(){//Initialize using Stack
        bloodTestStack = new Stack<>();  
        size = 0;
        highPriorityList = new ArrayList<>();
        mediumPriorityList = new ArrayList<>();
        lowPriorityList = new ArrayList<>();
        sortedPatientsList = new ArrayList<>();
    }
    
    public void push(T patient){//Push Patients to the right queues and lists
        bloodTestStack.push(patient);
        size++;
        if (patient instanceof Patients) {
            Patients p = (Patients) patient;

            switch (p.getPriority()) {
                case "High":
                    highPriorityList.add(p);
                    break;
                case "Medium":
                    mediumPriorityList.add(p);
                    break;
                case "Low":
                    lowPriorityList.add(p);
                    break;
            }
            updateSortedPatientsList(); 
        }
    }
    
    @Override
    public boolean isEmpty(){//Check if empty
        return(size ==0);
    }
    
    @Override 
    public int size(){//Check the size
        return size;
    }
    
    @Override
    public String displayAllPatients(){//Display all Patients
        if(isEmpty()){
            return "Patients Empty";
        }
         StringBuilder patientList = new StringBuilder();
        for(T patient : bloodTestStack) {
            patientList.append(patient).append("\n");
        }
        return patientList.toString();
        
    }
    
    @Override
    public String sortPatientsPriority() {//Sort by High, Medium, Low and Oldest to Youngest
        sortPatientsAge(highPriorityList);
        sortPatientsAge(mediumPriorityList);
        sortPatientsAge(lowPriorityList);

        StringBuilder finalPatientList = new StringBuilder();
        
        for (Patients p : highPriorityList) {
            finalPatientList.append(p).append("\n");
        }
        
        for (Patients p : mediumPriorityList) {
            finalPatientList.append(p).append("\n");
        }
        
        for (Patients p : lowPriorityList) {
            finalPatientList.append(p).append("\n");
        }
        return finalPatientList.toString();
    }

    private void sortPatientsAge(List<Patients> patientList) {//Sort by age Oldest to Youngest
        Collections.sort(patientList, new Comparator<Patients>() {
            @Override
            public int compare(Patients p1, Patients p2) {
                //Oldest patients first
                return Integer.compare(p2.getAge(), p1.getAge());
            }
        });
    }
    
    @Override
    public String displayFinalPatients() {//Display sorted Patients List
        return sortPatientsPriority();  
    }
    
    public void updateSortedPatientsList() {//Updates sorted Patient List wen necessary
        sortedPatientsList.clear();  
        sortedPatientsList.addAll(highPriorityList);
        sortedPatientsList.addAll(mediumPriorityList);
        sortedPatientsList.addAll(lowPriorityList);
    }

    @Override
    public String displayFirstPatient() {//Display the First Patient
        updateSortedPatientsList();
        if (!sortedPatientsList.isEmpty()) {
            currentPatientIndex = 0;  
            return sortedPatientsList.get(currentPatientIndex).toString();
        } else {
            return "No patients available.";
        }
    }

    @Override
    public String displayNextPatient() {//Display Next Patient
        if (sortedPatientsList != null && !sortedPatientsList.isEmpty()) {
            if (currentPatientIndex + 1 < sortedPatientsList.size()) {
                currentPatientIndex++; 
                return sortedPatientsList.get(currentPatientIndex).toString(); 
            } else {
                return "End of list.";  
            }
        } else {
            return "No patients available.";  
        }
    }

    @Override
    public String displayPrevPatient() {//Display Prev Patient
        if (sortedPatientsList != null && !sortedPatientsList.isEmpty()) {
            if (currentPatientIndex - 1 >= 0) {
                currentPatientIndex--;  
                return sortedPatientsList.get(currentPatientIndex).toString();  
            } else {
                return "Start of list.";  
            }
        } else {
            return "No patients available.";  
        }
    }
}