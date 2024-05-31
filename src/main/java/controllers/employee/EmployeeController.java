/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.employee;

import controllers.book.*;
import controller.ControllerFile;
import java.util.ArrayList;
import java.util.Comparator;
import models.Employee;

public class EmployeeController extends ControllerFile {
//    public void sortByPrice(ArrayList<Employee> x) {
//        x.sort(new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                return Double.compare(o1.getPrice(), o2.getPrice());
//            }
//        }); 
//    }
    
    public ArrayList searchEmployee(ArrayList<Employee> employees, String id) {
        ArrayList<Employee> list = new ArrayList<>();
        if(id.length() > 0) {
            for(Employee x : list) {
                if(x.getPhoneNumber().equals(id)) {
                    list.add(x);
                }
            }
        }
        return list;
    }
}
