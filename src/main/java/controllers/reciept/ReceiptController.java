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
    public ArrayList searchReceipt(ArrayList<Receipt> receipts , int id) {
        ArrayList<Receipt> list = new ArrayList<>();
        for(Receipt x : receipts) {
                if(x.getReceiptId() == id) {
                    list.add(x);
                }
            }
        return list;
    }
}
