/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.branch;

import controllers.book.*;
import controller.ControllerFile;
import java.util.ArrayList;
import java.util.Comparator;
import models.Branch;

public class BranchController extends ControllerFile {
    public void sortByPrice(ArrayList<Branch> x) {
//        x.sort(new Comparator<Branch>() {
//            @Override
//            public int compare(Branch o1, Branch o2) {
//                return Double.compare(o1.getPrice(), o2.getPrice());
//            }
//        }); 
    }
    
    public ArrayList searchBranch(ArrayList<Branch> books, String name) {
        ArrayList<Branch> list = new ArrayList<>();
        if(name.length() > 0) {
            for(Branch x : list) {
                if(x.getName().equals(name)) {
                    list.add(x);
                }
            }
        }
        return list;
    }
}
