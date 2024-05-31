/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.author;

import controllers.book.*;
import controller.ControllerFile;
import java.util.ArrayList;
import java.util.Comparator;
import models.Author;

public class AuthorController extends ControllerFile {
    public void sortByPrice(ArrayList<Author> x) {
//        x.sort(new Comparator<Author>() {
//            @Override
//            public int compare(Author o1, Author o2) {
//                return Double.compare(o1.getAuthorId(), o2.getAuthorId());
//            }
//        }); 
    }
    
    public ArrayList searchAuthor(ArrayList<Author> books, String name) {
        ArrayList<Author> list = new ArrayList<>();
        if(name.length() > 0) {
            for(Author x : list) {
                if(x.getName().equals(name)) {
                    list.add(x);
                }
            }
        }
        return list;
    }
}
