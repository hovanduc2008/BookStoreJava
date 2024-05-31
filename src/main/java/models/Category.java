package models;


import java.io.Serializable;

public class Category implements Serializable {

    public String getCateID() {
        return cateID;
    }

    public void setCateID(String cateID) {
        this.cateID = cateID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category(String cateID, String name, String description) {
        this.cateID = cateID;
        this.name = name;
        this.description = description;
    }

    private String cateID;
    private String name;
    private String description;
}
