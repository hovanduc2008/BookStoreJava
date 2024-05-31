package models;


import java.io.Serializable;

public class Category implements Serializable {
    private static final long serialVersionUID = -3971165505482975091L;
    public int getCateID() {
        return cateID;
    }

    public void setCateID(int cateID) {
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

    public Category(int cateID, String name, String description) {
        this.cateID = cateID;
        this.name = name;
        this.description = description;
    }

    private int cateID;
    private String name;
    private String description;
}
