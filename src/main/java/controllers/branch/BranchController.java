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
    public ArrayList searchBranch(ArrayList<Branch> branches, String name) {
        ArrayList<Branch> list = new ArrayList<>();
        if(name.length() > 0) {
            for(Branch x : branches) {
                if(x.getName().equalsIgnoreCase(name)) {
                    list.add(x);
                }
            }
        }
        return list;
    }
}
