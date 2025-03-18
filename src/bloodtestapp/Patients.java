/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloodtestapp;

/**
 *
 * @author canno
 */
public class Patients {
    //Declare Variables
    private String name;
    private int age;
    private String priority;
    private String gpDetails;
    
    //Constructor
    public Patients(String name, int age, String priority, String gpDetails) {
        this.name = name;
        this.age = age;
        this.priority = priority;
        this.gpDetails = gpDetails;
    }
    
    //Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPriority() {
        return priority;
    }

    public String getGpDetails() {
        return gpDetails;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setGpDetails(String gpDetails) {
        this.gpDetails = gpDetails;
    }
    
    @Override
    public String toString() {
        return "Patient Name: " + name + ", Age: " + age + ", Priority: " + priority + ", GP: " + gpDetails;
    }
    
}
