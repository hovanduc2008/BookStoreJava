/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.supplier;

import controllers.book.*;
import controller.ControllerFile;
import java.util.ArrayList;
import java.util.Comparator;
import models.Supplier;

public class SupplierController extends ControllerFile {
    public void sortByName(ArrayList<Supplier> x) {
        x.sort(new Comparator<Supplier>() {
            @Override
            public int compare(Supplier o1, Supplier o2) {
                return o2.getName().compareTo(o1.getName());
            }
        }); 
    }
    
    public void sortByName2(ArrayList<Supplier> x) {
        x.sort(new Comparator<Supplier>() {
            @Override
            public int compare(Supplier o1, Supplier o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }); 
    }
    
    public ArrayList searchSupplier(ArrayList<Supplier> suppliers, String name) {
        ArrayList<Supplier> list = new ArrayList<>();
        if(name.length() > 0) {
            for(Supplier x : suppliers) {
                if(x.getName().equalsIgnoreCase(name) || x.getPhoneNumber().equalsIgnoreCase(name)) {
                    list.add(x);
                }
            }
        }
        return list;
    }
}
