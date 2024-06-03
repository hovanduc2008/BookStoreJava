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
    public void sortByName(ArrayList<Author> x) {
        x.sort(new Comparator<Author>() {
            @Override
            public int compare(Author o1, Author o2) {
                return o2.getName().compareTo(o1.getName());
            }
        }); 
    }
    
    public void sortByName2(ArrayList<Author> x) {
        x.sort(new Comparator<Author>() {
            @Override
            public int compare(Author o1, Author o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }); 
    }
    
    public ArrayList searchAuthor(ArrayList<Author> authors, String name) {
        ArrayList<Author> list = new ArrayList<>();
        if(name.length() > 0) {
            for(Author x : authors) {
                if(x.getName().equalsIgnoreCase(name)) {
                    list.add(x);
                }
            }
        }
        return list;
    }
}
