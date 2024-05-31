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
    public void sortByPrice(ArrayList<Category> x) {
//        x.sort(new Comparator<Book>() {
//            @Override
//            public int compare(Book o1, Book o2) {
//                return Double.compare(o1.getPrice(), o2.getPrice());
//            }
//        }); 
    }
    
    public ArrayList searchCategory(ArrayList<Category> books, String name) {
        ArrayList<Category> list = new ArrayList<>();
        if(name.length() > 0) {
            for(Category x : list) {
                if(x.getName().equals(name)) {
                    list.add(x);
                }
            }
        }
        return list;
    }
}
