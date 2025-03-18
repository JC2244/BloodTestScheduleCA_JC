/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloodtestapp;

import java.util.Stack;

/**
 *
 * @author canno
 */
public class BloodTestScheduler<T> implements BloodTestSchedulerInterface, BloodTestPriorityQueueInterface, NoShowQueueInterface{
    private Stack<T> bloodTestStack;
    private int size;
    
    public BloodTestScheduler(){//Initialize using Stack
        bloodTestStack = new Stack<>();  
        size = 0;
    }
    
    public void push(T patient){
        bloodTestStack.push(patient);
        size++;
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
}
