package controller;

public interface Controller {
    
    public void writeToFile(Object obj, String fileName);
    
    public Object readDataFromFile(String fileName);   
}
