/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bloodtestapp;


/**
 *
 * @author canno
 */
public class BloodTestApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       BloodTestGUI mygui = new BloodTestGUI();
       mygui.setVisible(true);
       
       //Create a BloodTestScheduler for Patients objects
        BloodTestScheduler<Patients> patientStack = new BloodTestScheduler<>();
        
        //Hard Code Test Patients
        patientStack.push(new Patients("John Doe", 30, "High", "Hospital Ward"));
        patientStack.push(new Patients("Jane Doe", 25, "Medium", "Local GP"));
        patientStack.push(new Patients("Ann Doe", 78, "High", "Hospital Ward"));
        patientStack.push(new Patients("Bell Doe", 29, "High", "Local GP"));
        patientStack.push(new Patients("Clare Doe", 38, "Medium", "Public Clinic"));
        patientStack.push(new Patients("Darla Doe", 49, "High", "Local GP"));
        patientStack.push(new Patients("Emma Doe", 16, "Medium", "Local GP"));
        patientStack.push(new Patients("Frank Doe", 34, "Low", "Local GP"));
        patientStack.push(new Patients("Greg Doe", 16, "Low", "Local GP"));
        patientStack.push(new Patients("Harry Doe", 54, "High", "Hospital Ward"));
        patientStack.push(new Patients("Indigo Doe", 38, "medium", "Public Clinic"));
        patientStack.push(new Patients("Jules Doe", 16, "Low", "Local GP"));
        patientStack.push(new Patients("Kate Doe", 28, "Medium", "Hospital Ward"));
        patientStack.push(new Patients("Lola Doe", 76, "Low", "Public Clinic"));
        patientStack.push(new Patients("Mia Doe", 65, "High", "Hospital Ward"));
        
        //Display to BloodTestGUI
        String allPatients = patientStack.displayAllPatients();  
        mygui.displayAllPatients(allPatients);  
        String finalPatientList = patientStack.displayFinalPatients();  
        mygui.displayFinalPatients(finalPatientList);  
        String firstPatient = patientStack.displayFirstPatient();  
        mygui.displayFirstPatient(firstPatient);

    }
    
}
