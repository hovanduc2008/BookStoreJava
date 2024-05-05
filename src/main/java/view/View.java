/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package view;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public interface View {
    
    <T> void showData(ArrayList<T> list, DefaultTableModel model);
    
}
