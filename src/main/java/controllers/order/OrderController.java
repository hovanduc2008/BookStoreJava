/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.order;

import controllers.book.*;
import controller.ControllerFile;
import java.util.ArrayList;
import java.util.Comparator;
import models.Order;

public class OrderController extends ControllerFile {
//    public void sortByPrice(ArrayList<Order> x) {
//        x.sort(new Comparator<Order>() {
//            @Override
//            public int compare(Order o1, Order o2) {
//                return Double.compare(o1.getPrice(), o2.getPrice());
//            }
//        }); 
//    }
    
    public ArrayList searchOrder(ArrayList<Order> books, String id) {
        ArrayList<Order> list = new ArrayList<>();
        if(id.length() > 0) {
            for(Order x : list) {
                if(x.getOrderId().equals(id)) {
                    list.add(x);
                }
            }
        }
        return list;
    }
}
