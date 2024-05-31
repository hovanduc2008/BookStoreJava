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
//    public void sortByPrice(ArrayList<Book> x) {
//        x.sort(new Comparator<Book>() {
//            @Override
//            public int compare(Book o1, Book o2) {
//                return Double.compare(o1.getPrice(), o2.getPrice());
//            }
//        }); 
//    }
    
    public ArrayList searchSupplier(ArrayList<Supplier> books, String id) {
        ArrayList<Supplier> list = new ArrayList<>();
        if(id.length() > 0) {
            for(Supplier x : list) {
                if(x.getPhoneNumber().equals(id)) {
                    list.add(x);
                }
            }
        }
        return list;
    }
}
