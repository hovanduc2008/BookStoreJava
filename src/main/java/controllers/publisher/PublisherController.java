/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.publisher;

import controllers.book.*;
import controller.ControllerFile;
import java.util.ArrayList;
import java.util.Comparator;
import models.Publisher;

public class PublisherController extends ControllerFile {
//    public void sortByPrice(ArrayList<Publisher> x) {
//        x.sort(new Comparator<Publisher>() {
//            @Override
//            public int compare(Publisher o1, Publisher o2) {
//                return Double.compare(o1.getPrice(), o2.getPrice());
//            }
//        }); 
//    }
    
    public ArrayList searchPublisher(ArrayList<Publisher> publishers, String phone) {
        ArrayList<Publisher> list = new ArrayList<>();
        if(phone.length() > 0) {
            for(Publisher x : list) {
                if(x.getPhoneNumber().equals(phone)) {
                    list.add(x);
                }
            }
        }
        return list;
    }
}
