/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.reciept;

import controllers.book.*;
import controller.ControllerFile;
import java.util.ArrayList;
import java.util.Comparator;
import models.Receipt;

public class ReceiptController extends ControllerFile {
//    public void sortByPrice(ArrayList<Receipt> x) {
//        x.sort(new Comparator<Receipt>() {
//            @Override
//            public int compare(Receipt o1, Receipt o2) {
//                return Double.compare(o1.getPrice(), o2.getPrice());
//            }
//        }); 
//    }
    
    public ArrayList searchReceipt(ArrayList<Receipt> books, String id) {
        ArrayList<Receipt> list = new ArrayList<>();
        if(id.length() > 0) {
            for(Receipt x : list) {
                if(x.getSupplier().equals(id)) {
                    list.add(x);
                }
            }
        }
        return list;
    }
}
