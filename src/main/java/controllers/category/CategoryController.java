/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.category;

import controllers.book.*;
import controller.ControllerFile;
import java.util.ArrayList;
import java.util.Comparator;
import models.Category;

public class CategoryController extends ControllerFile {
    public void sortByName(ArrayList<Category> x) {
        x.sort(new Comparator<Category>() {
            @Override
            public int compare(Category o1, Category o2) {
                return o2.getName().compareTo(o1.getName());
            }
        }); 
    }
    
    public void sortByName2(ArrayList<Category> x) {
        x.sort(new Comparator<Category>() {
            @Override
            public int compare(Category o1, Category o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }); 
    }
    
    public ArrayList searchCategory(ArrayList<Category> categories, String name) {
        ArrayList<Category> list = new ArrayList<>();
        if(name.length() > 0) {
            for(Category x : categories) {
                if(x.getName().equalsIgnoreCase(name)) {
                    list.add(x);
                }
            }
        }
        return list;
    }
}
