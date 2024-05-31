/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.customer;

import controllers.book.*;
import controller.ControllerFile;
import java.util.ArrayList;
import java.util.Comparator;
import models.Customer;

public class CustomerController extends ControllerFile {
//    public void sortByPrice(ArrayList<Book> x) {
//        x.sort(new Comparator<Book>() {
//            @Override
//            public int compare(Book o1, Book o2) {
//                return Double.compare(o1.getPrice(), o2.getPrice());
//            }
//        }); 
//    }
    
    public ArrayList searchBook(ArrayList<Customer> customers, String phone) {
        ArrayList<Customer> list = new ArrayList<>();
        if(phone.length() > 0) {
            for(Customer x : list) {
                if(x.getPhoneNumber().equals(phone)) {
                    list.add(x);
                }
            }
        }
        return list;
    }
}
