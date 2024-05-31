/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.orderdetail;

import controllers.order.*;
import controllers.book.*;
import controller.ControllerFile;
import java.util.ArrayList;
import java.util.Comparator;
import models.OrderDetail;

public class OrderDetailController extends ControllerFile {
//    public void sortByPrice(ArrayList<Order> x) {
//        x.sort(new Comparator<Order>() {
//            @Override
//            public int compare(Order o1, Order o2) {
//                return Double.compare(o1.getPrice(), o2.getPrice());
//            }
//        }); 
//    }
    
    public ArrayList searchOrderDetail(ArrayList<OrderDetail> order_details, int id) {
        ArrayList<OrderDetail> list = new ArrayList<>();
        if(true) {
            for(OrderDetail x : list) {
                if(x.getOrderID() == id) {
                    list.add(x);
                }
            }
        }
        return list;
    }
}
