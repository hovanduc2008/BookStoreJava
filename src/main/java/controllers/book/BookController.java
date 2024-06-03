/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.book;

import controller.ControllerFile;
import java.util.ArrayList;
import java.util.Comparator;
import models.Book;

public class BookController extends ControllerFile {
    public void sortByPrice(ArrayList<Book> x) {
        x.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        }); 
    }
    
    public void sortByPrice2(ArrayList<Book> x) {
        x.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return Double.compare(o2.getPrice(), o1.getPrice());
            }
        }); 
    }
    
    public ArrayList searchBook(ArrayList<Book> books, String searchKey) {
        ArrayList<Book> list = new ArrayList<>();
        if(searchKey.length() > 0) {
            for(Book x : books) {
                if(x.getISBN().equals(searchKey) || x.getTitle().equalsIgnoreCase(searchKey)) {
                    list.add(x);
                }
            }
        }
        return list;
    }
}
